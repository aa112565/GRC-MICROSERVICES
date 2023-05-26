package com.asymmetrix.grc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.TemplateAttachmentsDTO;
import com.asymmetrix.grc.dto.TemplateFileUploadDTO;
import com.asymmetrix.grc.dto.TemplateReqResDTO;
import com.asymmetrix.grc.entity.TemplateFileUpload;
import com.asymmetrix.grc.service.TemplateFileUploadService;

@RestController
public class TemplateFileUploadController {

	@Autowired
	private TemplateFileUploadService templateDocService;

//	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-TEMPLATE-DOC-UPLOAD-DETAILS";
//	private static final String READ_ALL_ACTION = "READ-ALL-TEMPLATE-DOC-UPLOAD-DETAILS";
//	private static final String READ_ACTION = "READ-TEMPLATE-DOC-UPLOAD-DETAILS";

	TemplateFileUpload uploaddto;
	boolean fileadd = false;
	String userName = null;

	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ACTION)
	@GetMapping("/template/doc/ref/{id}")
	public ResponseEntity<?> getAllDocByRefId(@NonNull @PathVariable(value = "id") String refId) {
		return GRCResponseEntity.success(
				MapperUtils.mapToTargetClass(templateDocService.getAllDocByRefId(refId), TemplateFileUploadDTO.class));
	}



	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ACTION)
	@GetMapping("/template/doc/{id}")
	public ResponseEntity<?> getDocById(@NonNull @PathVariable(value = "id") String templateDocId) {
		return GRCResponseEntity.success(
				MapperUtils.mapToTargetClass(templateDocService.getDocById(templateDocId), TemplateFileUploadDTO.class));
	}
	


	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/template/doc/new")
	public ResponseEntity<?> createDoc(@NonNull @RequestBody TemplateFileUploadDTO templateDocDto) {

		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(templateDocService.createDoc(templateDocDto), TemplateFileUploadDTO.class));
	}

/*
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/doc/modify")
	public ResponseEntity<?> updateDoc(@NonNull @RequestBody TemplateFileUploadDTO templateDocDto) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(templateDocService.updateDoc(templateDocDto), TemplateFileUploadDTO.class));
	}
*/
	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/doc/remove")
	public ResponseEntity<?> deleteDoc(@NonNull @RequestBody TemplateFileUploadDTO templateDocDto) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(templateDocService.deleteDocUpdate(templateDocDto.getDocId()), TemplateFileUploadDTO.class));
	}
	
	@GetMapping("/template/doc/download/{refId}")
	public ResponseEntity<?> findAllAttachment(@NonNull @PathVariable String refId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(templateDocService.findAllAttachment(refId), TemplateFileUploadDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_FILE_UPLOAD_ACTION)
	@PostMapping("/template/attachment/new")
	public TemplateReqResDTO createTemplateAttachment(@NonNull @ModelAttribute TemplateAttachmentsDTO vendorAttachment) {
		TemplateReqResDTO resDTO = new TemplateReqResDTO();
		
		@SuppressWarnings("unused")
		String result = templateDocService.createFiles(vendorAttachment, userName);
//		System.out.println("file Upload result  => " + result);
		List<TemplateAttachmentsDTO> fileList = MapperUtils
				.mapToTargetClass(templateDocService.getAllDocByRefId(vendorAttachment.getRefId()), TemplateAttachmentsDTO.class);
		resDTO.setFiles(fileList);		
		return resDTO;
	}
	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ACTION)
	@PostMapping("/template/attachment/histroy")
	public ResponseEntity<?> getDocHistory(@NonNull @RequestBody TemplateFileUploadDTO templateDocDto) {
		return GRCResponseEntity.success(
				MapperUtils.mapToTargetClass(templateDocService.findAttachmentHistory(templateDocDto.getRefId(), templateDocDto.getDocName()), TemplateFileUploadDTO.class));
	}


}
