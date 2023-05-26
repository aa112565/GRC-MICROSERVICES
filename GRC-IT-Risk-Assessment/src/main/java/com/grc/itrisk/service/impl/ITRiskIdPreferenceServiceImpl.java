package com.grc.itrisk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.ITRiskIdPreferenceRepository;
import com.grc.itrisk.dto.ITRiskIdPreferenceDTO;
import com.grc.itrisk.dto.ITRiskPreferenceDTO;
import com.grc.itrisk.entity.ITRiskPreference;
import com.grc.itrisk.exception.ResourceNotFoundException;
import com.grc.itrisk.service.ITRiskIdPreferenceService;


@SuppressWarnings("unused")
@Service
public class ITRiskIdPreferenceServiceImpl implements ITRiskIdPreferenceService {

	@Autowired
	private ITRiskIdPreferenceRepository idPreferenceRepo;	

	@Override
	public List<ITRiskPreference> getAllITRiskIdPreferenceByActiveflag() {
		return this.idPreferenceRepo.findAllByActiveflag();
	}

	

	@Override
	public ITRiskPreference getITRiskIdPreferenceById(long seriesId) {
		return idPreferenceRepo.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("ITRisk ID Preference not found with  Id----> " + seriesId));
	}	
	

	@Override
	public int findNewIdPreferenceCountByStatusFlag(String preferenceModule) {
		return this.idPreferenceRepo.findNewIdPreferenceCountByStatusFlag(preferenceModule);
	}

	@Override
	public int getITRiskIdPreferenceCountByActiveflag(String preferenceModule) {
		return this.idPreferenceRepo.getITRiskIdPreferenceCountByModule(preferenceModule);
	}
	
	
	@Override
	public ITRiskPreference getITRiskIdPreferenceByModule(String preferenceModule) {		
		ITRiskPreference idPreference =  idPreferenceRepo.getITRiskIdPreferenceByModule(preferenceModule);
		return idPreference;				
	}
	

	@Override
	public ITRiskPreference createITRiskIdPreference(ITRiskPreferenceDTO preferenceDto, String userName) {
		int temCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (temCount > 0) {
			throw new ResourceNotFoundException(" ID Preference found with  Module ----------->"+ preferenceDto.getPreferenceModule().trim() );
			}
		
		int tempCount = getITRiskIdPreferenceCountByActiveflag(preferenceDto.getPreferenceModule().trim());
		if(tempCount <= 0) {
			ITRiskIdPreferenceDTO atDto = MapperUtils.mapToTargetClass(preferenceDto, ITRiskIdPreferenceDTO.class);
			//	apDto.setStatus("Initiated");
				atDto.setDeleteFlag("N");
				atDto.setActiveFlag("Y");
				atDto.setStatus("Y");
				atDto.setCreatedBy(userName);		
				ITRiskPreference incidentPref = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atDto, ITRiskPreference.class));
			return incidentPref;
		} else {		
			throw new ResourceNotFoundException("ID Preference found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
		//	AMAuditPreferenceDTO idPreferenceDto = MapperUtils.mapToTargetClass(getAuditIdPreferenceByModule(preferenceDto.getPreferenceModule().trim()), AMAuditPreferenceDTO.class);
		//	return idPreferenceDto;
		}
	}

	@Override
	public List<ITRiskPreference> saveAllITRiskIdPreference(List<ITRiskPreference> preferenceList) {
		return this.idPreferenceRepo.saveAll(preferenceList);
	}

	@Override
	public ITRiskPreference updateITRiskIdPreference(ITRiskPreferenceDTO preferenceDto, String userName) {			
		ITRiskPreference preference = getITRiskIdPreferenceById(preferenceDto.getSeriesId());
		if (preference.getPreferenceModule().equals(preferenceDto.getPreferenceModule())) {
			ITRiskPreference preferenceLog = deleteITRiskIdPreference(preferenceDto, userName);
			ITRiskIdPreferenceDTO atPreferenceDto = MapperUtils.mapToTargetClass(preferenceDto, ITRiskIdPreferenceDTO.class);
			atPreferenceDto.setActiveFlag("Y");
			atPreferenceDto.setDeleteFlag("N");
		//	atPreferenceDto.setStatus("Y");
			atPreferenceDto.setCreatedBy(preference.getCreatedBy());
			atPreferenceDto.setModifiedBy(userName);			
			ITRiskPreference incidentPref = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atPreferenceDto, ITRiskPreference.class));		
			return incidentPref;
			}else 
			{
			throw new ResourceNotFoundException("ID Preference not found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
			}
	}
	
	

	@Override
	public ITRiskPreference deleteITRiskIdPreference(ITRiskPreferenceDTO preferenceDto, String userName) {	
		ITRiskPreference preference = getITRiskIdPreferenceById(preferenceDto.getSeriesId());
		preference.setDeleteFlag("D");
		preference.setActiveFlag("N");
		preference.setStatus("N");
		preference.setModifiedBy(userName);
		ITRiskPreference incidentPref = idPreferenceRepo.save(MapperUtils.mapToTargetClass(preference, ITRiskPreference.class));	
		return incidentPref;
	}



	@Override
	public String findNewIdPreference(ITRiskPreferenceDTO preferenceDto) {
		int tempCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (tempCount > 0) {
			return "ID not Available";
		}else {		
		return "ID Available";
		}
	}

}
