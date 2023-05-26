package com.asymmetrix.grc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.riskkri.dao.KriIdPreferenceRepository;
import com.asymmetrix.grc.riskkri.dto.KriIdPreferenceDTO;
import com.asymmetrix.grc.riskkri.dto.KriPreferenceDTO;
import com.asymmetrix.grc.riskkri.entity.KriPreference;
import com.asymmetrix.grc.riskkri.service.KriIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;

import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;


@SuppressWarnings("unused")
@Service
public class KriIdPreferenceServiceImpl implements KriIdPreferenceService {

	@Autowired
	private KriIdPreferenceRepository idPreferenceRepo;	

	@Override
	public List<KriPreference> getAllKriIdPreferenceByActiveflag() {
		return this.idPreferenceRepo.findAllByActiveflag();
	}


	@Override
	public KriPreference getKriIdPreferenceById(long seriesId) {
		return idPreferenceRepo.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("KRI ID Preference not found with  Id----> " + seriesId));
	}	
	

	@Override
	public int findNewIdPreferenceCountByStatusFlag(String preferenceModule) {
		return this.idPreferenceRepo.findNewIdPreferenceCountByStatusFlag(preferenceModule);
	}

	@Override
	public int getKriIdPreferenceCountByActiveflag(String preferenceModule) {
		return this.idPreferenceRepo.getKriIdPreferenceCountByModule(preferenceModule);
	}
	
	
	@Override
	public KriPreference getKriIdPreferenceByModule(String preferenceModule) {		
		KriPreference idPreference =  idPreferenceRepo.getKriIdPreferenceByModule(preferenceModule);
		return idPreference;				
	}
	

	@Override
	public KriIdPreferenceDTO createKriIdPreference(KriIdPreferenceDTO preferenceDto, String userName) {
		int temCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (temCount > 0) {
			throw new ResourceNotFoundException(" ID Preference found with  Module ----------->"+ preferenceDto.getPreferenceModule().trim() );
			}
		
		int tempCount = getKriIdPreferenceCountByActiveflag(preferenceDto.getPreferenceModule().trim());
		if(tempCount <= 0) {
			KriPreferenceDTO atDto = MapperUtils.mapToTargetClass(preferenceDto, KriPreferenceDTO.class);
			//	apDto.setStatus("Initiated");
				atDto.setDeleteFlag("N");
				atDto.setActiveFlag("Y");
				atDto.setStatus("Y");
				atDto.setCreatedBy(userName);		
				KriPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atDto, KriPreference.class));
			return MapperUtils.mapToTargetClass(atFinding, KriIdPreferenceDTO.class);
		} else {		
			throw new ResourceNotFoundException("ID Preference found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
		//	AMAuditPreferenceDTO idPreferenceDto = MapperUtils.mapToTargetClass(getAuditIdPreferenceByModule(preferenceDto.getPreferenceModule().trim()), AMAuditPreferenceDTO.class);
		//	return idPreferenceDto;
		}
	}

	@Override
	public List<KriPreference> saveAllKriIdPreference(List<KriPreference> preferenceList) {
		return this.idPreferenceRepo.saveAll(preferenceList);
	}

	@Override
	public KriIdPreferenceDTO updateKriIdPreference(KriIdPreferenceDTO preferenceDto, String userName) {			
		KriPreference preference = getKriIdPreferenceById(preferenceDto.getSeriesId());
		if (preference.getPreferenceModule().equals(preferenceDto.getPreferenceModule())) {
			KriIdPreferenceDTO preferenceLog = deleteKriIdPreference(preferenceDto, userName);
			KriPreferenceDTO atPreferenceDto = MapperUtils.mapToTargetClass(preferenceDto, KriPreferenceDTO.class);
			atPreferenceDto.setActiveFlag("Y");
			atPreferenceDto.setDeleteFlag("N");
		//	atPreferenceDto.setStatus("Y");
			atPreferenceDto.setCreatedBy(preference.getCreatedBy());
			atPreferenceDto.setModifiedBy(userName);			
			KriPreference atFinding = idPreferenceRepo.save(MapperUtils.mapToTargetClass(atPreferenceDto, KriPreference.class));		
			return MapperUtils.mapToTargetClass(atFinding, KriIdPreferenceDTO.class);
			}else 
			{
			throw new ResourceNotFoundException("ID Preference not found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
			}
	}
	
	

	@Override
	public KriIdPreferenceDTO deleteKriIdPreference(KriIdPreferenceDTO preferenceDto, String userName) {	
		KriPreference preference = getKriIdPreferenceById(preferenceDto.getSeriesId());
		preference.setDeleteFlag("D");
		preference.setActiveFlag("N");
		preference.setStatus("N");
		preference.setModifiedBy(userName);
		return MapperUtils.mapToTargetClass(preference, KriIdPreferenceDTO.class);
	}


	@Override
	public String findNewIdPreference(KriIdPreferenceDTO preferenceDto) {
		int tempCount =  this.idPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (tempCount > 0) {
			return "ID not Available";
		}else {		
		return "ID Available";
		}
	}

}
