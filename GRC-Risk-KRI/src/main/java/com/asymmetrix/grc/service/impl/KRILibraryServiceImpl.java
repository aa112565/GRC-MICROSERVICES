package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.asymmetrix.grc.common.constants.KRIConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;

import com.asymmetrix.grc.riskkri.dao.RiskKriLogRepository;
import com.asymmetrix.grc.riskkri.dao.RiskKriRepository;
import com.asymmetrix.grc.riskkri.dto.KRIWithBusinessLineDTO;
import com.asymmetrix.grc.riskkri.dto.KriIdPreferenceDTO;
import com.asymmetrix.grc.riskkri.dto.RiskKriDTO;
import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;
import com.asymmetrix.grc.riskkri.entity.KriPreference;
import com.asymmetrix.grc.riskkri.entity.RiskKri;
import com.asymmetrix.grc.riskkri.entity.RiskKriLog;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KRILibraryService;
import com.asymmetrix.grc.riskkri.service.KriIdPreferenceService;

@Service
public class KRILibraryServiceImpl implements KRILibraryService {

	@Autowired
	private RiskKriRepository riskKriRepo;

	@Autowired
	private RiskKriLogRepository riskKriLogRepo;

	@Autowired
	private KriMapBusinessLineServiceImpl mapService;

	@Autowired
	private KriIdPreferenceService idPreference;

	private static final String VERSION_PREFIX = "ERM/";

	@Override
	public List<RiskKri> getAllKri() {
		return this.riskKriRepo.findAllKri();
	}

	@Override
	public RiskKri getKriById(long kriId) {
		return riskKriRepo.findById(kriId)
				.orElseThrow(() -> new ResourceNotFoundException("KRI not found with  Id----> " + kriId));
	}

	@Override
	public List<RiskKriDTO> getKriByList(List<Long> kriIdList) {
		List<RiskKriDTO> riskKriList = new ArrayList<>();
		for (long mapId : kriIdList) {
			RiskKriDTO detailKri = MapperUtils.mapToTargetClass(getKriById(mapId), RiskKriDTO.class);
			riskKriList.add(detailKri);
		}
		return riskKriList;
	}

	@Override
	public List<KRIWithBusinessLineDTO> getAllKriwithBusinessline() {
		// System.out.println("+++++++++++++++++++++++++getAllKriwithBusinessline=============");
		List<KRIWithBusinessLineDTO> kribusinesslinelist = new ArrayList<>();
		List<RiskKri> krilist = getAllKri();
		for (RiskKri kriinfo : krilist) {
			KRIWithBusinessLineDTO kribusinessline = MapperUtils.mapToTargetClass(kriinfo,
					KRIWithBusinessLineDTO.class);
			long mapcount = mapService.getKriMapBusinessLineCount(String.valueOf((kribusinessline.getKriId())));
			if (mapcount > 0) {
				// System.out.println("+++++++++++++++++++++++++KriId()============="+kribusinessline.getKriId());
				// System.out.println("+++++++++++++++++++++++++mapcount============="+mapcount);
				KriMapBusinessLine krimap = mapService.getKriMapByKriId(String.valueOf((kribusinessline.getKriId())));
				kribusinessline.setBuninessLineOne(krimap.getBuninessLineOne());
				kribusinessline.setBuninessLineTwo(krimap.getBuninessLineTwo());
			}
			kribusinesslinelist.add(kribusinessline);
		}
		return kribusinesslinelist;
	}

	@Transactional
	@Override
	public RiskKri createKri(RiskKriDTO kriDTO) {
		KriPreference preference = null;
		@SuppressWarnings("unused")
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		@SuppressWarnings("unused")
		String uniqueId = null, module = "KRI";

		int count = idPreference.getKriIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getKriIdPreferenceByModule(module);
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
		System.out.println("Unique-Id++++++++++++++++++++++++++" + uniqueIdPartTwo);

		RiskKri kri = MapperUtils.mapToTargetClass(kriDTO, RiskKri.class);
		kri.setKriUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			kri.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			kri.setPreferenceYear(preference.getPreferenceYear());
		}
		kri.setActiveFlag("Y");
		kri.setDeleteFlag("N");
		return this.riskKriRepo.save(kri);
	}

	@Override
	public List<RiskKri> saveAllKri(List<RiskKri> riskKriAll) {
		return this.riskKriRepo.saveAll(riskKriAll);
	}

	public RiskKriLog updateKriLog(long kriId) {
		RiskKri existingKri = getKriById(kriId);
		RiskKriLog kri = MapperUtils.mapToTargetClass(existingKri, RiskKriLog.class);
		// kri.setDeleteFlag("D");
		//kri.setActiveFlag("N");
		return this.riskKriLogRepo.save(kri);
	}

	@Transactional
	@Override
	public RiskKri updateKri(RiskKriDTO kriDTO) {
		@SuppressWarnings("unused")
		RiskKriLog krilog = updateKriLog(kriDTO.getKriId());
		RiskKri kri = MapperUtils.mapToTargetClass(kriDTO, RiskKri.class);
		kri.setActiveFlag("Y");
		kri.setDeleteFlag("N");
		// RiskKri existingKri = getKriById(kri.getKriId());
		return this.riskKriRepo.save(kri);
	}

	// Risk-Kri - Soft Delete
	public RiskKri deleteUpdate(RiskKri kri) {
		@SuppressWarnings("unused")
		RiskKriLog krilog = updateKriLog(kri.getKriId());
		RiskKri existingKri = getKriById(kri.getKriId());
		existingKri.setDeleteFlag("D");
		existingKri.setActiveFlag("N");
		existingKri.setRemarks(kri.getRemarks());
		existingKri.setSupportDoc(kri.getSupportDoc());
		return this.riskKriRepo.save(existingKri);
	}

	@Transactional
	@Override
	public RiskKri deleteKri(RiskKriDTO kriDTO) {
		// RiskKri kri = MapperUtils.mapToTargetClass(kriDTO, RiskKri.class);
		// RiskKri DeleteRisk = this.deleteUpdate(kri);
		@SuppressWarnings("unused")
		RiskKriLog krilog = updateKriLog(kriDTO.getKriId());
		RiskKri existingKri = getKriById(kriDTO.getKriId());
		existingKri.setDeleteFlag("D");
		existingKri.setActiveFlag("N");
		existingKri.setRemarks(kriDTO.getRemarks());
		existingKri.setSupportDoc(kriDTO.getSupportDoc());
		return this.riskKriRepo.save(existingKri);
	}

	@Transactional
	@Override
	public String deleteKriList(List<RiskKriDTO> kriDtoList, String userDetail) {
		int count = 0;
		List<RiskKri> kriList = null;
						kriList = new ArrayList<>();
		for (RiskKriDTO kri : kriDtoList) {
			count = count + 1;
			@SuppressWarnings("unused")
			RiskKriLog krilog = updateKriLog(kri.getKriId());
			RiskKri existingKri = getKriById(kri.getKriId());
			existingKri.setModifiedBy(userDetail);
			existingKri.setDeleteFlag("D");
			existingKri.setActiveFlag("N");
			existingKri.setRemarks("Group Delete");
			kriList.add(this.riskKriRepo.save(existingKri));
		}//kriList.size()
		return StringUtils.replace(KRIConstants.KRI_LIST_DELETE_SUCCESS, KRIConstants.CURLY_BRACKETS_SYMBOL,
				Integer.toString(count));

	}

	private String generateNewVersion(KriPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";
		RiskKri kriCreation = riskKriRepo.findFirstByOrderByCreatedDateDescKriIdDesc();
		int numberPartOfLastCreatedID = 0;
		if (count <= 0) {
			if (kriCreation.getKriUniqueId() != null) {
				String lastCreatedUniqueID = kriCreation.getKriUniqueId();
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
			KriIdPreferenceDTO preference = idPreference
					.updateKriIdPreference(MapperUtils.mapToTargetClass(idPref, KriIdPreferenceDTO.class), "Admin");
			return res;
		}
	}

}
