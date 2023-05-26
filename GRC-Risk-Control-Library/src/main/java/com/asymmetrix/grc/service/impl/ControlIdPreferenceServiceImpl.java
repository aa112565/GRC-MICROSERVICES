package com.asymmetrix.grc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.asymmetrix.grc.riskcontrol.dao.ControlIdPreferenceRepository;
import com.asymmetrix.grc.riskcontrol.dto.ControlIdPreferenceDTO;
import com.asymmetrix.grc.riskcontrol.dto.ControlPreferenceDTO;
import com.asymmetrix.grc.riskcontrol.entity.ControlPreference;
import com.asymmetrix.grc.riskcontrol.service.ControlIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;

import com.asymmetrix.grc.riskcontrol.exception.ResourceNotFoundException;


@SuppressWarnings("unused")
@Service
public class ControlIdPreferenceServiceImpl implements ControlIdPreferenceService {

	@Autowired
	private ControlIdPreferenceRepository idPreferenceRepo;	

	@Override
	public List<ControlPreference> getAllControlIdPreferenceByActiveflag() {
		return this.idPreferenceRepo.findAllByActiveflag();
	}

	

	@Override
	public ControlPreference getControlIdPreferenceById(long seriesId) {
		return idPreferenceRepo.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("CONTROL ID Preference not found with  Id----> " + seriesId));
	}	
	

	@Override
	public int findNewIdPreferenceCountByStatusFlag(String preferenceModule) {
		return this.idPreferenceRepo.findNewIdPreferenceCountByStatusFlag(preferenceModule);
	}

	@Override
	public int getControlIdPreferenceCountByActiveflag(String preferenceModule) {
		return this.idPreferenceRepo.getControlIdPreferenceCountByModule(preferenceModule);
	}
	
	
	@Override
	public ControlPreference getControlIdPreferenceByModule(String preferenceModule) {		
		ControlPreference idPreference =  idPreferenceRepo.getControlIdPreferenceByModule(preferenceModule);
		return idPreference;				
	}
	

	@Override
	public ControlIdPreferenceDTO createControlIdPreference(ControlIdPreferenceDTO preferenceDto, String userName) {
		int temCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (temCount > 0) {
			throw new ResourceNotFoundException(" ID Preference found with  Module ----------->"+ preferenceDto.getPreferenceModule().trim() );
			}
		int tempCount = getControlIdPreferenceCountByActiveflag(preferenceDto.getPreferenceModule().trim());
		if(tempCount <= 0) {
			ControlPreferenceDTO atDto = MapperUtils.mapToTargetClass(preferenceDto, ControlPreferenceDTO.class);
			//	apDto.setStatus("Initiated");
				atDto.setDeleteFlag("N");
				atDto.setActiveFlag("Y");
				atDto.setStatus("Y");
				atDto.setCreatedBy(userName);		
				ControlPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atDto, ControlPreference.class));
			return MapperUtils.mapToTargetClass(atFinding, ControlIdPreferenceDTO.class);
		} else {		
			throw new ResourceNotFoundException("ID Preference found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
		//	AMAuditPreferenceDTO idPreferenceDto = MapperUtils.mapToTargetClass(getAuditIdPreferenceByModule(preferenceDto.getPreferenceModule().trim()), AMAuditPreferenceDTO.class);
		//	return idPreferenceDto;
		}
	}

	@Override
	public List<ControlPreference> saveAllControlIdPreference(List<ControlPreference> preferenceList) {
		return this.idPreferenceRepo.saveAll(preferenceList);
	}

	@Override
	public ControlIdPreferenceDTO updateControlIdPreference(ControlIdPreferenceDTO preferenceDto, String userName) {			
		ControlPreference preference = getControlIdPreferenceById(preferenceDto.getSeriesId());
		if (preference.getPreferenceModule().equals(preferenceDto.getPreferenceModule())) {
			ControlIdPreferenceDTO preferenceLog = deleteControlIdPreference(preferenceDto, userName);
			ControlPreferenceDTO atPreferenceDto = MapperUtils.mapToTargetClass(preferenceDto, ControlPreferenceDTO.class);
			atPreferenceDto.setActiveFlag("Y");
			atPreferenceDto.setDeleteFlag("N");
		//	atPreferenceDto.setStatus("Y");
			atPreferenceDto.setCreatedBy(preference.getCreatedBy());
			atPreferenceDto.setModifiedBy(userName);			
			ControlPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atPreferenceDto, ControlPreference.class));		
			return MapperUtils.mapToTargetClass(atFinding, ControlIdPreferenceDTO.class);
			}else 
			{
			throw new ResourceNotFoundException("ID Preference not found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
			}
	}
	
	

	@Override
	public ControlIdPreferenceDTO deleteControlIdPreference(ControlIdPreferenceDTO preferenceDto, String userName) {	
		ControlPreference preference = getControlIdPreferenceById(preferenceDto.getSeriesId());
		preference.setDeleteFlag("D");
		preference.setActiveFlag("N");
		preference.setStatus("N");
		preference.setModifiedBy(userName);
		return MapperUtils.mapToTargetClass(preference, ControlIdPreferenceDTO.class);
	}



	@Override
	public String findNewIdPreference(ControlIdPreferenceDTO preferenceDto) {
		int tempCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (tempCount > 0) {
			return "ID not Available";
		}else {		
		return "ID Available";
		}
	}

}
