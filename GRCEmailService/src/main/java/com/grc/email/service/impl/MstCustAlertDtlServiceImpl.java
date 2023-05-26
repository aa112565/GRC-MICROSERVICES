package com.grc.email.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grc.email.common.utils.MapperUtils;
import com.grc.email.dto.AlertAuditDTO;
import com.grc.email.dto.AuditAttachmentDTO;
import com.grc.email.dto.MstCustAlertDtlDTO;
import com.grc.email.dto.MstCustAlertDtlDTOSub;
import com.grc.email.entity.AlertAudit;
import com.grc.email.entity.AuditAttachment;
import com.grc.email.entity.CnfgStatusAction;
import com.grc.email.entity.MstCustAlertDtl;
import com.grc.email.repository.AlertAuditRepository;
import com.grc.email.repository.AuditAttachmentRepository;
import com.grc.email.repository.CnfgStatusActionRepository;
import com.grc.email.repository.MstCustAlertDtlRepository;
import com.grc.email.service.MstCustAlertDtlService;

@Service
public class MstCustAlertDtlServiceImpl implements MstCustAlertDtlService {
	@Resource MstCustAlertDtlRepository alertRepo;
	@Resource AlertAuditRepository alertAuditRepo;
	@Resource AuditAttachmentRepository auditAttachmentRepo;
	@Resource CnfgStatusActionRepository statusActionRepo;
	
	@Override
	public List<MstCustAlertDtlDTO> getAllAlerts(){
		return MapperUtils.mapToTargetClass(alertRepo.findAll(), MstCustAlertDtlDTO.class);
	}
	
	@Override
	public List<MstCustAlertDtlDTO> getAllAlertsForUser(String userid){
		return MapperUtils.mapToTargetClass(alertRepo.findByAssignedUserId(userid), MstCustAlertDtlDTO.class);
	}
	
	@Override
	public Integer saveAlerts(List<MstCustAlertDtlDTO> alerts) {
		List<AlertAuditDTO> alertAudit = new ArrayList<>();
		List<MstCustAlertDtlDTOSub> subs = new ArrayList<>();
		for(MstCustAlertDtlDTO temp : alerts) {
			Optional<String> nextLvl = determineNextLevel(temp.getStage(), temp.getStatus(), temp.getAction());
			String nextLevel = (!nextLvl.isPresent())?temp.getStage():nextLvl.get();
			//if(!nextLvl.isPresent()) throw new RuntimeException("Unable to determine next level");
			Optional<String> nextUser = determineNextUser(temp.getCustomerId(),temp.getAssignedUserId(), temp.getStage(), temp.getStatus(), temp.getAction());
			String nextUsr = (!nextUser.isPresent())?temp.getAssignedUserId():nextUser.get();
			//if(!nextUser.isPresent()) throw new RuntimeException("Unable to determine next user");
			AlertAuditDTO auditRow = new AlertAuditDTO(temp.getSrNo(), temp.getStatus(), temp.getAction(), temp.getRemarks(), 
					temp.getAssignedUserId(), temp.getStage(), Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			alertAudit.add(auditRow);
			subs.add(new MstCustAlertDtlDTOSub(temp.getSrNo(), temp.getType(), temp.getAlertId(), temp.getEwiId(), temp.getEwiDesc(), 
					temp.getSeverity(), temp.getSource(), temp.getFrequency(), temp.getCustomerId(), temp.getCustomerName(), temp.getExposure(),
					temp.getCustClassification(), temp.getCustVertical(), temp.getBranchId(), temp.getBranchName(), temp.getMessage(), 
					temp.getAlertDate(), temp.getCloseBy(), temp.getStatus(), temp.getAction(), nextLevel, temp.getPage(), nextUsr, 
					temp.getSignificance(), temp.getRiskMitigation(), temp.getRead()));//consider MdlMpr
		}
		alertAuditRepo.saveAll(MapperUtils.mapToTargetClass(alertAudit, AlertAudit.class));
		return alertRepo.saveAll(MapperUtils.mapToTargetClass(subs, MstCustAlertDtl.class)).size();
	}
	
	@Override
	public void saveAlert(MstCustAlertDtlDTO alert) {
		Optional<String> nextLvl = determineNextLevel(alert.getStage(), alert.getStatus(), alert.getAction());
		String nextLevel = (!nextLvl.isPresent())?alert.getStage():nextLvl.get();
		//if(!nextLvl.isPresent()) throw new RuntimeException("Unable to determine next level");
		Optional<String> nextUser = determineNextUser(alert.getCustomerId(),alert.getAssignedUserId(), alert.getStage(), alert.getStatus(), alert.getAction());
		String nextUsr = (!nextUser.isPresent())?alert.getAssignedUserId():nextUser.get();
		//if(!nextUser.isPresent()) throw new RuntimeException("Unable to determine next user");
		AlertAuditDTO alertAudit = new AlertAuditDTO();
		AuditAttachmentDTO auditAtt = new AuditAttachmentDTO(); 
		MstCustAlertDtlDTOSub sub = new MstCustAlertDtlDTOSub();
		alertAudit = new AlertAuditDTO(alert.getSrNo(), alert.getStatus(), alert.getAction(), alert.getRemarks(), 
				alert.getAssignedUserId(), alert.getStage(), Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		sub = new MstCustAlertDtlDTOSub(alert.getSrNo(), alert.getType(), alert.getAlertId(), alert.getEwiId(), alert.getEwiDesc(), 
				alert.getSeverity(), alert.getSource(), alert.getFrequency(), alert.getCustomerId(), alert.getCustomerName(), alert.getExposure(),
					alert.getCustClassification(), alert.getCustVertical(), alert.getBranchId(), alert.getBranchName(), alert.getMessage(), 
					alert.getAlertDate(), alert.getCloseBy(), alert.getStatus(), alert.getAction(), nextLevel, alert.getPage(), nextUsr, 
					alert.getSignificance(), alert.getRiskMitigation(), alert.getRead());//consider modelMapper
		 
		alertAudit = MapperUtils.mapToTargetClass(alertAuditRepo.save(MapperUtils.mapToTargetClass(alertAudit, AlertAudit.class)), 
				AlertAuditDTO.class);
		
		if(!alert.getFiles()[0].isEmpty()) {
			for(MultipartFile file : alert.getFiles()) {
				try {
					auditAtt = new AuditAttachmentDTO(alertAudit.getAuditId(), file.getBytes(), file.getOriginalFilename(), file.getContentType());
					auditAttachmentRepo.save(MapperUtils.mapToTargetClass(auditAtt, AuditAttachment.class));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		alertRepo.save(MapperUtils.mapToTargetClass(sub, MstCustAlertDtl.class));
	}
	
	private Optional<String> determineNextLevel(String currStage, String status, String action) {
		Optional<String> retVal = Optional.empty();
		CnfgStatusAction temp = statusActionRepo.findByLevelAndStatusAndAction(currStage, status, action);
		if(null == temp) {
			//throw new RuntimeException("Improper Status and Action Specified");
			return retVal;
		}
		int lnow;
		switch(temp.getNext()) {
		case "Next Level":
			lnow = Integer.parseInt(currStage.substring(1));
			retVal = Optional.of("L"+ (++lnow));
			break;
		case "Same Level":
			lnow = Integer.parseInt(currStage.substring(1));
			retVal = Optional.of("L"+ (lnow));
			break;
		default:
			throw new RuntimeException("Stage/Level not handled properly");
		}
		return retVal;
	}
	
	private Optional<String> determineNextUser(String customerId, String currUser, String currStage, String status, String action) {
		Optional<String> retVal = Optional.empty();
		CnfgStatusAction temp = statusActionRepo.findByLevelAndStatusAndAction(currStage, status, action);
		if(null == temp) {
			//throw new RuntimeException("Improper Status and Action Specified");
			return retVal;
		}
		
		switch(temp.getNext()) {
		case "Next Level":
			retVal = getSupervisor(customerId, currUser);
			break;
		case "Same Level":
			retVal = Optional.of(currUser);
			break;
		case "Previous Level":
			retVal = getSubordinate(customerId, currUser);
		default:
			throw new RuntimeException("Stage/Level not handled properly");
		}
		return retVal;
	}
	
	Optional<String> getSupervisor(String customerId, String currUser){
		//Obtain next level/supervisor logic
		return Optional.of("user1");
	}
	Optional<String> getSubordinate(String customerId, String currUser){
		//Obtain next level/subordinate logic
		return Optional.of("user1");
	}
}
