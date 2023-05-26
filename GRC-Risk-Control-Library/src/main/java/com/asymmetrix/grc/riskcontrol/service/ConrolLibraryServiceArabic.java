package com.asymmetrix.grc.riskcontrol.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.riskcontrol.dto.ControlLibraryDTO;
import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryArabic;

public interface ConrolLibraryServiceArabic {

	List<ControlLibraryArabic> getAllControl();

	ControlLibraryArabic getControlById(long controlId);

	String bulkControlCreation(MultipartFile file);

	ControlLibraryArabic createControl(ControlLibraryDTO controlLibrary);

	ControlLibraryArabic updateControl(ControlLibraryDTO controlLibrary);

	ControlLibraryArabic deleteControl(ControlLibraryDTO controlLibrary);

}
