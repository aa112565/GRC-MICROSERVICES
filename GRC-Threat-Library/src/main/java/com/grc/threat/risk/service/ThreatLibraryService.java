package com.grc.threat.risk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.grc.threat.risk.dto.ThreatLibraryDTO;
import com.grc.threat.risk.entity.ThreatLibrary;

public interface ThreatLibraryService {

	List<ThreatLibrary> getAllThreat();

	ThreatLibrary getThreatById(long threatId);

	List<ThreatLibraryDTO> getActiveThreatByList(List<Long> threatIdList);

	String bulkThreatCreation(MultipartFile file, String uname);

	ThreatLibrary createThreat(ThreatLibraryDTO threatLibrary);

	ThreatLibrary updateThreat(ThreatLibraryDTO threatLibrary);

	ThreatLibrary deleteThreat(ThreatLibraryDTO threatLibrary);

	String deleteThreatList(List<ThreatLibraryDTO> threatLibraryList, String username);

}
