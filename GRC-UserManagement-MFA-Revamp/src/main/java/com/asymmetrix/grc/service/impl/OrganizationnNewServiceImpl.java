package com.asymmetrix.grc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrganizationMasterDDDTO;
import com.asymmetrix.grc.dto.OrganizationMasterDTO;
import com.asymmetrix.grc.entity.OrganizationMaster;
import com.asymmetrix.grc.entity.OrganizationMasterLog;
import com.asymmetrix.grc.repository.OrganizationMasterLogRepository;
import com.asymmetrix.grc.repository.OrganizationMasterRepository;
import com.asymmetrix.grc.service.OrganizationNewService;


@Service
public class OrganizationnNewServiceImpl implements OrganizationNewService {

	@Autowired
	private OrganizationMasterRepository orgMasterRepo;

	@Autowired
	OrganizationMasterLogRepository orgMasterLogRepo;
	

	@Override
	public List<OrganizationMaster> getAllOrganization() {
		List<OrganizationMaster> orgs = orgMasterRepo.findAllOrg();
		 if (orgs.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_ORG_NOT_FOUND);
		    }
		
		return orgs;
	}
	
	@Override
	public List<OrganizationMasterDDDTO> getAllOrganizationDD() {
		List<OrganizationMasterDDDTO> orgs = orgMasterRepo.findAllOrgDD();
		 if (orgs.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_ORG_NOT_FOUND);
		    }
		
		return orgs;
	}
	


	@Override
	public OrganizationMaster getOrganizationById(long orgMasterId) {
		return orgMasterRepo.findById(orgMasterId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Organization not found with  Id----> " + orgMasterId));
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + orgMasterId));
	}

	

	public List<OrganizationMaster> saveAll(List<OrganizationMaster> orgMasterList) {
		return this.orgMasterRepo.saveAll(orgMasterList);
	}

	@Override
	public OrganizationMaster createOrganization(OrganizationMasterDTO orgMasterDto) {		
		OrganizationMaster orgMaster = MapperUtils.mapToTargetClass(orgMasterDto, OrganizationMaster.class);
		orgMaster.setActiveFlag("Y");
		orgMaster.setDeleteFlag("N");	
		return this.orgMasterRepo.save(orgMaster);
	
	}
	

	public OrganizationMasterLog updateOrganizationLog(long orgMasterId) {	
		
		OrganizationMaster existingOrg = getOrganizationById(orgMasterId);		
		OrganizationMasterLog orgMasterLog = MapperUtils.mapToTargetClass(existingOrg, OrganizationMasterLog.class);
		return this.orgMasterLogRepo.save(orgMasterLog);
	}

	
	@Override
	@Transactional
	public OrganizationMaster updateOrganization(OrganizationMasterDTO orgMasterDto) {		
		@SuppressWarnings("unused")
		OrganizationMasterLog log = updateOrganizationLog(orgMasterDto.getOrganizationId());
		OrganizationMaster orgMaster = MapperUtils.mapToTargetClass(orgMasterDto, OrganizationMaster.class);
		orgMaster.setActiveFlag("Y");
		orgMaster.setDeleteFlag("N");
		return this.orgMasterRepo.save(orgMaster);
	}

	

	@Override
	public boolean deleteOrganization(OrganizationMasterDTO orgMasterDto) {
		OrganizationMaster existingOrg = getOrganizationById(orgMasterDto.getOrganizationId());
		existingOrg.setActiveFlag("N");
		existingOrg.setDeleteFlag("D");
		existingOrg.setRemarks(orgMasterDto.getRemarks());
	//	return this.orgMasterRepo.save(existingOrg);
		 return (ObjectUtils.isEmpty(orgMasterRepo.save(existingOrg))) ? Boolean.FALSE : Boolean.TRUE;

	}

	@Override
	public boolean inActiveOrganization(OrganizationMasterDTO orgMasterDto) {
		OrganizationMaster existingOrg = getOrganizationById(orgMasterDto.getOrganizationId());
		existingOrg.setActiveFlag("N");	
		existingOrg.setRemarks(orgMasterDto.getRemarks());
		 return (ObjectUtils.isEmpty(orgMasterRepo.save(existingOrg))) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean activeOrganization(OrganizationMasterDTO orgMasterDto) {
		OrganizationMaster existingOrg = getOrganizationById(orgMasterDto.getOrganizationId());
		existingOrg.setActiveFlag("Y");	
		existingOrg.setRemarks(orgMasterDto.getRemarks());
		 return (ObjectUtils.isEmpty(orgMasterRepo.save(existingOrg))) ? Boolean.FALSE : Boolean.TRUE;
	}

	
}
