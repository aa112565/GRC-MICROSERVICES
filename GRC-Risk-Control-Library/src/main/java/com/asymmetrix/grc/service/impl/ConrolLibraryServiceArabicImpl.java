package com.asymmetrix.grc.service.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.constants.ControlLibraryConstants;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskcontrol.dao.ControlLibraryArabicRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlLibraryLogRepository;
import com.asymmetrix.grc.riskcontrol.dto.ControlIdPreferenceDTO;
import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;

import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryArabic;
import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryLog;
import com.asymmetrix.grc.riskcontrol.entity.ControlPreference;
import com.asymmetrix.grc.riskcontrol.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskcontrol.service.ConrolLibraryServiceArabic;
import com.asymmetrix.grc.riskcontrol.service.ControlIdPreferenceService;

@Service
public class ConrolLibraryServiceArabicImpl implements ConrolLibraryServiceArabic {

	@Autowired
	private ControlLibraryArabicRepository arabicControlLibRepo;

	@Autowired
	private ControlLibraryLogRepository controlLibLogRepo;
	
	@Autowired
	private ControlIdPreferenceService idPreference;
	
	private static final String VERSION_PREFIX = "ERM/";


	@Override
	public List<ControlLibraryArabic> getAllControl() {
		return this.arabicControlLibRepo.findAllControl();
	}

	@Override
	public ControlLibraryArabic getControlById(long controlId) {
		return arabicControlLibRepo.findById(controlId).orElseThrow(
				() -> new ResourceNotFoundException("Control[Arabic] not found with Control Id" + controlId));
	}

	@Override
	public String bulkControlCreation(MultipartFile file) {
		List<Map<String, Object>> controlDetails = ExcelHelper.getDetailsFromExcel(file,
				ControlLibraryConstants.BULK_UPLOAD_EXCEL_SHEET_NAME);
		List<ControlLibraryArabic> controlDetailsList = MapperUtils.mapToTargetClass(controlDetails,
				ControlLibraryArabic.class);

		List<ControlLibraryArabic> savedList = saveAllControl(controlDetailsList);
		return StringUtils.replace(ControlLibraryConstants.BULK_CONTROL_UPLOAD_SUCCESS,
				ControlLibraryConstants.CURLY_BRACKETS_SYMBOL, Integer.toString(savedList.size()));
	}

	public List<ControlLibraryArabic> saveAllControl(List<ControlLibraryArabic> controlLibraryAll) {
		return this.arabicControlLibRepo.saveAll(controlLibraryAll);
	}

	@Override
	public ControlLibraryArabic createControl(ControlLibraryDTO controlLibrary) {
		ControlPreference preference = null;
		@SuppressWarnings("unused")
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		@SuppressWarnings("unused")
		String uniqueId = null, module = "Control Creation"; 		
	
		
		int count = idPreference.getControlIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
		preference = idPreference.getControlIdPreferenceByModule(module);		
		}
		
		if (preference.getPreferenceOganization() != null) {
			uniqueIdPartOne = preference.getPreferenceOganization()+"/";
				if (preference.getPreferenceYear() != null) {
					uniqueIdPartOne = uniqueIdPartOne + preference.getPreferenceYear() + "/";
				}
			} else if (preference.getPreferenceYear() != null) {
				uniqueIdPartOne = preference.getPreferenceYear() + "/";
			}				
		uniqueIdPartTwo = generateNewVersion(preference, newCount);		
		if (uniqueIdPartOne != null) {
			uniqueId = uniqueIdPartOne+uniqueIdPartTwo;
		}else {
			uniqueId = uniqueIdPartTwo;
		}	
	//	controlLibrary.setStatus("Initiated");
		System.out.println("Unique-Id++++++++++++++++++++++++++"+uniqueIdPartTwo);	
		
		ControlLibraryArabic controllib = MapperUtils.mapToTargetClass(controlLibrary, ControlLibraryArabic.class);
		
		controllib.setControlUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			controllib.setPreferenceOganization(preference.getPreferenceOganization());
			}
			if (preference.getPreferenceYear() != null) {
				controllib.setPreferenceYear(preference.getPreferenceYear());
			}			
		controllib.setDeleteFlag("N");		
		controllib.setActiveFlag("Y");
		
		return this.arabicControlLibRepo.save(controllib);
	}

	public ControlLibraryLog updateControlLog(ControlLibraryDTO control) {
		ControlLibraryArabic existingControl = getControlById(control.getControlId());
//		existingControl.setDeleteFlag("D");
		ControlLibraryLog controllib = MapperUtils.mapToTargetClass(existingControl, ControlLibraryLog.class);
		return controlLibLogRepo.save(controllib);
	}

	@Transactional
	@Override
	public ControlLibraryArabic updateControl(ControlLibraryDTO controlLibrary) {
		@SuppressWarnings("unused")
		ControlLibraryLog log = updateControlLog(controlLibrary);
		ControlLibraryArabic controllib = MapperUtils.mapToTargetClass(controlLibrary, ControlLibraryArabic.class);
		controllib.setDeleteFlag("N");		
		controllib.setActiveFlag("Y");
		return arabicControlLibRepo.save(controllib);
	}

	public ControlLibraryArabic updateDelete(ControlLibraryDTO control) {
		// ControlLibraryArabic controllib = MapperUtils.mapToTargetClass(control,
		// ControlLibraryArabic.class);
		ControlLibraryArabic existingControl = getControlById(control.getControlId());
		existingControl.setDeleteFlag("D");
		existingControl.setActiveFlag("N");
		return arabicControlLibRepo.save(existingControl);
	}

	@Override
	public ControlLibraryArabic deleteControl(ControlLibraryDTO controlLibrary) {
		ControlLibraryArabic deleteControl = this.updateDelete(controlLibrary);
		return deleteControl;
	}

	private String generateNewVersion(ControlPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";		
		ControlLibraryArabic controlCreation = arabicControlLibRepo.findFirstByOrderByCreatedDateDescControlIdDesc();
		int numberPartOfLastCreatedID = 0;
		if ( count <= 0 ) {
			if ( controlCreation.getControlUniqueId() != null ) {
			String lastCreatedUniqueID = controlCreation.getControlUniqueId();		
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(lastCreatedUniqueID);			
			while (matcher.find()) {
				numberPartOfLastCreatedID = 0;
				numberPartOfLastCreatedID = Integer.parseInt(matcher.group());
				}			
			// New ID
			int newVersionID = numberPartOfLastCreatedID + 1;			
			return prefix + newVersionID;
				}  else {
				return prefix + 1;
			}
		} else {
			String res = prefix + 1;
			idPref.setStatus("N");
			@SuppressWarnings("unused")
			ControlIdPreferenceDTO preference = idPreference.updateControlIdPreference(MapperUtils.mapToTargetClass(idPref,
					ControlIdPreferenceDTO.class), "Admin");
			return res;
		}
	}
	
}
