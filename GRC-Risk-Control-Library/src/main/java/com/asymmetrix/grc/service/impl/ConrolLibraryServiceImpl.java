package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
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

import com.asymmetrix.grc.riskcontrol.dao.ControlLibraryLogRepository;
import com.asymmetrix.grc.riskcontrol.dao.ControlLibraryRepository;
import com.asymmetrix.grc.riskcontrol.dto.ControlIdPreferenceDTO;
import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;
import com.asymmetrix.grc.riskcontrol.entity.ControlLibrary;
import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryLog;
import com.asymmetrix.grc.riskcontrol.entity.ControlPreference;
import com.asymmetrix.grc.riskcontrol.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskcontrol.service.ConrolLibraryService;
import com.asymmetrix.grc.riskcontrol.service.ControlIdPreferenceService;

@Service
public class ConrolLibraryServiceImpl implements ConrolLibraryService {

	@Autowired
	private ControlLibraryRepository controlLibRepo;

	@Autowired
	private ControlLibraryLogRepository controlLibLogRepo;

	@Autowired
	private ControlIdPreferenceService idPreference;

	private static final String VERSION_PREFIX = "ERM/";

	@Override
	public List<ControlLibrary> getAllControl() {
		return this.controlLibRepo.findAllControl();
	}

	@Override
	public ControlLibrary getControlById(long controlId) {
		return controlLibRepo.findById(controlId)
				.orElseThrow(() -> new ResourceNotFoundException("Control not found with Control Id" + controlId));
	}

	@Override
	public List<ControlLibraryDTO> getActiveControlByList(List<Long> controlIdList) {
		List<ControlLibraryDTO> controlLibraryList = new ArrayList<>();
		for (long contDetalId : controlIdList) {
			int count = controlLibRepo.findByConut(contDetalId);
			if (count > 0) {
				ControlLibraryDTO detailControl = MapperUtils.mapToTargetClass(getControlById(contDetalId),
						ControlLibraryDTO.class);
				controlLibraryList.add(detailControl);
			}
		}
		return controlLibraryList;
	}

	@Transactional
	@Override
	public String bulkControlCreation(MultipartFile file, String uname) {
		List<Map<String, Object>> controlDetails = ExcelHelper.getDetailsFromExcel(file,
				ControlLibraryConstants.BULK_UPLOAD_EXCEL_SHEET_NAME);
		List<ControlLibrary> controlDetailsList = MapperUtils.mapToTargetClass(controlDetails, ControlLibrary.class);
		List<ControlLibrary> controlList = new ArrayList<>();

		for (ControlLibrary tempcontrol : controlDetailsList) {
			tempcontrol.setCreatedBy(uname);
			tempcontrol.setDeleteFlag("N");
			tempcontrol.setActiveFlag("Y");
			ControlLibraryDTO controlLibraryDto = MapperUtils.mapToTargetClass(tempcontrol, ControlLibraryDTO.class);
			ControlLibrary controlLibrary = createControl(controlLibraryDto);
			controlList.add(controlLibrary);
		}
		// List<ControlLibrary> savedList = saveAllControl(controlList);
		// List<ControlLibrary> savedList = saveAllControl(controlDetailsList);
		return StringUtils.replace(ControlLibraryConstants.BULK_CONTROL_UPLOAD_SUCCESS,
				ControlLibraryConstants.CURLY_BRACKETS_SYMBOL, Integer.toString(controlList.size()));
	}

	public List<ControlLibrary> saveAllControl(List<ControlLibrary> controlLibraryAll) {
		return this.controlLibRepo.saveAll(controlLibraryAll);
	}

	@Transactional
	@Override
	public ControlLibrary createControl(ControlLibraryDTO controlLibrary) {
		ControlPreference preference = null;
		@SuppressWarnings("unused")
		String prefOrg = null, prefYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		@SuppressWarnings("unused")
		String uniqueId = null, module = "Control Creation";

		int count = idPreference.getControlIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getControlIdPreferenceByModule(module);
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
		// controlLibrary.setStatus("Initiated");
		// System.out.println("Unique-Id++++++++++++++++++++++++++" + uniqueIdPartTwo);

		ControlLibrary controllib = MapperUtils.mapToTargetClass(controlLibrary, ControlLibrary.class);
		controllib.setControlUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			controllib.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			controllib.setPreferenceYear(preference.getPreferenceYear());
		}
		controllib.setDeleteFlag("N");
		controllib.setActiveFlag("Y");
		return this.controlLibRepo.save(controllib);
	}

	public ControlLibraryLog updateControlLog(long controlId) {
		ControlLibrary existingControl = getControlById(controlId);
		ControlLibraryLog controllib = MapperUtils.mapToTargetClass(existingControl, ControlLibraryLog.class);
		return controlLibLogRepo.save(controllib);
	}

	@Transactional
	@Override
	public ControlLibrary updateControl(ControlLibraryDTO controlLibrary) {
		@SuppressWarnings("unused")
		ControlLibraryLog log = updateControlLog(controlLibrary.getControlId());
		ControlLibrary controllib = MapperUtils.mapToTargetClass(controlLibrary, ControlLibrary.class);
		controllib.setDeleteFlag("N");
		controllib.setActiveFlag("Y");
		return controlLibRepo.save(controllib);
	}

	public ControlLibrary updateDelete(ControlLibraryDTO controlLibrary) {
		@SuppressWarnings("unused")
		ControlLibraryLog log = updateControlLog(controlLibrary.getControlId());
		ControlLibrary existingControl = getControlById(controlLibrary.getControlId());
		existingControl.setDeleteFlag("D");
		existingControl.setActiveFlag("N");
		return controlLibRepo.save(existingControl);
	}

	@Transactional
	@Override
	public ControlLibrary deleteControl(ControlLibraryDTO control) {
		@SuppressWarnings("unused")
		ControlLibraryLog log = updateControlLog(control.getControlId());
		ControlLibrary existingControl = getControlById(control.getControlId());
		existingControl.setDeleteFlag("D");
		existingControl.setActiveFlag("N");
		return controlLibRepo.save(existingControl);
	}

	@Transactional
	@Override
	public String deleteControlList(List<ControlLibraryDTO> controlLibraryList, String username) {
		int count = 0;
		List<ControlLibrary> controlList = null;
							controlList = new ArrayList<>();
		for (ControlLibraryDTO controlDetail : controlLibraryList) {
			count = count + 1;
			@SuppressWarnings("unused")
			ControlLibraryLog log = updateControlLog(controlDetail.getControlId());
			ControlLibrary existingControl = getControlById(controlDetail.getControlId());
			existingControl.setModifiedBy(username);
			existingControl.setDeleteFlag("D");
			existingControl.setActiveFlag("N");
			controlList.add(controlLibRepo.save(existingControl));
		}//controlList.size()
		return StringUtils.replace(ControlLibraryConstants.CONTROL_LIST_DELETE_SUCCESS,
				ControlLibraryConstants.CURLY_BRACKETS_SYMBOL, Integer.toString(count));
	}

	private String generateNewVersion(ControlPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";
		ControlLibrary controlCreation = controlLibRepo.findFirstByOrderByCreatedDateDescControlIdDesc();
		int numberPartOfLastCreatedID = 0;
		if (count <= 0) {
			if (controlCreation.getControlUniqueId() != null) {
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
			} else {
				return prefix + 1;
			}
		} else {
			String res = prefix + 1;
			idPref.setStatus("N");
			@SuppressWarnings("unused")
			ControlIdPreferenceDTO preference = idPreference.updateControlIdPreference(
					MapperUtils.mapToTargetClass(idPref, ControlIdPreferenceDTO.class), "Admin");
			return res;
		}
	}

}
