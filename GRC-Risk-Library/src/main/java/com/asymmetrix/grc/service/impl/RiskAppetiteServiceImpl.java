package com.asymmetrix.grc.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.risk.dao.RiskAppetiteLogRepository;
import com.asymmetrix.grc.risk.dao.RiskAppetiteRepository;

import com.asymmetrix.grc.risk.dto.RiskAppetiteDTO;
import com.asymmetrix.grc.risk.dto.RiskIdPreferenceDTO;
import com.asymmetrix.grc.risk.entity.RiskPreference;
import com.asymmetrix.grc.risk.entity.RiskAppetite;
import com.asymmetrix.grc.risk.entity.RiskAppetiteLog;

import com.asymmetrix.grc.risk.exception.ResourceNotFoundException;
import com.asymmetrix.grc.risk.service.RiskAppetiteService;
import com.asymmetrix.grc.risk.service.RiskIdPreferenceService;

@Service
public class RiskAppetiteServiceImpl implements RiskAppetiteService {

	@Autowired
	private RiskAppetiteRepository riskAppetiteRepo;

	@Autowired
	RiskAppetiteLogRepository riskAppetiteLogRepo;
	
	@Autowired
	private RiskIdPreferenceService idPreference;
	
	private static final String VERSION_PREFIX = "ERM/";


	@Override
	public List<RiskAppetite> getAllAppetite() {
		return this.riskAppetiteRepo.findAllAppetite();
	}

	@Override
	public RiskAppetite getAppetiteById(long appetiteId) {
		return riskAppetiteRepo.findById(appetiteId).orElseThrow(
				() -> new ResourceNotFoundException("Risk-Appetite not found with  Id----> " + appetiteId));
	}

	public List<RiskAppetite> saveAllRiskAppetite(List<RiskAppetite> riskAppetiteList) {
		return this.riskAppetiteRepo.saveAll(riskAppetiteList);
	}

	@Override
	public RiskAppetite createRiskAppetite(RiskAppetiteDTO riskAppetitedto) {
		
		RiskPreference preference = null;
		@SuppressWarnings("unused")
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		@SuppressWarnings("unused")
		String uniqueId = null, module = "Risk Appetite"; 
		
	//	RiskLibraryDTO aDto = MapperUtils.mapToTargetClass(cmAuditDto, RiskLibraryDTO.class);
		int count = idPreference.getRiskIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
		preference = idPreference.getRiskIdPreferenceByModule(module);		
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
		
		RiskAppetite appetite = MapperUtils.mapToTargetClass(riskAppetitedto, RiskAppetite.class);
	//	apDto.setStatus("Initiated");
		appetite.setAppetiteUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			appetite.setPreferenceOganization(preference.getPreferenceOganization());
			}
			if (preference.getPreferenceYear() != null) {
				appetite.setPreferenceYear(preference.getPreferenceYear());
			}		
		
		
		
			appetite.setDeleteFlag("N");
			appetite.setActiveFlag("Y");
	//	RiskAppetite appetite =riskAppetiteRepo.save(MapperUtils.mapToTargetClass(riskAppetitedto, RiskAppetite.class));
		return this.riskAppetiteRepo.save(appetite);	
	}

	
	  public RiskAppetiteLog updateRiskAppetiteLog(RiskAppetiteDTO riskLibrarydto) {
	
	  RiskAppetite risk = MapperUtils.mapToTargetClass(riskLibrarydto, RiskAppetite.class); 
	  RiskAppetite riskAppetite = getAppetiteById(risk.getAppetiteId()); 
	//  riskAppetite.setDeleteFlag("D");
	  RiskAppetiteLog appetite = MapperUtils.mapToTargetClass(riskAppetite,
			  RiskAppetiteLog.class); 
	  return this.riskAppetiteLogRepo.save(appetite); }
	 

//	@Transactional
	@Override
	public RiskAppetite updateRiskAppetite(RiskAppetiteDTO riskAppetitedto) {		
		@SuppressWarnings("unused")
		RiskAppetiteLog log = updateRiskAppetiteLog(riskAppetitedto);
		RiskAppetite riskAppetite = MapperUtils.mapToTargetClass(riskAppetitedto, RiskAppetite.class);
		riskAppetite.setActiveFlag("Y");
		riskAppetite.setDeleteFlag("N");
		return this.riskAppetiteRepo.save(riskAppetite);
	}

	// Risk-Appetite - Soft Delete
	public RiskAppetite deleteUpdate(RiskAppetiteDTO riskAppetitedto) {
		// RiskAppetite appetite = MapperUtils.mapToTargetClass(riskAppetitedto,
		// RiskAppetite.class);
		RiskAppetite appetite = getAppetiteById(riskAppetitedto.getAppetiteId());
		appetite.setDeleteFlag("D");
		appetite.setActiveFlag("N");
		return this.riskAppetiteRepo.save(appetite);
	}

	@Override
	public RiskAppetite deleteRiskAppetite(RiskAppetiteDTO riskAppetitedto) {
		RiskAppetite deleteAppetite = this.deleteUpdate(riskAppetitedto);
		return deleteAppetite;
	}

	
	private String generateNewVersion(RiskPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";		
		RiskAppetite auditPlan = riskAppetiteRepo.findFirstByOrderByCreatedDateDescAppetiteIdDesc();
		int numberPartOfLastCreatedID = 0;
		if ( count <= 0 ) {
			if ( auditPlan.getAppetiteUniqueId() != null ) {
			String lastCreatedworkshopID = auditPlan.getAppetiteUniqueId();		
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(lastCreatedworkshopID);			
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
			RiskIdPreferenceDTO preference = idPreference.updateRiskIdPreference(MapperUtils.mapToTargetClass(idPref,
					RiskIdPreferenceDTO.class), "Admin");
			return res;
		}
	}
	
}
