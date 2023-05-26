package com.asymmetrix.grc.service.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.DepartmentDTO;
import com.asymmetrix.grc.dto.EmployeeDTO;
import com.asymmetrix.grc.dto.RiskWorkshopDTO;
import com.asymmetrix.grc.dto.RiskWorkshopParticipantsDTO;
import com.asymmetrix.grc.entity.AttachmentsDTO;
import com.asymmetrix.grc.entity.MOMAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskWorkshop;
import com.asymmetrix.grc.entity.RiskWorkshopAttachments;
import com.asymmetrix.grc.entity.RiskWorkshopAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskWorkshopMOM;
import com.asymmetrix.grc.entity.RiskWorkshopMOMAttachments;
import com.asymmetrix.grc.entity.RiskWorkshopMomDTO;
import com.asymmetrix.grc.repository.RiskWorkshopAttachementRepository;
import com.asymmetrix.grc.repository.RiskWorkshopMOMAttachementRepository;
import com.asymmetrix.grc.repository.RiskWorkshopMomRepository;
import com.asymmetrix.grc.repository.RiskWorkshopParticipantsRepository;
import com.asymmetrix.grc.repository.RiskWorkshopRepository;
import com.asymmetrix.grc.service.ExternalRESTService;
import com.asymmetrix.grc.service.RiskWorkshopService;

@Service
public class RiskWorkshopServiceImpl implements RiskWorkshopService {
	
	private static final String RISK_WORKSHOP_ACTIVE = "Y";
	private static final String WORKSHOP_ID_PREFIX = "WS";
	private static final String RISK_WORKSHOP_STATUS_PENDING = "Pending";
	private static final String RISK_WORKSHOP_STATUS_APPROVED = "Approved";
	
	@Resource
	RiskWorkshopRepository riskWorkshopRepo;
	
	@Resource
	RiskWorkshopMomRepository riskWorkshopMomRepo;
	
	@Resource
	RiskWorkshopParticipantsRepository participantsRepo;
	
	@Resource
	RiskWorkshopAttachementRepository attachmentsRepo;
	
	@Resource
	RiskWorkshopMOMAttachementRepository momAttachmentsRepo;
	
	@Resource ExternalRESTService externalRestService;
	
	public RiskWorkshopDTO createWorkshop(RiskWorkshopDTO riskWorkshopDTO) {		
		riskWorkshopDTO.setWorkshopID(generateWorkshopID());		
	//	riskWorkshopDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		riskWorkshopDTO.setStatus(RISK_WORKSHOP_STATUS_PENDING);
		
	//	String brnName = riskWorkshopDTO.getBranchName();
	//	System.out.println("additonal info--------"+brnName);
		List<RiskWorkshopParticipantsDTO> ptList = new ArrayList<>();
		List<RiskWorkshopParticipantsDTO> pList = riskWorkshopDTO.getParticipantList();		
		for(RiskWorkshopParticipantsDTO participant:pList) {
	//		participant.setBranchName(brnName);
			ptList.add(participant);
		}
		riskWorkshopDTO.setParticipantList(ptList);
		
		RiskWorkshop riskWorkshop = riskWorkshopRepo.save(MapperUtils.mapToTargetClass(riskWorkshopDTO, RiskWorkshop.class));		
		return MapperUtils.mapToTargetClass(riskWorkshop, RiskWorkshopDTO.class);		
	}
	
	public RiskWorkshopDTO updateWorkshop(RiskWorkshopDTO riskWorkshopDTO) {		
		//If already the same workshopid is present, make it inactive		
		riskWorkshopRepo.updateRiskWorkshopToInactive(riskWorkshopDTO.getWorkshopID());
		
		//If already the same workshopid is present in the participants list, make it inactive		
		participantsRepo.updateRiskWorkshopParticipantsToInactive(riskWorkshopDTO.getWorkshopID());
		
		RiskWorkshop riskWorkshop = riskWorkshopRepo.save(MapperUtils.mapToTargetClass(riskWorkshopDTO, RiskWorkshop.class));
		return MapperUtils.mapToTargetClass(riskWorkshop, RiskWorkshopDTO.class);
	}
	
	public RiskWorkshopDTO getWorkshop(String workshopID) {	
		RiskWorkshopDTO riskWorkshop = MapperUtils.mapToTargetClass(riskWorkshopRepo.findByWorkshopIDAndActive(workshopID, RISK_WORKSHOP_ACTIVE), RiskWorkshopDTO.class);
		//Filter only the active participants
		List<RiskWorkshopParticipantsDTO> filteredParticipantList = riskWorkshop.getParticipantList().stream()
				.filter(a -> a.getActive().equals(RISK_WORKSHOP_ACTIVE)).collect(Collectors.toList());
		riskWorkshop.setParticipantList(filteredParticipantList);
		return riskWorkshop;
	}
	
	public List<RiskWorkshopDTO> getAllWorshopList(){
	//	List<RiskWorkshopDTO> workshopList =  MapperUtils.mapToTargetClass(riskWorkshopRepo.findByActiveOrderByCreatedDateDesc(RISK_WORKSHOP_ACTIVE), RiskWorkshopDTO.class);		
		List<RiskWorkshopDTO> workshopList =  MapperUtils.mapToTargetClass(riskWorkshopRepo.findActiveByBranchName(RISK_WORKSHOP_ACTIVE), RiskWorkshopDTO.class);
		// Filter only the active participants of the workshop  
		for (RiskWorkshopDTO riskWorkshop : workshopList) {
			List<RiskWorkshopParticipantsDTO> filteredParticipantList = riskWorkshop.getParticipantList().stream()
					.filter(a -> a.getActive().equals(RISK_WORKSHOP_ACTIVE)).collect(Collectors.toList());
			riskWorkshop.setParticipantList(filteredParticipantList);
		}		
		return workshopList;
	}
	
	public Integer deleteWorkshop(String workshopID) {
		//Delete the participants (i.e) make them inactive
		participantsRepo.updateRiskWorkshopParticipantsToInactive(workshopID);
		return riskWorkshopRepo.updateRiskWorkshopToInactive(workshopID);
	}
	
	public boolean createWorkshopAttachment(AttachmentsDTO attachmentsDTO) {
		boolean status = false;		
		List<RiskWorkshopAttachments> workshopAttachments = new ArrayList<RiskWorkshopAttachments>();
		try {
			for (MultipartFile attachment : attachmentsDTO.getFiles()) {
				workshopAttachments.add(new RiskWorkshopAttachments(attachmentsDTO.getWorkshopID(),
						attachment.getBytes(), attachment.getOriginalFilename(),
						attachment.getContentType()));
			}
			attachmentsRepo.saveAll(workshopAttachments);  
			status = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}
	
	public List<RiskWorkshopAttachmentsDTO> getAttachmentsOfWorkshop(String workshopID) {
		return MapperUtils.mapToTargetClass(attachmentsRepo.findByWorkshopIDAndActive(workshopID, RISK_WORKSHOP_ACTIVE), RiskWorkshopAttachmentsDTO.class);
	}
	
	public Integer deleteWorkshopAttachment(Long attachmentID) {		
		return attachmentsRepo.updateWorkshopAttachmentToInactive(attachmentID);
	}	
	
	public RiskWorkshopAttachmentsDTO downloadFile(Long attachmentID, String fileName) {
		RiskWorkshopAttachments attachment = attachmentsRepo.findByAttachmentIDAndFileNameAndActive(attachmentID, fileName, RISK_WORKSHOP_ACTIVE);
		GRCUtils.isValid(attachment, "No Attachment found !");
		return MapperUtils.mapToTargetClass(attachment, RiskWorkshopAttachmentsDTO.class);
	}
	
	private String generateWorkshopID() {
		RiskWorkshop riskWorkshop = riskWorkshopRepo.findFirstByOrderByCreatedDateDescIdDesc();
		if(riskWorkshop != null) {
			String lastCreatedworkshopID = riskWorkshop.getWorkshopID();
		//	Pattern pattern = Pattern.compile("[a-z]+|\\d+");

			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(lastCreatedworkshopID);
			int numberPartOfLastCreatedID = 0;
			while (matcher.find()) {
				numberPartOfLastCreatedID = Integer.parseInt(matcher.group());			
			}
			//New ID
			int newID = numberPartOfLastCreatedID + 1;		
			return WORKSHOP_ID_PREFIX+newID;
		} else {
			return WORKSHOP_ID_PREFIX + 1;
		}
	}
	
	public RiskWorkshopMomDTO createWorskhopMOM(RiskWorkshopMomDTO riskWorkshopMomDTO) {
		
		//If already the same workshopid is present, make it inactive		
		riskWorkshopMomRepo.updateRiskWorkshopMomToInactive(riskWorkshopMomDTO.getWorkshopID());
		
		//Once the mom is given, the workshop status should be updated to Approved.	
		riskWorkshopRepo.updateRiskWorkshopStatus(riskWorkshopMomDTO.getWorkshopID(), RISK_WORKSHOP_STATUS_APPROVED);
		
		RiskWorkshopMOM riskWorkshopMom = riskWorkshopMomRepo.save(MapperUtils.mapToTargetClass(riskWorkshopMomDTO, RiskWorkshopMOM.class));
		return MapperUtils.mapToTargetClass(riskWorkshopMom, RiskWorkshopMomDTO.class);
		
	}
	
	public RiskWorkshopMomDTO getWorskhopMOM(String workshopID) {
		return MapperUtils.mapToTargetClass(riskWorkshopMomRepo.findByWorkshopIDAndActive(workshopID, RISK_WORKSHOP_ACTIVE), RiskWorkshopMomDTO.class);
	}
	
	public List<RiskWorkshopParticipantsDTO> getWorkshopAndParticipants(String departmentID) {
		return MapperUtils.mapToTargetClass(participantsRepo.findByDepartmentID(departmentID), RiskWorkshopParticipantsDTO.class);
	}
	
	public boolean createWorkshopMomAttachments(MOMAttachmentsDTO momAttachmentsDTO) {
		boolean status = false;		
		List<RiskWorkshopMOMAttachments> workshopMomAttachments = new ArrayList<RiskWorkshopMOMAttachments>();
		try {
			for (MultipartFile attachment : momAttachmentsDTO.getFiles()) {
				workshopMomAttachments.add(new RiskWorkshopMOMAttachments(momAttachmentsDTO.getMomID(), momAttachmentsDTO.getWorkshopID(),
						attachment.getBytes(), attachment.getOriginalFilename(),
						attachment.getContentType()));
			}
			momAttachmentsRepo.saveAll(workshopMomAttachments);  
			status = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}
	
	public List<DepartmentDTO> getAllDepartments() {
		return MapperUtils.mapToTargetClass(externalRestService.getAllDepartmentsFromUserMgmt(), DepartmentDTO.class);
	}
	
	public List<EmployeeDTO> getAllEmployees() {
		return MapperUtils.mapToTargetClass(externalRestService.getAllEmployeesFromUserMgmt(), EmployeeDTO.class);
	}



}
