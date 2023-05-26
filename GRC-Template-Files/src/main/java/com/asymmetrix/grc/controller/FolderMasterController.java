package com.asymmetrix.grc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.MapperUtils;
//import com.asymmetrix.grc.dto.FolderMasterDDDTO;
import com.asymmetrix.grc.dto.FolderMasterDTO;
import com.asymmetrix.grc.service.FolderMasterService;

@SuppressWarnings("unused")
@RestController
public class FolderMasterController {

	@Autowired
	private FolderMasterService orgService;

	private static final String READ_ACTION = "READ-FOLDER-MASTER-DETAILS";
	private static final String READ_ALL_ACTION = "READ-ALL-FOLDER-MASTER-DETAILS";	
	private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-FOLDER-MASTER-DETAILS";
	

	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/template/folder/find/all")
	public ResponseEntity<?> getAllFolder(Authentication auth) {
		
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllFolder(), FolderMasterDTO.class));
	}
	
/*	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ALL_ACTION)	
	@PostMapping("/folder/dropdown")
	public ResponseEntity<?> getAllFolderDD(Authentication auth) {
		@SuppressWarnings("unused")
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllFolderDD(), FolderMasterDDDTO.class));
	}
*/

	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ACTION)	
	@GetMapping("/template/folder/find/{id}")
	public ResponseEntity<?> getFolderbyId(Authentication auth, @NonNull @PathVariable(value = "id") long folderMasterId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getFolderById(folderMasterId), FolderMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = READ_ACTION)	
	@GetMapping("/template/folder/find/ref/{refId}")
	public ResponseEntity<?> getAllFolderByRefId(Authentication auth, @NonNull @PathVariable(value = "refId") String refId) {
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.getAllFolderByRefId(refId), FolderMasterDTO.class));
	}


	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PostMapping("/template/folder/new")
	public ResponseEntity<?> creatFolder(Authentication auth, @NonNull @RequestBody FolderMasterDTO folderMaster) {

		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		String uname = loginUserDetails.getUsername();
		folderMaster.setCreatedBy(uname);		
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.createFolder(folderMaster), FolderMasterDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/folder/modify")	
	public ResponseEntity<?> updateFolder(Authentication auth, @NonNull @RequestBody FolderMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(MapperUtils.mapToTargetClass(orgService.updateFolder(folderMaster), FolderMasterDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/folder/inactive")
	public ResponseEntity<?> inActiveFolder(Authentication auth, @NonNull @RequestBody FolderMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.inActiveFolder(folderMaster));
	}
	
	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/folder/active")
	public ResponseEntity<?> activeFolder(Authentication auth, @NonNull @RequestBody FolderMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.activeFolder(folderMaster));
	}

	@PreAuthorize("isAuthenticated()")
//	@Loggable(action = SAVE_OR_EDIT_ACTION)
	@PutMapping("/template/folder/remove")
	public ResponseEntity<?> deleteFolder(Authentication auth, @NonNull @RequestBody FolderMasterDTO folderMaster) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		folderMaster.setModifiedBy(loginUserDetails.getUsername());
		return GRCResponseEntity
				.success(orgService.deleteFolder(folderMaster));
	}

}
