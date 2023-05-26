package com.grc.itrisk.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.TemplateMasterLogRepository;
import com.grc.itrisk.dao.TemplateMasterRepository;
import com.grc.itrisk.dto.ITRiskPreferenceDTO;
import com.grc.itrisk.dto.TemplateMasterDTO;
import com.grc.itrisk.entity.ITRiskPreference;
import com.grc.itrisk.entity.TemplateMaster;
import com.grc.itrisk.entity.TemplateMasterLog;
import com.grc.itrisk.service.ITRiskIdPreferenceService;
import com.grc.itrisk.service.TemplateMasterService;


@Service
public class TemplateMasterServiceImpl implements TemplateMasterService {

	@Autowired
	private TemplateMasterRepository templateMasterRepo;
	
	@Autowired
	private TemplateMasterLogRepository templateMasterLogRepo;
	
	@Autowired
	private ITRiskIdPreferenceService idPreference;
	
	private static final String VERSION_PREFIX = "ITRisk/";

	@Override
	public List<TemplateMaster> getAllTemplate() {
		List<TemplateMaster> orgs = templateMasterRepo.findAllTemplate();
		 if (orgs.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }
		
		return orgs;
	}
	
/*	
	@Override
	public List<TemplateMasterDDDTO> getAllTemplateDD() {
		List<TemplateMasterDDDTO> orgs = templateMasterRepo.findAllOrgDD();
		 if (orgs.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.ENTITY_FOLDER_NOT_FOUND);
		    }
		
		return orgs;
	}
*/	
	
/*
	@Override
	public List<TemplateMaster> getAllTemplateByRefId(String refId) {
		List<TemplateMaster> templates = templateMasterRepo.getAllTemplateByRefId(refId);
		 if (templates.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.ENTITY_NOT_FOUND);
		    }
		
		return templates;	
	
	}
*/
	
	@Override
	public TemplateMaster getTemplateById(long templateMasterId) {
		return templateMasterRepo.findById(templateMasterId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Template not found with  Id----> " + templateMasterId));
				.orElseThrow(() -> new ITRiskException(ITRiskErrorConstants.ENTITY_NOT_FOUND + templateMasterId));
	}

	

	public List<TemplateMaster> saveAll(List<TemplateMaster> templateMasterList) {
		return this.templateMasterRepo.saveAll(templateMasterList);
	}

	@SuppressWarnings("unused")
	@Override
	public TemplateMaster createTemplate(TemplateMasterDTO templateMasterDto) {		
		
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		String uniqueId = null, module = "Template";
		ITRiskPreference preference = null;
		
		int count = idPreference.getITRiskIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getITRiskIdPreferenceByModule(module);
		}

		if (preference.getPreferenceOganization() != null) {
			uniqueIdPartOne = preference.getPreferenceOganization() + "/";
			if (preference.getPreferenceYear() != null) {
				uniqueIdPartOne = uniqueIdPartOne + preference.getPreferenceYear() + "/";
			}
		} else if (preference.getPreferenceYear() != null) {
			uniqueIdPartOne = preference.getPreferenceYear() + "/";
		}

		uniqueIdPartTwo = generateNewVersion(preference, newCount);

		if (uniqueIdPartOne != null) {
			uniqueId = uniqueIdPartOne + uniqueIdPartTwo;
		} else {
			uniqueId = uniqueIdPartTwo;
		}
		templateMasterDto.setTemplateUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			templateMasterDto.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			templateMasterDto.setPreferenceYear(preference.getPreferenceYear());
		}	
		
		TemplateMaster templateMaster = MapperUtils.mapToTargetClass(templateMasterDto, TemplateMaster.class);
		templateMaster.setActiveFlag("Y");
		templateMaster.setDeleteFlag("N");	
		return this.templateMasterRepo.save(templateMaster);
	
	}
	

	public TemplateMasterLog updateTemplateLog(long templateMasterId) {			
		TemplateMasterDTO existingTemplate = MapperUtils.mapToTargetClass(getTemplateById(templateMasterId), TemplateMasterDTO.class);		
		TemplateMasterLog templateMasterLog = MapperUtils.mapToTargetClass(existingTemplate, TemplateMasterLog.class);
		return this.templateMasterLogRepo.save(templateMasterLog);
	}

	
	@Override
	@Transactional
	public TemplateMaster updateTemplate(TemplateMasterDTO templateMasterDto) {		
		@SuppressWarnings("unused")
		TemplateMasterLog log = updateTemplateLog(templateMasterDto.getTemplateId());
		TemplateMaster templateMaster = MapperUtils.mapToTargetClass(templateMasterDto, TemplateMaster.class);
		templateMaster.setActiveFlag("Y");
		templateMaster.setDeleteFlag("N");
		return this.templateMasterRepo.save(templateMaster);
	}

	

	@Override
	public boolean deleteTemplate(TemplateMasterDTO templateMasterDto) {
		TemplateMaster existingTemplate = getTemplateById(templateMasterDto.getTemplateId());
		existingTemplate.setActiveFlag("N");
		existingTemplate.setDeleteFlag("D");
		existingTemplate.setRemarks(templateMasterDto.getRemarks());
	//	return this.templateMasterRepo.save(existingTemplate);
		 return (ObjectUtils.isEmpty(templateMasterRepo.save(existingTemplate))) ? Boolean.FALSE : Boolean.TRUE;

	}

	@Override
	public boolean inActiveTemplate(TemplateMasterDTO templateMasterDto) {
		TemplateMaster existingTemplate = getTemplateById(templateMasterDto.getTemplateId());
		existingTemplate.setActiveFlag("N");	
		existingTemplate.setRemarks(templateMasterDto.getRemarks());
		 return (ObjectUtils.isEmpty(templateMasterRepo.save(existingTemplate))) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean activeTemplate(TemplateMasterDTO templateMasterDto) {
		TemplateMaster existingTemplate = getTemplateById(templateMasterDto.getTemplateId());
		existingTemplate.setActiveFlag("Y");	
		existingTemplate.setRemarks(templateMasterDto.getRemarks());
		 return (ObjectUtils.isEmpty(templateMasterRepo.save(existingTemplate))) ? Boolean.FALSE : Boolean.TRUE;
	}

	private String generateNewVersion(ITRiskPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";
		TemplateMaster  templateMaster= templateMasterRepo.findFirstByOrderByCreatedDateDescTemplateIdDesc();
		int numberPartOfLastCreatedID = 0;
		if (count <= 0) {
			if (templateMaster.getTemplateUniqueId() != null) {
				String lastCreatedworkshopID = templateMaster.getTemplateUniqueId();
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(lastCreatedworkshopID);
				while (matcher.find()) {
					numberPartOfLastCreatedID = 0;
					numberPartOfLastCreatedID = Integer.parseInt(matcher.group());
				}
				// New ID
				int newVersionID = numberPartOfLastCreatedID + 1;
				return prefix + newVersionID;
			} else {
				return prefix + 1;
			}
		} else {
			String res = prefix + 1;
			idPref.setStatus("N");
			@SuppressWarnings("unused")
			ITRiskPreference preference = idPreference
					.updateITRiskIdPreference(MapperUtils.mapToTargetClass(idPref, ITRiskPreferenceDTO.class), "Admin");
			return res;
		}
	}
}
