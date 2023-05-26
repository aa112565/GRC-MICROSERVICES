package com.grc.threat.risk.service.impl;

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

import com.grc.threat.common.constants.ThreatLibraryConstants;
import com.grc.threat.common.utils.ExcelHelper;
import com.grc.threat.common.utils.MapperUtils;
import com.grc.threat.risk.dao.ThreatLibraryLogRepository;
import com.grc.threat.risk.dao.ThreatLibraryRepository;
import com.grc.threat.risk.dto.ThreatIdPreferenceDTO;
import com.grc.threat.risk.dto.ThreatLibraryDTO;
import com.grc.threat.risk.entity.ThreatLibrary;
import com.grc.threat.risk.entity.ThreatLibraryLog;
import com.grc.threat.risk.entity.ThreatPreference;
import com.grc.threat.risk.exception.ResourceNotFoundException;
import com.grc.threat.risk.service.ThreatIdPreferenceService;
import com.grc.threat.risk.service.ThreatLibraryService;

@Service
public class ThreatLibraryServiceImpl implements ThreatLibraryService {

	@Autowired
	private ThreatLibraryRepository threatLibRepo;

	@Autowired
	private ThreatLibraryLogRepository threatLibLogRepo;

	@Autowired
	private ThreatIdPreferenceService idPreference;

	private static final String VERSION_PREFIX = "ERM/";

	@Override
	public List<ThreatLibrary> getAllThreat() {
		return this.threatLibRepo.findAllThreat();
	}

	@Override
	public ThreatLibrary getThreatById(long threatId) {
		return threatLibRepo.findById(threatId)
				.orElseThrow(() -> new ResourceNotFoundException("Threat not found with Threat Id" + threatId));
	}

	@Override
	public List<ThreatLibraryDTO> getActiveThreatByList(List<Long> threatIdList) {
		List<ThreatLibraryDTO> threatLibraryList = new ArrayList<>();
		for (long contDetalId : threatIdList) {
			int count = threatLibRepo.findByConut(contDetalId);
			if (count > 0) {
				ThreatLibraryDTO detailThreat = MapperUtils.mapToTargetClass(getThreatById(contDetalId),
						ThreatLibraryDTO.class);
				threatLibraryList.add(detailThreat);
			}
		}
		return threatLibraryList;
	}

	@Transactional
	@Override
	public String bulkThreatCreation(MultipartFile file, String uname) {
		List<Map<String, Object>> threatDetails = ExcelHelper.getDetailsFromExcel(file,
				ThreatLibraryConstants.BULK_UPLOAD_EXCEL_SHEET_NAME);
		List<ThreatLibrary> threatDetailsList = MapperUtils.mapToTargetClass(threatDetails, ThreatLibrary.class);
		List<ThreatLibrary> threatList = new ArrayList<>();

		for (ThreatLibrary tempthreat : threatDetailsList) {
			tempthreat.setCreatedBy(uname);
			tempthreat.setDeleteFlag("N");
			tempthreat.setActiveFlag("Y");
			ThreatLibraryDTO threatLibraryDto = MapperUtils.mapToTargetClass(tempthreat, ThreatLibraryDTO.class);
			ThreatLibrary threatLibrary = createThreat(threatLibraryDto);
			threatList.add(threatLibrary);
		}
		// List<ThreatLibrary> savedList = saveAllThreat(threatList);
		// List<ThreatLibrary> savedList = saveAllThreat(threatDetailsList);
		return StringUtils.replace(ThreatLibraryConstants.BULK_CONTROL_UPLOAD_SUCCESS,
				ThreatLibraryConstants.CURLY_BRACKETS_SYMBOL, Integer.toString(threatList.size()));
	}

	public List<ThreatLibrary> saveAllThreat(List<ThreatLibrary> threatLibraryAll) {
		return this.threatLibRepo.saveAll(threatLibraryAll);
	}

	@Transactional
	@Override
	public ThreatLibrary createThreat(ThreatLibraryDTO threatLibrary) {
		ThreatPreference preference = null;
		@SuppressWarnings("unused")
		String prefOrg = null, prefYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		@SuppressWarnings("unused")
		String uniqueId = null, module = "Threat Creation";

		int count = idPreference.getThreatIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getThreatIdPreferenceByModule(module);
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
		// threatLibrary.setStatus("Initiated");
		// System.out.println("Unique-Id++++++++++++++++++++++++++" + uniqueIdPartTwo);

		ThreatLibrary threatlib = MapperUtils.mapToTargetClass(threatLibrary, ThreatLibrary.class);
		threatlib.setThreatUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			threatlib.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			threatlib.setPreferenceYear(preference.getPreferenceYear());
		}
		threatlib.setDeleteFlag("N");
		threatlib.setActiveFlag("Y");
		return this.threatLibRepo.save(threatlib);
	}

	public ThreatLibraryLog updateThreatLog(long threatId) {
		ThreatLibrary existingThreat = getThreatById(threatId);
		ThreatLibraryLog threatlib = MapperUtils.mapToTargetClass(existingThreat, ThreatLibraryLog.class);
		return threatLibLogRepo.save(threatlib);
	}

	@Transactional
	@Override
	public ThreatLibrary updateThreat(ThreatLibraryDTO threatLibrary) {
		@SuppressWarnings("unused")
		ThreatLibraryLog log = updateThreatLog(threatLibrary.getThreatId());
		ThreatLibrary threatlib = MapperUtils.mapToTargetClass(threatLibrary, ThreatLibrary.class);
		threatlib.setDeleteFlag("N");
		threatlib.setActiveFlag("Y");		
		return threatLibRepo.save(threatlib);
	}

	public ThreatLibrary updateDelete(ThreatLibraryDTO threatLibrary) {
		@SuppressWarnings("unused")
		ThreatLibraryLog log = updateThreatLog(threatLibrary.getThreatId());
		ThreatLibrary existingThreat = getThreatById(threatLibrary.getThreatId());
		existingThreat.setDeleteFlag("D");
		existingThreat.setActiveFlag("N");
		return threatLibRepo.save(existingThreat);
	}

	@Transactional
	@Override
	public ThreatLibrary deleteThreat(ThreatLibraryDTO threat) {
		@SuppressWarnings("unused")
		ThreatLibraryLog log = updateThreatLog(threat.getThreatId());
		ThreatLibrary existingThreat = getThreatById(threat.getThreatId());
		existingThreat.setDeleteFlag("D");
		existingThreat.setActiveFlag("N");
		return threatLibRepo.save(existingThreat);
	}

	@Transactional
	@Override
	public String deleteThreatList(List<ThreatLibraryDTO> threatLibraryList, String username) {
		int count = 0;
		List<ThreatLibrary> threatList = null;
							threatList = new ArrayList<>();
		for (ThreatLibraryDTO threatDetail : threatLibraryList) {
			count = count + 1;
			@SuppressWarnings("unused")
			ThreatLibraryLog log = updateThreatLog(threatDetail.getThreatId());
			ThreatLibrary existingThreat = getThreatById(threatDetail.getThreatId());
			existingThreat.setModifiedBy(username);
			existingThreat.setDeleteFlag("D");
			existingThreat.setActiveFlag("N");
			threatList.add(threatLibRepo.save(existingThreat));
		}//threatList.size()
		return StringUtils.replace(ThreatLibraryConstants.CONTROL_LIST_DELETE_SUCCESS,
				ThreatLibraryConstants.CURLY_BRACKETS_SYMBOL, Integer.toString(count));
	}

	private String generateNewVersion(ThreatPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";
		ThreatLibrary threatCreation = threatLibRepo.findFirstByOrderByCreatedDateDescThreatIdDesc();
		int numberPartOfLastCreatedID = 0;
		if (count <= 0) {
			if (threatCreation.getThreatUniqueId() != null) {
				String lastCreatedUniqueID = threatCreation.getThreatUniqueId();
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
			ThreatIdPreferenceDTO preference = idPreference.updateThreatIdPreference(
					MapperUtils.mapToTargetClass(idPref, ThreatIdPreferenceDTO.class), "Admin");
			return res;
		}
	}

}
