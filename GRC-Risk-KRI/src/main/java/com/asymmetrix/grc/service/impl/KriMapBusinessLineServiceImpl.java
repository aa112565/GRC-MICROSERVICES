package com.asymmetrix.grc.service.impl;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriMapBusinessLineRepo;
import com.asymmetrix.grc.riskkri.dto.KriMapBusinessLineDTO;
import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriMapBusinessLineService;

@Service
public class KriMapBusinessLineServiceImpl implements KriMapBusinessLineService{

	@Autowired
	private KriMapBusinessLineRepo mapRepo;

	@Override
	public List<KriMapBusinessLine> getKriMapping() {
		return this.mapRepo.findAll();
	}

	@Override
	public KriMapBusinessLine getKriMapById(long mapId) {
		return mapRepo.findById(mapId)
				.orElseThrow(() -> new ResourceNotFoundException("Kri-Map not found with  Id----> " + mapId));
	}

	@Override
	public KriMapBusinessLine getKriMapByKriId(String kriId) {
		return mapRepo.findByKriId(kriId);
	}

	@Override
	public long getKriMapBusinessLineCount(String kriId) {
		return mapRepo.getKriMapBusinessLineCount(kriId);
	}

	@Override
	public KriMapBusinessLine createKriMap(KriMapBusinessLineDTO kriMapDto) {
		KriMapBusinessLine kriMap = MapperUtils.mapToTargetClass(kriMapDto, KriMapBusinessLine.class);
		kriMap.setDeleteFlag("N");
		kriMap.setActiveFlag("Y");
		return mapRepo.save(kriMap);
	}

	@Override
	public KriMapBusinessLine updateKriMap(String kriId, KriMapBusinessLineDTO kriMapDto) {
		@SuppressWarnings("unused")
		KriMapBusinessLine existingKriMap = deleteUpdate(getKriMapByKriId(kriId));
		return createKriMap(kriMapDto);

	}

//  Kri-Map - Soft Delete
	public KriMapBusinessLine deleteUpdate(KriMapBusinessLine kriMap) {
		KriMapBusinessLine existingKriMap = getKriMapById(kriMap.getBuninessLineId());
		existingKriMap.setActiveFlag("N");
		existingKriMap.setDeleteFlag("D");
		return this.mapRepo.save(existingKriMap);
	}

	@Override
	public KriMapBusinessLine deleteKriMap(KriMapBusinessLineDTO kriMapDto) {
		KriMapBusinessLine kriMap = MapperUtils.mapToTargetClass(kriMapDto, KriMapBusinessLine.class);
		kriMap.setActiveFlag("N");
		kriMap.setDeleteFlag("D");
		return this.mapRepo.save(kriMap);
	}

}
