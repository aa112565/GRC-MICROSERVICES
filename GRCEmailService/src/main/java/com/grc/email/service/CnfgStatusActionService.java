package com.grc.email.service;

import java.util.List;

import com.grc.email.dto.CnfgStatusActionDTO;

public interface CnfgStatusActionService {
	public List<CnfgStatusActionDTO> getAllStatusActionDetails();
	public List<CnfgStatusActionDTO> getStatusActionByLevel(String level);
}
