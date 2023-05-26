package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.utils.constants.GRCConstants;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;
import com.asymmetrix.grc.dto.ImpactRiskRatingDTO;
import com.asymmetrix.grc.dto.LikelihoodRiskRatingDTO;
import com.asymmetrix.grc.dto.RiskControlMappingDTO;
import com.asymmetrix.grc.dto.RiskRegistWithScoringDTO;
import com.asymmetrix.grc.dto.RiskRegisterDTO;
import com.asymmetrix.grc.dto.RiskScoringDTO;
import com.asymmetrix.grc.entity.ImpactRiskRating;
import com.asymmetrix.grc.entity.LikelihoodRiskRating;
import com.asymmetrix.grc.entity.RiskControlMapping;
import com.asymmetrix.grc.entity.RiskRating;
import com.asymmetrix.grc.entity.RiskRegister;
import com.asymmetrix.grc.entity.RiskRegisterMapping;
import com.asymmetrix.grc.entity.RiskScoring;
import com.asymmetrix.grc.repository.ImpactRiskRatingRepository;
import com.asymmetrix.grc.repository.InherentRiskRatingMatrixRepository;
import com.asymmetrix.grc.repository.LikelihoodRiskRatingRepository;
import com.asymmetrix.grc.repository.ResidualRiskRatingMatrixRepository;
import com.asymmetrix.grc.repository.RiskControlMappingRepository;
import com.asymmetrix.grc.repository.RiskCurrencyRepository;
import com.asymmetrix.grc.repository.RiskRatingRepository;
import com.asymmetrix.grc.repository.RiskRegisterMappingRepository;
import com.asymmetrix.grc.repository.RiskRegisterRepository;
import com.asymmetrix.grc.repository.RiskScoringRepository;
import com.asymmetrix.grc.service.RiskRegisterService;

@Service
public class RiskRegisterServiceImpl implements RiskRegisterService {

	@Resource
	RiskRegisterRepository riskRegRepo;

	@Resource
	RiskRegisterMappingRepository riskRegMapRepo;

	@Resource
	RiskControlMappingRepository riskControlRepo;

	@Resource
	RiskCurrencyRepository riskCurrencyRepo;

	@Resource
	ImpactRiskRatingRepository impactRatingRepo;

	@Resource
	LikelihoodRiskRatingRepository likelihoodRatingRepo;

	@Resource
	RiskRatingRepository riskRatingRepo;

	@Resource
	RiskScoringRepository riskScoringRepo;

	@Resource
	InherentRiskRatingMatrixRepository inherentRiskRatingRepo;

	@Resource
	ResidualRiskRatingMatrixRepository residualRiskRatingRepo;

	private static final String ACTIVE_FLAG = "Y";

	@Override
	public List<RiskRegisterDTO> getAllActiveRiskIds() {

		/*
		 * List<RiskRegister> riskRegObj = riskRegRepo.findAllByModifiedDate();
		 * List<RiskRegisterDTO> riskRegistrationListDTO = new ArrayList<>();
		 * 
		 * for (RiskRegister riskRegisrationObj : riskRegObj) { int count =
		 * riskRegMapRepo.findActiveRiskIdsConut(riskRegisrationObj.getRiskRegId()); if
		 * (count > 0) { List<RiskRegisterDTO> riskRegMap =
		 * MapperUtils.mapToTargetClass(
		 * riskRegMapRepo.findAllActiveRiskIds(riskRegisrationObj.getRiskRegId()),
		 * RiskRegisterDTO.class); for (RiskRegisterDTO riskRegMapObj : riskRegMap) {
		 * RiskRegisterDTO riskRegDTO = MapperUtils.mapToTargetClass(riskRegisrationObj,
		 * RiskRegisterDTO.class); riskRegDTO.setRiskId(riskRegMapObj.getRiskId());
		 * riskRegistrationListDTO.add(riskRegDTO); } } }
		 * 
		 */
		List<RiskRegisterDTO> riskRegDto = null;
		long count = riskRegMapRepo.countByActive();
		System.out.println("+++++++++++++++++++ActiveRisk++++++++++++++++-Count++++++++++++++++" + count);
		if (count > 0) {
			riskRegDto = riskRegMapRepo.findAllActiveRiskAndRegiserIdsDto();
		}
		return riskRegDto;

	}

	@Override
	public List<RiskRegistWithScoringDTO> getAllActiveRiskIdswithScoring() {

		List<RiskRegistWithScoringDTO> riskRegistrationScoringListDto = new ArrayList<>();

		List<RiskRegisterDTO> riskRegistrationListDTO = getAllActiveRiskIds();
		for (RiskRegisterDTO riskRegisrationObj : riskRegistrationListDTO) {
			long count = riskScoringRepo.countByRiskRegIdAndRiskId(riskRegisrationObj.getRiskRegId(),
					riskRegisrationObj.getRiskId());
			if (count > 0) {
				System.out.println(
						"+++++++++++++++++++countByRiskRegIdAndRiskId++++++++++++++++count++++++++++++++++" + count);
				RiskScoringDTO riskScoring = getRiskScoringById(riskRegisrationObj.getRiskRegId(),
						riskRegisrationObj.getRiskId());
				RiskRegistWithScoringDTO riskRegScoringDto = new RiskRegistWithScoringDTO();
				riskRegScoringDto = MapperUtils.mapToTargetClass(riskRegisrationObj, RiskRegistWithScoringDTO.class);
				riskRegScoringDto.setInherentImpactRating(riskScoring.getInherentImpactRating());
				riskRegScoringDto.setInherentLikelihoodRating(riskScoring.getInherentLikelihoodRating());
				riskRegScoringDto.setInherentRiskRating(riskScoring.getInherentRiskRating());
				riskRegScoringDto.setResidualRiskRating(riskScoring.getResidualRiskRating());
				riskRegScoringDto.setApprovalInitStatus(riskScoring.getApprovalInitStatus());
				riskRegistrationScoringListDto.add(riskRegScoringDto);

			}
		}
		return riskRegistrationScoringListDto;
	}

	@Override
	public List<RiskRegistWithScoringDTO> getApprovalListwithScoring() {

		List<RiskRegistWithScoringDTO> riskRegistrationScoringListDto = new ArrayList<>();

		long count = riskScoringRepo.countByActive();
		System.out
				.println("+++++++++++++++++++RiskScoring - Approval List++++++++++++++++count++++++++++++++++" + count);
		if (count > 0) {
			List<RiskScoring> riskScoring = riskScoringRepo.findByActiveOrderBySrnoDesc(ACTIVE_FLAG);

			for (RiskScoring riskRegisrationObj : riskScoring) {
				RiskRegistWithScoringDTO riskRegScoringDto = new RiskRegistWithScoringDTO();
//		System.out.println("+++++++++++++++++++RiskScoring - Approval List++++++++++++++++RiskRegId()++++++++++++++++"+riskRegisrationObj.getRiskRegId());
				RiskRegister register = riskRegRepo.findByRiskRegId(riskRegisrationObj.getRiskRegId());
				riskRegScoringDto = MapperUtils.mapToTargetClass(register, RiskRegistWithScoringDTO.class);
				//
				riskRegScoringDto.setInherentImpactRating(riskRegisrationObj.getInherentImpactRating());
				riskRegScoringDto.setInherentLikelihoodRating(riskRegisrationObj.getInherentLikelihoodRating());
				riskRegScoringDto.setInherentRiskRating(riskRegisrationObj.getInherentRiskRating());
				riskRegScoringDto.setResidualRiskRating(riskRegisrationObj.getResidualRiskRating());
				riskRegScoringDto.setApprovalInitStatus(riskRegisrationObj.getApprovalInitStatus());
				riskRegScoringDto.setRiskId(riskRegisrationObj.getRiskId());
				riskRegistrationScoringListDto.add(riskRegScoringDto);
			}
		}
		return riskRegistrationScoringListDto;
	}

	@Override
	public List<RiskRegistWithScoringDTO> getApprovalActionwithScoring() {

		List<RiskRegistWithScoringDTO> riskRegistrationScoringListDto = new ArrayList<>();

		long count = riskScoringRepo.countByActiveAndApprovalFlag();
		System.out
				.println("+++++++++++++++++++RiskScoring - Approval List++++++++++++++++count++++++++++++++++" + count);
		if (count > 0) {
			List<RiskScoring> riskScoring = riskScoringRepo.findByActiveAndApprovalFlagOrderBySrnoDesc(ACTIVE_FLAG,
					ACTIVE_FLAG);

			for (RiskScoring riskRegisrationObj : riskScoring) {
				RiskRegistWithScoringDTO riskRegScoringDto = new RiskRegistWithScoringDTO();
				RiskRegister register = riskRegRepo.findByRiskRegId(riskRegisrationObj.getRiskRegId());
				riskRegScoringDto = MapperUtils.mapToTargetClass(register, RiskRegistWithScoringDTO.class);
				//
				riskRegScoringDto.setInherentImpactRating(riskRegisrationObj.getInherentImpactRating());
				riskRegScoringDto.setInherentLikelihoodRating(riskRegisrationObj.getInherentLikelihoodRating());
				riskRegScoringDto.setInherentRiskRating(riskRegisrationObj.getInherentRiskRating());
				riskRegScoringDto.setResidualRiskRating(riskRegisrationObj.getResidualRiskRating());
				riskRegScoringDto.setApprovalInitStatus(riskRegisrationObj.getApprovalInitStatus());
				riskRegScoringDto.setRiskId(riskRegisrationObj.getRiskId());
				riskRegistrationScoringListDto.add(riskRegScoringDto);
			}
		}
		return riskRegistrationScoringListDto;
	}

	@Override
	public RiskRegisterDTO getActiveRiskIds(String wsId, String deptId) {
		// RiskRegister riskRegObj = riskRegRepo.findByWsIdAndDeptId(wsId, deptId);
		RiskRegister riskRegObj = riskRegRepo.findByWsIdAndDeptIdByBranch(wsId, deptId);
		if (ObjectUtils.isEmpty(riskRegObj)) {
			return new RiskRegisterDTO();
		}
		List<Long> riskIds = riskRegMapRepo.findActiveRiskIds(riskRegObj.getRiskRegId());
		GRCUtils.isValid(riskIds, GRCErrorConstants.ENTITY_NOT_FOUND + riskRegObj.getRiskRegId());
		RiskRegisterDTO riskRegDTO = MapperUtils.mapToTargetClass(riskRegObj, RiskRegisterDTO.class);
		riskRegDTO.setActiveRiskIds(riskIds);
		return riskRegDTO;
	}

	@Override
	public String saveRiskRegister(RiskRegisterDTO model) {
		RiskRegister riskReg = riskRegRepo.save(MapperUtils.mapToTargetClass(model, RiskRegister.class));
		return riskReg.getRiskRegId();
	}

	@Override
	public void saveRiskRegMapping(String riskRegisterId, List<Long> riskIds, String ownerName) {
		riskIds.stream().map(e -> new RiskRegisterMapping(riskRegisterId, e, 'Y')).collect(Collectors.toList());

		List<RiskRegisterMapping> entityList = new ArrayList<>();
		for (long l : riskIds) {
			entityList.add(new RiskRegisterMapping(riskRegisterId, l, 'Y', ownerName));
		}
		riskRegMapRepo.saveAll(entityList);
	}

	@Override
	public RiskRegister saveToRiskRegAndRiskRegMapping(RiskRegisterDTO model) {
		// RiskRegister riskRegObj = riskRegRepo.findByWsIdAndDeptId(model.getWsId(),
		// model.getDeptId());
		RiskRegister riskRegObj = riskRegRepo.findByWsIdAndDeptIdByBranch(model.getWsId(), model.getDeptId());
		String riskRegisterId;
		if (ObjectUtils.isEmpty(riskRegObj)) {
			riskRegisterId = saveRiskRegister(model);
		} else {
			riskRegisterId = riskRegObj.getRiskRegId();
			inActivateRiskAndControlMapping(riskRegisterId, model.getActiveRiskIds());
		}
		saveRiskRegMapping(riskRegisterId, model.getActiveRiskIds(), model.getOwnerName());
		return riskRegRepo.findByWsIdAndDeptId(model.getWsId(), model.getDeptId());
		// return riskRegRepo.findByWsIdAndDeptIdByBranch(model.getWsId(),
		// model.getDeptId());
	}

	private void inActivateRiskAndControlMapping(String riskRegisterId, List<Long> activeRiskIds) {
		List<Long> exisitingIds = riskRegMapRepo.findActiveRiskIds(riskRegisterId);
		exisitingIds.removeAll(activeRiskIds);
		riskControlRepo.setRiskControlAsInActiveById(riskRegisterId, exisitingIds);
		riskRegMapRepo.setRiskAsInActiveByRiskRegId(riskRegisterId);
	}

	@Override
	public String saveRiskControlMapping(RiskControlMappingDTO model) {
		List<Long> activeControlIds = riskControlRepo.findActiveControlIds(model.getRiskRegId(), model.getRiskId());
		if (!ObjectUtils.isEmpty(activeControlIds)) {
			riskControlRepo.setRiskControlAsInActiveById(model.getRiskRegId(), toRiskIdList(model.getRiskId()));
		}
		List<RiskControlMapping> entityList = new ArrayList<>();
		for (long l : model.getControlIds()) {
			entityList.add(new RiskControlMapping(model.getRiskRegId(), model.getRiskId(), l, 'Y'));
		}
		riskControlRepo.saveAll(entityList);
		return GRCConstants.SUCCESS;
	}

	private List<Long> toRiskIdList(Long riskId) {
		List<Long> riskIds = new ArrayList<>();
		riskIds.add(riskId);
		return riskIds;
	}

	@Override
	public RiskControlMappingDTO getActiveControlIds(String riskRegisterId, Long riskId) {
		List<Long> controlIds = riskControlRepo.findActiveControlIds(riskRegisterId, riskId);
		return new RiskControlMappingDTO(riskRegisterId, riskId, controlIds);
	}

	@Override
	public List<String> getCurrencyList() {
		return riskCurrencyRepo.getAll();
	}

	@Override
	public List<ImpactRiskRatingDTO> getImpactRatingList() {
		List<ImpactRiskRating> dropDownList = impactRatingRepo.findAll();
		return dropDownList.stream()
				.map(e -> new ImpactRiskRatingDTO(e.getSrno(), e.getImpactRating(), e.getImpactRatingScoreVal()))
				.collect(Collectors.toList());
	}

	@Override
	public List<ImpactRiskRatingDTO> getImpactRatingListDesc() {
		List<ImpactRiskRating> dropDownList = impactRatingRepo.findImpatingRatingDesc();
		return dropDownList.stream()
				.map(e -> new ImpactRiskRatingDTO(e.getSrno(), e.getImpactRating(), e.getImpactRatingScoreVal()))
				.collect(Collectors.toList());
	}

	@Override
	public List<LikelihoodRiskRatingDTO> getlikeLihoodRatingList() {
		List<LikelihoodRiskRating> dropDownList = likelihoodRatingRepo.findAll();
		return dropDownList.stream().map(
				e -> new LikelihoodRiskRatingDTO(e.getSrno(), e.getLikeLihoodRating(), e.getLikeLihoodRatingScoreVal()))
				.collect(Collectors.toList());
	}

	@Override
	public List<LikelihoodRiskRatingDTO> getlikeLihoodRatingListAsc() {
		List<LikelihoodRiskRating> dropDownList = likelihoodRatingRepo.findLikeLihoodRatingAsc();
		return dropDownList.stream().map(
				e -> new LikelihoodRiskRatingDTO(e.getSrno(), e.getLikeLihoodRating(), e.getLikeLihoodRatingScoreVal()))
				.collect(Collectors.toList());
	}

	@Override
	public List<RiskRating> getRiskRatingList() {
		return riskRatingRepo.findAll();
	}

	@Override
	public RiskScoringDTO getRiskScoringById(String riskRegId, Long riskId) {
		RiskScoring riskScoring = riskScoringRepo.findByRiskRegIdAndRiskIdAndActive(riskRegId, riskId, ACTIVE_FLAG);
		return MapperUtils.mapToTargetClass(riskScoring, RiskScoringDTO.class);
	}

	@Override
	public RiskScoringDTO saveRiskScoring(RiskScoringDTO model) {
		RiskScoring riskScoring = riskScoringRepo.findByRiskRegIdAndRiskIdAndActive(model.getRiskRegId(),
				model.getRiskId(), ACTIVE_FLAG);
		if (!ObjectUtils.isEmpty(riskScoring)) {
			// Make it inactive
			riskScoringRepo.updateRiskScoringToInactive(model.getRiskRegId(), model.getRiskId());
		}

		if (!ObjectUtils.isEmpty(riskScoring)) {
			model.setApprovalInitStatus(riskScoring.getApprovalInitStatus());
			model.setApprovalFlag(riskScoring.getApprovalFlag());
		}

		model.setSrno(0);
		model.setActive(ACTIVE_FLAG);

		return MapperUtils.mapToTargetClass(
				riskScoringRepo.save(MapperUtils.mapToTargetClass(model, RiskScoring.class)), RiskScoringDTO.class);
	}

	@Override
	public String getInherentRiskRating(String impact, String likelihood) {
		return inherentRiskRatingRepo.getInherentRiskRating(impact, likelihood);
	}

	@Override
	public String getResidualRiskRating(String impact, String likelihood) {
		return residualRiskRatingRepo.getResidualRiskRating(impact, likelihood);
	}

	@Override
	public List<ImpactRiskRatingDTO> getImpactRatingListByScore(String impactRating) {
		List<ImpactRiskRating> dropDownList = impactRatingRepo
				.findByImpactRatingScoreValLessThanEqual(getImpactScoreByRating(impactRating));
		return dropDownList.stream()
				.map(e -> new ImpactRiskRatingDTO(e.getSrno(), e.getImpactRating(), e.getImpactRatingScoreVal()))
				.collect(Collectors.toList());
	}

	private String getImpactScoreByRating(String impactRating) {
		ImpactRiskRating impactRiskRating = impactRatingRepo.findByImpactRating(impactRating);
		GRCUtils.isValid(impactRiskRating, GRCErrorConstants.ENTITY_NOT_FOUND.concat(impactRating));
		return impactRiskRating.getImpactRatingScoreVal();
	}

	@Override
	public List<LikelihoodRiskRatingDTO> getLikeLihoodRatingListByScore(String likeLihoodRating) {
		List<LikelihoodRiskRating> dropDownList = likelihoodRatingRepo
				.findByLikeLihoodRatingScoreValLessThanEqual(getLikeLihoodScoreByRating(likeLihoodRating));
		return dropDownList.stream().map(
				e -> new LikelihoodRiskRatingDTO(e.getSrno(), e.getLikeLihoodRating(), e.getLikeLihoodRatingScoreVal()))
				.collect(Collectors.toList());
	}

	private String getLikeLihoodScoreByRating(String likeLihoodRating) {
		LikelihoodRiskRating likelihoodRiskRating = likelihoodRatingRepo
				.findByLikeLihoodRating(likeLihoodRating.trim());
		GRCUtils.isValid(likelihoodRiskRating, GRCErrorConstants.ENTITY_NOT_FOUND.concat(likeLihoodRating));
		return likelihoodRiskRating.getLikeLihoodRatingScoreVal();
	}

}
