package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.risk.dao.RiskAppetiteThresholdRepository;

import com.asymmetrix.grc.risk.dto.RiskAppetiteThresholdDTO;
import com.asymmetrix.grc.risk.entity.RiskAppetiteThreshold;
import com.asymmetrix.grc.risk.exception.ResourceNotFoundException;
import com.asymmetrix.grc.risk.service.RiskAppetiteThresholdService;

@Service
public class RiskAppetiteThresholdServiceImpl implements RiskAppetiteThresholdService {

	@Autowired
	private RiskAppetiteThresholdRepository appetiteThresholdRepo;

//	@Autowired
//	RiskLibraryLogRepo riskLibLogRepo;

	@Override
	public List<RiskAppetiteThreshold> getAllRiskAppetiteThreshold() {
		return this.appetiteThresholdRepo.findAllThreshold();
	}

	@Override
	public RiskAppetiteThreshold getRiskAppetiteThresholdByAppetiteID(long appetiteId) {
		return this.appetiteThresholdRepo.findByAppetiteId(appetiteId);
	}

	@Override
	public RiskAppetiteThreshold getRiskAppetiteThresholdById(String thresholdId) {
		return appetiteThresholdRepo.findById(thresholdId).orElseThrow(
				() -> new ResourceNotFoundException("Risk AppetiteThreshold not found with  Id----> " + thresholdId));
	}

	public List<RiskAppetiteThreshold> saveAll(List<RiskAppetiteThreshold> appetiteThresholdList) {
		return this.appetiteThresholdRepo.saveAll(appetiteThresholdList);
	}

	@Override
	public RiskAppetiteThreshold createRiskAppetiteThreshold(RiskAppetiteThresholdDTO appetiteThresholdDto) {
		RiskAppetiteThreshold riskAppetiteThreshold = MapperUtils.mapToTargetClass(appetiteThresholdDto,
				RiskAppetiteThreshold.class);
		riskAppetiteThreshold.setDeleteFlag("N");
		riskAppetiteThreshold.setActiveFlag("Y");
		return this.appetiteThresholdRepo.save(riskAppetiteThreshold);
	}

	/*
	 * public RiskLibraryLog updateRiskAppetiteThresholdLog(RiskAppetiteThresholdDTO
	 * riskLibrarydto) { //
	 * System.out.println("++++++++++++    updateRiskLog  +++++++++");
	 * RiskAppetiteThreshold risk = MapperUtils.mapToTargetClass(riskLibrarydto,
	 * RiskAppetiteThreshold.class); RiskAppetiteThreshold existingAppetiteThreshold
	 * = getRiskAppetiteThresholdById(risk.getThresholdId());
	 * existingAppetiteThreshold.setDeleteFlag("D"); RiskLibraryLog riskLibrary =
	 * MapperUtils.mapToTargetClass(existingAppetiteThreshold,
	 * RiskLibraryLog.class); return this.riskLibLogRepo.save(riskLibrary); }
	 */
	
	@Override
	@Transactional
	public RiskAppetiteThreshold updateRiskAppetiteThreshold(RiskAppetiteThresholdDTO appetiteThresholdDto) {		
		@SuppressWarnings("unused")
		// RiskLibraryLog log = updateRiskLog(riskLibrarydto);
		RiskAppetiteThreshold appetiteThreshold = MapperUtils.mapToTargetClass(appetiteThresholdDto,
				RiskAppetiteThreshold.class);
		appetiteThreshold.setActiveFlag("Y");
		appetiteThreshold.setDeleteFlag("N");
		return this.appetiteThresholdRepo.save(appetiteThreshold);
	}

	// Risk - Soft Delete
	public RiskAppetiteThreshold deleteUpdate(RiskAppetiteThresholdDTO appetiteThresholdDto) {
		// RiskAppetiteThreshold threshold =
		// MapperUtils.mapToTargetClass(appetiteThresholdDto,
		// RiskAppetiteThreshold.class);
		RiskAppetiteThreshold existingAppetiteThreshold = getRiskAppetiteThresholdById(
				appetiteThresholdDto.getThresholdId());
		existingAppetiteThreshold.setDeleteFlag("D");
		existingAppetiteThreshold.setActiveFlag("N");
		return this.appetiteThresholdRepo.save(existingAppetiteThreshold);

	}

	@Override
	public RiskAppetiteThreshold deleteRiskAppetiteThreshold(RiskAppetiteThresholdDTO appetiteThresholdDto) {
		RiskAppetiteThreshold deletAppetiteThreshold = this.deleteUpdate(appetiteThresholdDto);
		return deletAppetiteThreshold;
	}

}
