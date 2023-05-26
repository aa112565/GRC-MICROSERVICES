package com.asymmetrix.grc.riskcontrol.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;
import com.asymmetrix.grc.riskcontrol.entity.ControlLibrary;

public interface ConrolLibraryService {

	List<ControlLibrary> getAllControl();

	ControlLibrary getControlById(long controlId);

	List<ControlLibraryDTO> getActiveControlByList(List<Long> controlIdList);

	String bulkControlCreation(MultipartFile file, String uname);

	ControlLibrary createControl(ControlLibraryDTO controlLibrary);

	ControlLibrary updateControl(ControlLibraryDTO controlLibrary);

	ControlLibrary deleteControl(ControlLibraryDTO controlLibrary);

	String deleteControlList(List<ControlLibraryDTO> controlLibraryList, String username);

}
