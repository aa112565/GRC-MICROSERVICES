package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriMapBusinessLineDTO;
import com.asymmetrix.grc.riskkri.entity.KriMapBusinessLine;

public interface KriMapBusinessLineService {
	
	List<KriMapBusinessLine> getKriMapping();
	KriMapBusinessLine getKriMapById(long mapId);
	KriMapBusinessLine getKriMapByKriId(String kriId);
	long getKriMapBusinessLineCount(String kriId);
	KriMapBusinessLine createKriMap(KriMapBusinessLineDTO kriMapDto);
	KriMapBusinessLine updateKriMap(String kriId, KriMapBusinessLineDTO kriMapDto);
	KriMapBusinessLine deleteKriMap(KriMapBusinessLineDTO kriMapDto);

}
