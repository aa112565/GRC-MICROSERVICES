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

import com.asymmetrix.grc.common.constants.RiskConstants;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.risk.dao.RiskLibraryLogRepo;
import com.asymmetrix.grc.risk.dao.RiskLibraryRepository;
import com.asymmetrix.grc.risk.dto.RiskIdPreferenceDTO;
import com.asymmetrix.grc.risk.dto.RiskLibraryDTO;
import com.asymmetrix.grc.risk.dto.RiskLibraryExportDTO;
import com.asymmetrix.grc.risk.dto.RiskRegistWithScoringDTO;
import com.asymmetrix.grc.risk.dto.RiskRegisterActiveRiskListDTO;
import com.asymmetrix.grc.risk.dto.RiskRegisterActiveRiskScoringListDTO;
import com.asymmetrix.grc.risk.dto.RiskRegisterDTO;
import com.asymmetrix.grc.risk.dto.RiskScoringDTO;
import com.asymmetrix.grc.risk.entity.RiskLibrary;
import com.asymmetrix.grc.risk.entity.RiskLibraryLog;
import com.asymmetrix.grc.risk.entity.RiskPreference;
import com.asymmetrix.grc.risk.exception.ResourceNotFoundException;
import com.asymmetrix.grc.risk.service.RiskIdPreferenceService;
import com.asymmetrix.grc.risk.service.RiskLibraryService;

@Service
public class RiskLibraryServiceImpl implements RiskLibraryService {

	@Autowired
	private RiskLibraryRepository riskLibRepo;

	@Autowired
	RiskLibraryLogRepo riskLibLogRepo;

	@Autowired
	private RiskIdPreferenceService idPreference;

	private static final String VERSION_PREFIX = "ERM/";

	@Override
	public List<RiskLibrary> getAllRisk() {
		return this.riskLibRepo.findAllRisk();
	}

	@Override
	public RiskLibrary getRiskById(long riskId) {
		return riskLibRepo.findById(riskId)
				.orElseThrow(() -> new ResourceNotFoundException("Risk not found with  Id----> " + riskId));
	}

	@Transactional
	@Override
	public String bulkRiskCreation(MultipartFile file, String uname) {
		List<Map<String, Object>> RiskDetails = ExcelHelper.getDetailsFromExcel(file,
				RiskConstants.BULK_UPLOAD_EXCEL_SHEET_NAME);

		List<RiskLibrary> riskDetailsList = MapperUtils.mapToTargetClass(RiskDetails, RiskLibrary.class);
		List<RiskLibrary> riskList = new ArrayList<>();

		for (RiskLibrary temprisk : riskDetailsList) {
			temprisk.setCreatedBy(uname);
			temprisk.setDeleteFlag("N");
			temprisk.setActiveFlag("Y");
			RiskLibraryDTO riskLibrarydto = MapperUtils.mapToTargetClass(temprisk, RiskLibraryDTO.class);
			RiskLibrary createrisk = createRisk(riskLibrarydto);
			riskList.add(createrisk);
		}
		// List<RiskLibrary> savedList = saveAll(riskList);
		// List<RiskLibrary> savedList = saveAll(riskDetailsList);
		return StringUtils.replace(RiskConstants.BULK_RISK_UPLOAD_SUCCESS, RiskConstants.CURLY_BRACKETS_SYMBOL,
				Integer.toString(riskList.size()));
	}

	public List<RiskLibrary> saveAll(List<RiskLibrary> riskLibraryList) {
		return this.riskLibRepo.saveAll(riskLibraryList);
	}

	@Transactional
	@Override
	public RiskLibrary createRisk(RiskLibraryDTO riskLibrarydto) {

		RiskPreference preference = null;
		@SuppressWarnings("unused")
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		@SuppressWarnings("unused")
		String uniqueId = null, module = "Risk Creation";

		// RiskLibraryDTO aDto = MapperUtils.mapToTargetClass(cmAuditDto,
		// RiskLibraryDTO.class);
		int count = idPreference.getRiskIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getRiskIdPreferenceByModule(module);
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

		// apDto.setStatus("Initiated");
		// System.out.println("Unique-Id++++++++++++++++++++++++++"+uniqueIdPartTwo);
		RiskLibrary resRisk = MapperUtils.mapToTargetClass(riskLibrarydto, RiskLibrary.class);
		resRisk.setRiskUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			resRisk.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			resRisk.setPreferenceYear(preference.getPreferenceYear());
		}

		// RiskLibrary riskLibrary = MapperUtils.mapToTargetClass(riskLibrarydto,
		// RiskLibrary.class);
		resRisk.setActiveFlag("Y");
		resRisk.setDeleteFlag("N");
		return this.riskLibRepo.save(resRisk);

	}

	public RiskLibraryLog updateRiskLog(long riskId) {

		// RiskLibrary risk = MapperUtils.mapToTargetClass(riskLibrarydto,
		// RiskLibrary.class);
		RiskLibrary existingRisk = getRiskById(riskId);
		// existingRisk.setDeleteFlag("D");
		RiskLibraryLog riskLibrary = MapperUtils.mapToTargetClass(existingRisk, RiskLibraryLog.class);
		return this.riskLibLogRepo.save(riskLibrary);
	}

	@Transactional
	@Override	
	public RiskLibrary updateRisk(RiskLibraryDTO riskLibrarydto) {		
		@SuppressWarnings("unused")
		RiskLibraryLog log = updateRiskLog(riskLibrarydto.getRiskId());
		RiskLibrary risk = MapperUtils.mapToTargetClass(riskLibrarydto, RiskLibrary.class);
		risk.setActiveFlag("Y");
		risk.setDeleteFlag("N");
		return this.riskLibRepo.save(risk);
	}

	// Risk - Soft Delete
//	public RiskLibrary deleteUpdate(RiskLibraryDTO riskLibrarydto) {
	public RiskLibrary deleteUpdate(long riskId) {
		@SuppressWarnings("unused")
		RiskLibraryLog log = updateRiskLog(riskId);
		RiskLibrary existingRisk = getRiskById(riskId);
		existingRisk.setActiveFlag("N");
		existingRisk.setDeleteFlag("D");
		return this.riskLibRepo.save(existingRisk);

	}

	@Transactional
	@Override
	public RiskLibrary deleteRisk(RiskLibraryDTO riskLibrarydto) {
	//	RiskLibrary deleteRisk = this.deleteUpdate(riskLibrarydto.getRiskId());
		// return DeleteRisk;
		@SuppressWarnings("unused")
		RiskLibraryLog log = updateRiskLog(riskLibrarydto.getRiskId());
		RiskLibrary existingRisk = getRiskById(riskLibrarydto.getRiskId());
		existingRisk.setActiveFlag("N");
		existingRisk.setDeleteFlag("D");
		return this.riskLibRepo.save(existingRisk);
	}

	@Transactional
	@Override
	public String deleteRiskList(List<RiskLibraryDTO> riskLibraryList, String userInfo) {
		int count = 0;
		List<RiskLibrary> riskList = null;
						riskList = new ArrayList<>();
		for (RiskLibraryDTO riskDetail : riskLibraryList) {
			count = count + 1;
			@SuppressWarnings("unused")
			RiskLibraryLog log = updateRiskLog(riskDetail.getRiskId());
			RiskLibrary existingRisk = getRiskById(riskDetail.getRiskId());
			existingRisk.setModifiedBy(userInfo);
			existingRisk.setActiveFlag("N");
			existingRisk.setDeleteFlag("D");
			riskList.add(riskLibRepo.save(existingRisk));			
		}
		// return Integer.toString(riskList.size()); riskList.size()
		return StringUtils.replace(RiskConstants.RISK_LIST_DELETE_SUCCESS, RiskConstants.CURLY_BRACKETS_SYMBOL,
				Integer.toString(count));
	}

	@Override
	public List<RiskLibraryDTO> getRiskbyList(List<Long> riskIdList) {
		List<RiskLibraryDTO> riskLibraryList = new ArrayList<>();
		for (Long riskDetalId : riskIdList) {
			int count = riskLibRepo.findByConut(riskDetalId);
			if (count > 0) {
				RiskLibraryDTO detailRisk = MapperUtils.mapToTargetClass(getRiskById(riskDetalId),
						RiskLibraryDTO.class);
				riskLibraryList.add(detailRisk);
			}
		}
		return riskLibraryList;
	}

	@Override
	public List<RiskLibraryExportDTO> getRiskExportList(List<RiskScoringDTO> listRiskScoringDTO) {

		List<RiskLibraryExportDTO> riskLibraryList = new ArrayList<>();
		RiskLibraryExportDTO riskLibExportDTO = new RiskLibraryExportDTO();

		for (RiskScoringDTO scoringData : listRiskScoringDTO) {
			int count = riskLibRepo.findByConut(scoringData.getRiskId());
			if (count > 0) {
				RiskLibrary detailRisk = getRiskById(scoringData.getRiskId());
				RiskLibraryDTO detailRiskDto = MapperUtils.mapToTargetClass(detailRisk, RiskLibraryDTO.class);
				riskLibExportDTO = MapperUtils.mapToTargetClass(detailRiskDto, RiskLibraryExportDTO.class);
				riskLibExportDTO.setInherentImpactRating(scoringData.getInherentImpactRating());
				riskLibExportDTO.setInherentLikelihoodRating(scoringData.getInherentLikelihoodRating());
				riskLibExportDTO.setResidualImpactRating(scoringData.getResidualImpactRating());
				riskLibExportDTO.setResidualLikelihoodRating(scoringData.getResidualLikelihoodRating());
				riskLibraryList.add(riskLibExportDTO);
			}
		}
		return riskLibraryList;
	}

	@Override
	public List<RiskRegisterActiveRiskListDTO> getActiveRiskIdsList(List<RiskRegisterDTO> activeRiskIdsList) {

		List<RiskRegisterActiveRiskListDTO> activeriskIdsList = new ArrayList<>();

		for (RiskRegisterDTO activeIdData : activeRiskIdsList) {
			int count = riskLibRepo.findByConut(activeIdData.getRiskId());
			if (count > 0) {
				RiskLibrary detailRisk = getRiskById(activeIdData.getRiskId());
				RiskRegisterActiveRiskListDTO activeriskDTO = new RiskRegisterActiveRiskListDTO();
				RiskLibraryDTO detailRiskDto = MapperUtils.mapToTargetClass(detailRisk, RiskLibraryDTO.class);
				activeriskDTO = MapperUtils.mapToTargetClass(detailRiskDto, RiskRegisterActiveRiskListDTO.class);
				activeriskDTO.setRiskRegId(activeIdData.getRiskRegId());
				activeriskDTO.setDeptId(activeIdData.getDeptId());
				activeriskDTO.setWsId(activeIdData.getWsId());
				activeriskIdsList.add(activeriskDTO);
			}
		}
		return activeriskIdsList;
	}

	@Override
	public List<RiskRegisterActiveRiskScoringListDTO> getActiveRiskIdsScoringList(
			List<RiskRegistWithScoringDTO> activeRiskIdsList) {

		List<RiskRegisterActiveRiskScoringListDTO> activeriskIdsList = new ArrayList<>();

		for (RiskRegistWithScoringDTO activeIdData : activeRiskIdsList) {
			int count = riskLibRepo.findByConut(activeIdData.getRiskId());
			if (count > 0) {
				RiskLibrary detailRisk = getRiskById(activeIdData.getRiskId());
				RiskRegisterActiveRiskScoringListDTO activeriskDTO = new RiskRegisterActiveRiskScoringListDTO();

				RiskLibraryDTO detailRiskDto = MapperUtils.mapToTargetClass(detailRisk, RiskLibraryDTO.class);
				activeriskDTO = MapperUtils.mapToTargetClass(detailRiskDto, RiskRegisterActiveRiskScoringListDTO.class);

				activeriskDTO.setRiskRegId(activeIdData.getRiskRegId());
				activeriskDTO.setDeptId(activeIdData.getDeptId());
				activeriskDTO.setWsId(activeIdData.getWsId());
				activeriskDTO.setInherentImpactRating(activeIdData.getInherentImpactRating());
				activeriskDTO.setInherentLikelihoodRating(activeIdData.getInherentLikelihoodRating());
				activeriskDTO.setInherentRiskRating(activeIdData.getInherentRiskRating());
				activeriskDTO.setResidualRiskRating(activeIdData.getResidualRiskRating());
				activeriskDTO.setApprovalInitStatus(activeIdData.getApprovalInitStatus());
				activeriskDTO.setOwnerName(activeIdData.getOwnerName());
				activeriskIdsList.add(activeriskDTO);
			}
		}
		return activeriskIdsList;
	}

	private String generateNewVersion(RiskPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";
		RiskLibrary riskCreation = riskLibRepo.findFirstByOrderByCreatedDateDescRiskIdDesc();
		int numberPartOfLastCreatedID = 0;
		if (count <= 0) {
			if (riskCreation.getRiskUniqueId() != null) {
				String lastCreatedUniqueID = riskCreation.getRiskUniqueId();
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
			RiskIdPreferenceDTO preference = idPreference
					.updateRiskIdPreference(MapperUtils.mapToTargetClass(idPref, RiskIdPreferenceDTO.class), "Admin");
			return res;
		}
	}

}
