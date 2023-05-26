package com.asymmetrix.grc.riskcontrol.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;

import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryThai;

public interface ConrolLibraryServiceThai {

	List<ControlLibraryThai> getAllControl();

	ControlLibraryThai getControlById(long controlId);

	String bulkControlCreation(MultipartFile file);

	ControlLibraryThai createControl(ControlLibraryDTO controlLibrary);

	ControlLibraryThai updateControl(ControlLibraryDTO controlLibrary);

	ControlLibraryThai deleteControl(ControlLibraryDTO controlLibrary);

}
