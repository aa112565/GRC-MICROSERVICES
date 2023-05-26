package com.grc.itrisk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.grc.itrisk.common.aspect.Loggable;
import com.grc.itrisk.common.response.ITRiskResponseEntity;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dto.AssessmentFileUploadDTO;
import com.grc.itrisk.entity.AssessmentFileUpload;
import com.grc.itrisk.service.AssessmentFileUploadService;

@RestController
public class AssessmentFileUploadController {

	@Autowired
	private AssessmentFileUploadService vendorDocService;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ASSESSMENT-DOC-UPLOAD-DETAILS";
//	private static final String READ_ALL_ACTION = "READ-ALL-ASSESSMENT-DOC-UPLOAD-DETAILS";
	private static final String READ_ACTION = "READ-ASSESSMENT-DOC-UPLOAD-DETAILS";

	AssessmentFileUpload uploaddto;
	boolean fileadd = false;
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/assessment/doc/ref/{id}")
	public ResponseEntity<?> getAllDocByRefId(@NonNull @PathVariable(value = "id") String refId) {
		return ITRiskResponseEntity.success(
				MapperUtils.mapToTargetClass(vendorDocService.getAllDocByRefId(refId), AssessmentFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/assessment/doc/{id}")
	public ResponseEntity<?> getDocById(@NonNull @PathVariable(value = "id") String vendorDocId) {
		return ITRiskResponseEntity.success(
				MapperUtils.mapToTargetClass(vendorDocService.getDocById(vendorDocId), AssessmentFileUploadDTO.class));
	}
	


	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/assessment/doc/new")
	public ResponseEntity<?> createDoc(@NonNull @RequestBody AssessmentFileUploadDTO vendorDocDto) {

		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(vendorDocService.createDoc(vendorDocDto), AssessmentFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/doc/modify")
	public ResponseEntity<?> updateDoc(@NonNull @RequestBody AssessmentFileUploadDTO vendorDocDto) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(vendorDocService.updateDoc(vendorDocDto), AssessmentFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/assessment/doc/remove")
	public ResponseEntity<?> deleteDoc(@NonNull @RequestBody AssessmentFileUploadDTO vendorDocDto) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(vendorDocService.deleteDoc(vendorDocDto), AssessmentFileUploadDTO.class));
	}
	
	@GetMapping("/assessment/doc/download/{refId}")
	public ResponseEntity<?> findAllAttachment(@NonNull @PathVariable String refId) {
		return ITRiskResponseEntity
				.success(MapperUtils.mapToTargetClass(vendorDocService.findAllAttachment(refId), AssessmentFileUploadDTO.class));
	}

}
