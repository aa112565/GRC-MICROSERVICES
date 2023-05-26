package com.asymmetrix.grc.risk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.risk.dto.RiskLibraryDTO;
import com.asymmetrix.grc.risk.dto.RiskLibraryExportDTO;
import com.asymmetrix.grc.risk.dto.RiskRegistWithScoringDTO;
import com.asymmetrix.grc.risk.dto.RiskRegisterActiveRiskListDTO;
import com.asymmetrix.grc.risk.dto.RiskRegisterActiveRiskScoringListDTO;
import com.asymmetrix.grc.risk.dto.RiskRegisterDTO;
import com.asymmetrix.grc.risk.dto.RiskScoringDTO;
import com.asymmetrix.grc.risk.entity.RiskLibrary;

public interface RiskLibraryService {

	List<RiskLibrary> getAllRisk();

	RiskLibrary getRiskById(long riskId);

	String bulkRiskCreation(MultipartFile file, String uname);

	RiskLibrary createRisk(RiskLibraryDTO riskLibrarydto);

	RiskLibrary updateRisk(RiskLibraryDTO riskLibrarydto);

	RiskLibrary deleteRisk(RiskLibraryDTO riskLibrarydto);

	List<RiskLibraryDTO> getRiskbyList(List<Long> riskIdList);

	List<RiskLibraryExportDTO> getRiskExportList(List<RiskScoringDTO> listRiskScoringDTO);

	List<RiskRegisterActiveRiskListDTO> getActiveRiskIdsList(List<RiskRegisterDTO> activeRiskIdsList);

	List<RiskRegisterActiveRiskScoringListDTO> getActiveRiskIdsScoringList(
			List<RiskRegistWithScoringDTO> activeRiskIdsList);

	String deleteRiskList(List<RiskLibraryDTO> riskLibraryList, String userInfo);

}
