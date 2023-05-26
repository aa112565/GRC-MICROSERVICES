package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrganizationSubsidiaryDDDTO;
import com.asymmetrix.grc.dto.OrganizationSubsidiaryDTO;
import com.asymmetrix.grc.entity.OrganizationSubsidiary;
import com.asymmetrix.grc.entity.OrganizationSubsidiaryLog;
import com.asymmetrix.grc.repository.OrganizationSubsidiaryLogRepository;
import com.asymmetrix.grc.repository.OrganizationSubsidiaryRepository;
import com.asymmetrix.grc.service.OrganizationSubsidiaryService;


@Service
public class OrganizationnSubsidiaryServiceImpl implements OrganizationSubsidiaryService {

	@Autowired
	private OrganizationSubsidiaryRepository orgSubsRepo;

	@Autowired
	OrganizationSubsidiaryLogRepository orgSubsLogRepo;
	

	@Override
	public List<OrganizationSubsidiary> getAllOrgSubsidiary() {
		List<OrganizationSubsidiary> subsidiaryList = orgSubsRepo.findAllOrgSubsidiary();
		if (subsidiaryList.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_ORG_SUBS_NOT_FOUND);
		    }
		
		return subsidiaryList;
	}
	
	@Override
	public List<OrganizationSubsidiary> getAllOrgSubsidiaryByOrgId(String orgId) {
		List<OrganizationSubsidiary> subsidiaryList = orgSubsRepo.findAllOrgSubsidiaryByOrgId(orgId);
		if (subsidiaryList.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_ORG_SUBS_NOT_FOUND);
		    }
		
		return subsidiaryList;
	}
	
	@Override
	public List<OrganizationSubsidiaryDDDTO> getAllOrgSubsidiaryDDByOrgId(String orgId) {
		List<OrganizationSubsidiaryDDDTO> subsidiaryList = orgSubsRepo.findAllOrgSubsidiaryDDByOrgId(orgId);
		if (subsidiaryList.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_ORG_SUBS_NOT_FOUND);
		    }
		
		return subsidiaryList;
	}

	@Override
	public OrganizationSubsidiary getOrgSubsidiaryById(long orgSubsId) {
		return orgSubsRepo.findById(orgSubsId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Organization-Subsidiary not found with  Id----> " + orgSubsId));
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + orgSubsId));
	}

	
	public List<OrganizationSubsidiary> saveAll(List<OrganizationSubsidiary> orgSubsList) {
		return this.orgSubsRepo.saveAll(orgSubsList);
	}

	@Override
	public OrganizationSubsidiary createOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto) {		
		OrganizationSubsidiary orgSubs = MapperUtils.mapToTargetClass(orgSubsDto, OrganizationSubsidiary.class);
		orgSubs.setActiveFlag("Y");
		orgSubs.setDeleteFlag("N");	
		return this.orgSubsRepo.save(orgSubs);
	
	}
	
	@Override
	public List<OrganizationSubsidiary> createOrgSubsidiaryList(List<OrganizationSubsidiaryDTO> orgSubsList, String uname) {
		List<OrganizationSubsidiary> savedSubsidiaryList = new ArrayList<>();
		for(OrganizationSubsidiaryDTO subsidiaryDto : orgSubsList) {
			OrganizationSubsidiary orgSubs = MapperUtils.mapToTargetClass(subsidiaryDto, OrganizationSubsidiary.class);
			orgSubs.setActiveFlag("Y");
			orgSubs.setDeleteFlag("N");		
			orgSubs.setCreatedBy(uname);
			OrganizationSubsidiary subsidiary = orgSubsRepo.save(orgSubs);
			savedSubsidiaryList.add(subsidiary);
		}
		return savedSubsidiaryList;
	}
	

	public OrganizationSubsidiaryLog updateOrgSubsidiaryLog(long orgSubsId) {			
		OrganizationSubsidiary existingOrgSubs = getOrgSubsidiaryById(orgSubsId);		
		OrganizationSubsidiaryLog orgSubsLog = MapperUtils.mapToTargetClass(existingOrgSubs, OrganizationSubsidiaryLog.class);
		return this.orgSubsLogRepo.save(orgSubsLog);
	}

	
	@Override
	@Transactional
	public OrganizationSubsidiary updateOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto) {		
		@SuppressWarnings("unused")
		OrganizationSubsidiaryLog log = updateOrgSubsidiaryLog(orgSubsDto.getSubsidiaryId());
		OrganizationSubsidiary orgSubs = MapperUtils.mapToTargetClass(orgSubsDto, OrganizationSubsidiary.class);
		orgSubs.setActiveFlag("Y");
		orgSubs.setDeleteFlag("N");
		return this.orgSubsRepo.save(orgSubs);
	}

	

	@Override
	public boolean deleteOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto) {
		OrganizationSubsidiary orgSubs = getOrgSubsidiaryById(orgSubsDto.getSubsidiaryId());
		orgSubs.setActiveFlag("N");
		orgSubs.setDeleteFlag("D");
		orgSubs.setRemarks(orgSubsDto.getRemarks());
	//	return this.orgSubsRepo.save(orgSubs);
		 return (ObjectUtils.isEmpty(orgSubsRepo.save(orgSubs))) ? Boolean.FALSE : Boolean.TRUE;
	}



	@Override
	public boolean activeOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto) {
		OrganizationSubsidiary orgSubs = getOrgSubsidiaryById(orgSubsDto.getSubsidiaryId());
		orgSubs.setActiveFlag("Y");	
		orgSubs.setRemarks(orgSubsDto.getRemarks());
		 return (ObjectUtils.isEmpty(orgSubsRepo.save(orgSubs))) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean inActiveOrgSubsidiary(OrganizationSubsidiaryDTO orgSubsDto) {
		OrganizationSubsidiary orgSubs = getOrgSubsidiaryById(orgSubsDto.getSubsidiaryId());
		orgSubs.setActiveFlag("N");	
		orgSubs.setRemarks(orgSubsDto.getRemarks());
		 return (ObjectUtils.isEmpty(orgSubsRepo.save(orgSubs))) ? Boolean.FALSE : Boolean.TRUE;
	}

	

	

	
}
