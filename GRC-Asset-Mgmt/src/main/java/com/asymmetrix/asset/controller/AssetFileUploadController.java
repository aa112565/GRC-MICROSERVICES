package com.asymmetrix.asset.controller;

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

import com.asymmetrix.asset.service.AssetFileUploadService;
import com.asymmetrix.asset.common.aspect.Loggable;

import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.entity.AssetFileUpload;

@RestController
public class AssetFileUploadController {

	@Autowired
	private AssetFileUploadService AssetDocService;

	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-ASSET-DOC-UPLOAD-DETAILS";
//	private static final String READ_ALL_ACTION = "READ-ALL-ASSET-DOC-UPLOAD-DETAILS";
	private static final String READ_ACTION = "READ-ASSET-DOC-UPLOAD-DETAILS";

	AssetFileUpload uploaddto;
	boolean fileadd = false;
	/*
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @Loggable(action = READ_ALL_ACTION)
	 * 
	 * @GetMapping("/asset/doc/all") public ResponseEntity<?> getAllDoc() { return
	 * AssetResponseEntity
	 * .success(MapperUtils.mapToTargetClass(AssetDocService.getAllDoc(),
	 * AssetFileUploadDTO.class)); }
	 */

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/doc/ref/{id}")
	public ResponseEntity<?> getAllDocByRefId(@NonNull @PathVariable(value = "id") String refId) {
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetDocService.getAllDocByRefId(refId), AssetFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ACTION)
	@GetMapping("/asset/doc/{id}")
	public ResponseEntity<?> getDocById(@NonNull @PathVariable(value = "id") String assetDocId) {
		return AssetResponseEntity.success(
				MapperUtils.mapToTargetClass(AssetDocService.getDocById(assetDocId), AssetFileUploadDTO.class));
	}

	/*
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @Loggable(action = SAVE_OR_EDIT_ACTION)
	 * 
	 * @PostMapping("/asset/doc/save/all") public
	 * ResponseEntity<AssetResponse<List<AssetFileUpload>>> saveAllDoc(
	 * 
	 * @NonNull @RequestBody List<AssetFileUpload> riskKriAll) { return
	 * AssetResponseEntity.success(AssetDocService.saveAllDoc(riskKriAll)); }
	 */

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/asset/doc/new")
	public ResponseEntity<?> createDoc(@NonNull @RequestBody AssetFileUploadDTO assetFile) {

		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(AssetDocService.createDoc(assetFile), AssetFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/asset/doc/modify")
	public ResponseEntity<?> updateDoc(@NonNull @RequestBody AssetFileUploadDTO assetFile) {
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(AssetDocService.updateDoc(assetFile), AssetFileUploadDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/asset/doc/remove")
	public ResponseEntity<?> deleteDoc(@NonNull @RequestBody AssetFileUploadDTO assetFile) {
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(AssetDocService.deleteDoc(assetFile), AssetFileUploadDTO.class));
	}

}
