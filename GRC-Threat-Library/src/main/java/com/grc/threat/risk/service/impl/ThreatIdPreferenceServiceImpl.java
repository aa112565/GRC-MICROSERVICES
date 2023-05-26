package com.grc.threat.risk.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.grc.threat.common.utils.MapperUtils;
import com.grc.threat.risk.dao.ThreatIdPreferenceRepository;
import com.grc.threat.risk.dto.ThreatIdPreferenceDTO;
import com.grc.threat.risk.dto.ThreatPreferenceDTO;
import com.grc.threat.risk.entity.ThreatPreference;
import com.grc.threat.risk.exception.ResourceNotFoundException;
import com.grc.threat.risk.service.ThreatIdPreferenceService;


@SuppressWarnings("unused")
@Service
public class ThreatIdPreferenceServiceImpl implements ThreatIdPreferenceService {

	@Autowired
	private ThreatIdPreferenceRepository idPreferenceRepo;	

	@Override
	public List<ThreatPreference> getAllThreatIdPreferenceByActiveflag() {
		return this.idPreferenceRepo.findAllByActiveflag();
	}

	

	@Override
	public ThreatPreference getThreatIdPreferenceById(long seriesId) {
		return idPreferenceRepo.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("THREAT ID Preference not found with  Id----> " + seriesId));
	}	
	

	@Override
	public int findNewIdPreferenceCountByStatusFlag(String preferenceModule) {
		return this.idPreferenceRepo.findNewIdPreferenceCountByStatusFlag(preferenceModule);
	}

	@Override
	public int getThreatIdPreferenceCountByActiveflag(String preferenceModule) {
		return this.idPreferenceRepo.getThreatIdPreferenceCountByModule(preferenceModule);
	}
	
	
	@Override
	public ThreatPreference getThreatIdPreferenceByModule(String preferenceModule) {		
		ThreatPreference idPreference =  idPreferenceRepo.getThreatIdPreferenceByModule(preferenceModule);
		return idPreference;				
	}
	

	@Override
	public ThreatIdPreferenceDTO createThreatIdPreference(ThreatIdPreferenceDTO preferenceDto, String userName) {
		int temCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (temCount > 0) {
			throw new ResourceNotFoundException(" ID Preference found with  Module ----------->"+ preferenceDto.getPreferenceModule().trim() );
			}
		int tempCount = getThreatIdPreferenceCountByActiveflag(preferenceDto.getPreferenceModule().trim());
		if(tempCount <= 0) {
			ThreatPreferenceDTO atDto = MapperUtils.mapToTargetClass(preferenceDto, ThreatPreferenceDTO.class);
			//	apDto.setStatus("Initiated");
				atDto.setDeleteFlag("N");
				atDto.setActiveFlag("Y");
				atDto.setStatus("Y");
				atDto.setCreatedBy(userName);		
				ThreatPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atDto, ThreatPreference.class));
			return MapperUtils.mapToTargetClass(atFinding, ThreatIdPreferenceDTO.class);
		} else {		
			throw new ResourceNotFoundException("ID Preference found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
		//	AMAuditPreferenceDTO idPreferenceDto = MapperUtils.mapToTargetClass(getAuditIdPreferenceByModule(preferenceDto.getPreferenceModule().trim()), AMAuditPreferenceDTO.class);
		//	return idPreferenceDto;
		}
	}

	@Override
	public List<ThreatPreference> saveAllThreatIdPreference(List<ThreatPreference> preferenceList) {
		return this.idPreferenceRepo.saveAll(preferenceList);
	}

	@Override
	public ThreatIdPreferenceDTO updateThreatIdPreference(ThreatIdPreferenceDTO preferenceDto, String userName) {			
		ThreatPreference preference = getThreatIdPreferenceById(preferenceDto.getSeriesId());
		if (preference.getPreferenceModule().equals(preferenceDto.getPreferenceModule())) {
			ThreatIdPreferenceDTO preferenceLog = deleteThreatIdPreference(preferenceDto, userName);
			ThreatPreferenceDTO atPreferenceDto = MapperUtils.mapToTargetClass(preferenceDto, ThreatPreferenceDTO.class);
			atPreferenceDto.setActiveFlag("Y");
			atPreferenceDto.setDeleteFlag("N");
		//	atPreferenceDto.setStatus("Y");
			atPreferenceDto.setCreatedBy(preference.getCreatedBy());
			atPreferenceDto.setModifiedBy(userName);			
			ThreatPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atPreferenceDto, ThreatPreference.class));		
			return MapperUtils.mapToTargetClass(atFinding, ThreatIdPreferenceDTO.class);
			}else 
			{
			throw new ResourceNotFoundException("ID Preference not found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
			}
	}
	
	

	@Override
	public ThreatIdPreferenceDTO deleteThreatIdPreference(ThreatIdPreferenceDTO preferenceDto, String userName) {	
		ThreatPreference preference = getThreatIdPreferenceById(preferenceDto.getSeriesId());
		preference.setDeleteFlag("D");
		preference.setActiveFlag("N");
		preference.setStatus("N");
		preference.setModifiedBy(userName);
		return MapperUtils.mapToTargetClass(preference, ThreatIdPreferenceDTO.class);
	}



	@Override
	public String findNewIdPreference(ThreatIdPreferenceDTO preferenceDto) {
		int tempCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (tempCount > 0) {
			return "ID not Available";
		}else {		
		return "ID Available";
		}
	}

}
