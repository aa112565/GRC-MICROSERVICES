package com.asymmetrix.grc.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.PolicyIdPreferenceDTO;
import com.asymmetrix.grc.Dto.PolicyPreferenceDTO;
import com.asymmetrix.grc.Entity.PolicyIdPreference;
import com.asymmetrix.grc.Repository.PolicyIdPreferenceRepository;
import com.asymmetrix.grc.Service.PolicyIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;


@SuppressWarnings("unused")
@Service
public class PolicyIdPreferenceServiceimpl implements PolicyIdPreferenceService {
	

	@Resource
	private PolicyIdPreferenceRepository policyIdPreferenceRepo;

	@Override
	public List<PolicyIdPreference> getAllPolicyIdPreferenceByActiveflag() {
		return this.policyIdPreferenceRepo.findAllByActiveflag();
	}

	@Override
	public PolicyIdPreference getPolicyIdPreferenceById(long seriesId) {
		return policyIdPreferenceRepo.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("POLICY ID Preference not found with  Id----> " + seriesId));
	}	

	@Override
	public PolicyIdPreferenceDTO createPolicyIdPreference(PolicyIdPreferenceDTO preferenceDto, String userName) {
		int temCount =  this.policyIdPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (temCount > 0) {
			throw new ResourceNotFoundException(" ID Preference found with  Module ----------->"+ preferenceDto.getPreferenceModule().trim() );
		}		
		int tempCount = getPolicyIdPreferenceCountByActiveflag(preferenceDto.getPreferenceModule().trim());
		if(tempCount <= 0 ) {
			PolicyPreferenceDTO atDto = MapperUtils.mapToTargetClass(preferenceDto, PolicyPreferenceDTO.class);
			//	apDto.setStatus("Initiated");
				atDto.setDeleteFlag("N");
				atDto.setActiveFlag("Y");
				atDto.setStatus("Y");
				atDto.setCreatedBy(userName);		
				PolicyIdPreference atFinding = policyIdPreferenceRepo.save(MapperUtils.mapToTargetClass(atDto, PolicyIdPreference.class));
			return MapperUtils.mapToTargetClass(atFinding, PolicyIdPreferenceDTO.class);
		} else {		
			throw new ResourceNotFoundException("ID Preference found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
		//	AMAuditPreferenceDTO idPreferenceDto = MapperUtils.mapToTargetClass(getAuditIdPreferenceByModule(preferenceDto.getPreferenceModule().trim()), AMAuditPreferenceDTO.class);
		//	return idPreferenceDto;
		}
	}

	@Override
	public List<PolicyIdPreference> saveAllPolicyIdPreference(List<PolicyIdPreference> preferenceList) {
		return this.policyIdPreferenceRepo.saveAll(preferenceList);
	}

	@Override
	public PolicyIdPreferenceDTO updatePolicyIdPreference(PolicyIdPreferenceDTO preferenceDto, String userName) {
		PolicyIdPreference preference = getPolicyIdPreferenceById(preferenceDto.getSeriesId());
		if (preference.getPreferenceModule().equals(preferenceDto.getPreferenceModule())) {
			PolicyIdPreferenceDTO preferenceLog = deletePolicyIdPreference(preferenceDto, userName);
			PolicyPreferenceDTO atPreferenceDto = MapperUtils.mapToTargetClass(preferenceDto, PolicyPreferenceDTO.class);
			atPreferenceDto.setActiveFlag("Y");
			atPreferenceDto.setDeleteFlag("N");
		//	atPreferenceDto.setStatus("Y");
			atPreferenceDto.setCreatedBy(preference.getCreatedBy());
			atPreferenceDto.setModifiedBy(userName);			
			PolicyIdPreference atFinding = policyIdPreferenceRepo.save(MapperUtils.mapToTargetClass(atPreferenceDto, PolicyIdPreference.class));		
			return MapperUtils.mapToTargetClass(atFinding, PolicyIdPreferenceDTO.class);
			}else 
			{
			throw new ResourceNotFoundException("ID Preference not found with  Module ----> " + preferenceDto.getPreferenceModule().trim());
			}
	}

	@Override
	public PolicyIdPreferenceDTO deletePolicyIdPreference(PolicyIdPreferenceDTO preferenceDto, String userName) {
		PolicyIdPreference preference = getPolicyIdPreferenceById(preferenceDto.getSeriesId());
		preference.setDeleteFlag("D");
		preference.setActiveFlag("N");
		preference.setStatus("N");
		preference.setModifiedBy(userName);
		return MapperUtils.mapToTargetClass(preference, PolicyIdPreferenceDTO.class);
	}

	

	@Override
	public int getPolicyIdPreferenceCountByActiveflag(String preferenceModule) {
		return this.policyIdPreferenceRepo.getPolicyIdPreferenceCountByModule(preferenceModule);
	}

	@Override
	public PolicyIdPreference getPolicyIdPreferenceByModule(String preferenceModule) {
		PolicyIdPreference idPreference =  policyIdPreferenceRepo.getPolicyIdPreferenceByModule(preferenceModule);
		return idPreference;	
	}

	@Override
	public int findNewIdPreferenceCountByStatusFlag(String preferenceModule) {
		return this.policyIdPreferenceRepo.findNewIdPreferenceCountByStatusFlag(preferenceModule);
	}

	@Override
	public String findNewIdPreference(PolicyIdPreferenceDTO preferenceDto) {
		int tempCount =  this.policyIdPreferenceRepo.findNewIdPreference(preferenceDto.getPreferenceOganization(), preferenceDto.getPreferenceYear(), preferenceDto.getRunningSeries());
		if (tempCount > 0) {
			return "ID not Available";
		}else {		
		return "ID Available";
		}
	}

}
