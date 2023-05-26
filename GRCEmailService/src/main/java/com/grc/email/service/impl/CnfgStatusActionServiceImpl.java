package com.grc.email.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grc.email.common.constants.GRCConstants;
import com.grc.email.common.utils.MapperUtils;
import com.grc.email.dto.CnfgStatusActionDTO;
import com.grc.email.repository.CnfgStatusActionRepository;
import com.grc.email.service.CnfgStatusActionService;

@Service
public class CnfgStatusActionServiceImpl implements CnfgStatusActionService{
	
	@Resource
	private CnfgStatusActionRepository statusActionRepo;
	
	@Override
	public List<CnfgStatusActionDTO> getAllStatusActionDetails(){
		return MapperUtils.mapToTargetClass(statusActionRepo.findAll(), CnfgStatusActionDTO.class);
	}
	/*@Override
	public List<CnfgStatusActionDTO> getStatusActionByLevel(String level) {
		return MapperUtils.mapToTargetClass(statusActionRepo.findByLevel(level), CnfgStatusActionDTO.class);
	}*/
	@Override
	public List<CnfgStatusActionDTO> getStatusActionByLevel(String level) {
		List<CnfgStatusActionDTO> templist = MapperUtils.mapToTargetClass(statusActionRepo.findByLevel(level), CnfgStatusActionDTO.class);
		
		Map<String, CnfgStatusActionDTO> menuMap = new HashMap<>();
	    templist.forEach(m -> menuMap.merge(m.getStatus(), m, (o, n) -> {
	      return mapMenu(o, n);
	    }));
	    return new ArrayList<>(menuMap.values());
	}
	private static CnfgStatusActionDTO mapMenu(CnfgStatusActionDTO model1, CnfgStatusActionDTO model2) {
		CnfgStatusActionDTO cnfgMenu = new CnfgStatusActionDTO();
	    cnfgMenu.setLevel(model1.getLevel());
	    cnfgMenu.setLevelType(model1.getLevelType());
	    cnfgMenu.setStatus(model1.getStatus());
	    cnfgMenu.setAction(model1.getAction().concat(GRCConstants.COMMA).concat(model2.getAction()));
	    return cnfgMenu;
	  }
	

}
