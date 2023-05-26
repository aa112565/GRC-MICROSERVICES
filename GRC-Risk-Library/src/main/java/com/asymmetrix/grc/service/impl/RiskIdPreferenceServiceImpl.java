package com.asymmetrix.grc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.risk.dao.RiskIdPreferenceRepository;
import com.asymmetrix.grc.risk.dto.RiskIdPreferenceDTO;
import com.asymmetrix.grc.risk.dto.RiskPreferenceDTO;
import com.asymmetrix.grc.risk.entity.RiskPreference;
import com.asymmetrix.grc.risk.service.RiskIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;

import com.asymmetrix.grc.common.exception.ResourceNotFoundException;


@SuppressWarnings("unused")
@Service
public class RiskIdPreferenceServiceImpl implements RiskIdPreferenceService {

	@Autowired
	private RiskIdPreferenceRepository idPreferenceRepo;	

	@Override
	public List<RiskPreference> getAllRiskIdPreferenceByActiveflag() {
		return this.idPreferenceRepo.findAllByActiveflag();
	}

	

	@Override
	public RiskPreference getRiskIdPreferenceById(long seriesId) {
		return idPreferenceRepo.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("RISK ID Preference not found with  Id----> " + seriesId));
	}	
	

	@Override
	public int findNewIdPreferenceCountByStatusFlag(String preferenceModule) {
		return this.idPreferenceRepo.findNewIdPreferenceCountByStatusFlag(preferenceModule);
	}
	
	@Override
	public String findNewIdPreference(RiskIdPreferenceDTO preferenceDto) {
		int tempCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (tempCount > 0) {
			return "ID not Available";
		}else {		
		return "ID Available";
		}
	}

	@Override
	public int getRiskIdPreferenceCountByActiveflag(String preferenceModule) {
		return this.idPreferenceRepo.getRiskIdPreferenceCountByModule(preferenceModule);
	}
	
	
	@Override
	public RiskPreference getRiskIdPreferenceByModule(String preferenceModule) {		
		RiskPreference idPreference =  idPreferenceRepo.getRiskIdPreferenceByModule(preferenceModule);
		return idPreference;				
	}
	

	@Override
	public RiskIdPreferenceDTO createRiskIdPreference(RiskIdPreferenceDTO preferenceDto, String userName) {
		int temCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (temCount > 0) {
			throw new ResourceNotFoundException(" ID Preference found with  Module ----------->"+ preferenceDto.getPreferenceModule().trim() );
		}		
		int tempCount = getRiskIdPreferenceCountByActiveflag(preferenceDto.getPreferenceModule().trim());
		if(tempCount <= 0 ) {
			RiskPreferenceDTO atDto = MapperUtils.mapToTargetClass(preferenceDto, RiskPreferenceDTO.class);
			//	apDto.setStatus("Initiated");
				atDto.setDeleteFlag("N");
				atDto.setActiveFlag("Y");
				atDto.setStatus("Y");
				atDto.setCreatedBy(userName);		
				RiskPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atDto, RiskPreference.class));
			return MapperUtils.mapToTargetClass(atFinding, RiskIdPreferenceDTO.class);
		} else {		
			throw new ResourceNotFoundException("ID Preference found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
		//	AMAuditPreferenceDTO idPreferenceDto = MapperUtils.mapToTargetClass(getAuditIdPreferenceByModule(preferenceDto.getPreferenceModule().trim()), AMAuditPreferenceDTO.class);
		//	return idPreferenceDto;
		}
	}

	@Override
	public List<RiskPreference> saveAllRiskIdPreference(List<RiskPreference> preferenceList) {
		return this.idPreferenceRepo.saveAll(preferenceList);
	}

	@Override
	public RiskIdPreferenceDTO updateRiskIdPreference(RiskIdPreferenceDTO preferenceDto, String userName) {			
		RiskPreference preference = getRiskIdPreferenceById(preferenceDto.getSeriesId());
		if (preference.getPreferenceModule().equals(preferenceDto.getPreferenceModule())) {
			RiskIdPreferenceDTO preferenceLog = deleteRiskIdPreference(preferenceDto, userName);
			RiskPreferenceDTO atPreferenceDto = MapperUtils.mapToTargetClass(preferenceDto, RiskPreferenceDTO.class);
			atPreferenceDto.setActiveFlag("Y");
			atPreferenceDto.setDeleteFlag("N");
		//	atPreferenceDto.setStatus("Y");
			atPreferenceDto.setCreatedBy(preference.getCreatedBy());
			atPreferenceDto.setModifiedBy(userName);			
			RiskPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atPreferenceDto, RiskPreference.class));		
			return MapperUtils.mapToTargetClass(atFinding, RiskIdPreferenceDTO.class);
			}else 
			{
			throw new ResourceNotFoundException("ID Preference not found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
			}
	}
	
	

	@Override
	public RiskIdPreferenceDTO deleteRiskIdPreference(RiskIdPreferenceDTO preferenceDto, String userName) {	
		RiskPreference preference = getRiskIdPreferenceById(preferenceDto.getSeriesId());
		preference.setDeleteFlag("D");
		preference.setActiveFlag("N");
		preference.setStatus("N");
		preference.setModifiedBy(userName);
		return MapperUtils.mapToTargetClass(preference, RiskIdPreferenceDTO.class);
	}

}
