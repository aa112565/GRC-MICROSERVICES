package com.asymmetrix.grc.Controller;

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

import com.asymmetrix.grc.Dto.PolicyFileUploadDTO;
import com.asymmetrix.grc.Entity.PolicyFileUpload;
import com.asymmetrix.grc.Service.PolicyFileUploadService;
import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;

@RestController
public class FilePolicyUploadController {
	
	@Autowired
	private PolicyFileUploadService DocService;
	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-POLICY-DOC-UPLOAD-DETAILS";
//	private static final String READ_ALL_ACTION = "READ-ALL-Policy-DOC-UPLOAD-DETAILS";
	private static final String READ_ACTION = "READ-POLICY-DOC-UPLOAD-DETAILS";

	PolicyFileUpload uploaddto;
	boolean fileadd = false;
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/policy/doc/ref/{id}")
	public ResponseEntity<?> getAllDocByRefId(@NonNull @PathVariable(value = "id") String refId) {
		return GRCResponseEntity.success(
				MapperUtils.mapToTargetClass(DocService.getAllDocByRefId(refId), PolicyFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/policy/doc/{id}")
	public ResponseEntity<?> getRefById(@NonNull @PathVariable(value = "id") String refId) {
		return GRCResponseEntity.success(
				MapperUtils.mapToTargetClass(DocService.getRefById(refId), PolicyFileUploadDTO.class));
	}
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/policy/doc/new")
	public ResponseEntity<?> createDoc(@NonNull @RequestBody PolicyFileUploadDTO auditDocDto) {

		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(DocService.createDoc(auditDocDto), PolicyFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/policy/doc/modify")
	public ResponseEntity<?> updateDoc(@NonNull @RequestBody PolicyFileUploadDTO auditDocDto) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(DocService.updateDoc(auditDocDto), PolicyFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/policy/doc/remove")
	public ResponseEntity<?> deleteDoc(@NonNull @RequestBody PolicyFileUploadDTO auditDocDto) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(DocService.deleteDoc(auditDocDto), PolicyFileUploadDTO.class));
	}
	
	@GetMapping("/policy/doc/download/{refId}")
	public ResponseEntity<?> findAllAttachment(@NonNull @PathVariable String refId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(DocService.findAllAttachment(refId), PolicyFileUploadDTO.class));
	}


}
