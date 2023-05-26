package com.asymmetrix.asset.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.dto.LoginUserDetails;
import com.asymmetrix.asset.common.response.AssetResponseEntity;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.dto.AssetReqResDTO;

import com.asymmetrix.asset.dto.AssetAssessmentCountByPieChartDTO;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.dto.AssetDetailsDTO;
import com.asymmetrix.asset.service.AssetFileUploadService;

import com.asymmetrix.asset.service.AssetLibraryService;

@RestController
public class AssetController {

	@Autowired
	private AssetLibraryService assetLibService;
	@Autowired
	private AssetFileUploadService docService;

	private static final String SAVE_ASSET_ACTION = "SAVE-ASSET-LIBRARY-DETAILS";
	private static final String EDIT_ASSET_ACTION = "EDIT-ASSET-LIBRARY-DETAILS";
	private static final String REMOVE_ASSET_ACTION = "DELETE-ASSET-LIBRARY-DETAILS";
	private static final String REMOVE_ALL_ASSET_ACTION = "DELETE-LIST-ASSET-LIBRARY-DETAILS";
	private static final String SAVE_OR_EDIT_FILE_UPLOAD_ACTION = "SAVE-OR-EDIT-FILE-UPLOAD-ASSET-LIBRARY-DETAILS";
	private static final String READ_ASSET_ACTION = "READ-ASSET-LIBRARY-DETAILS";
	private static final String READ_ALL_ASSET_ACTION = "READ-ALL-ASSET-LIBRARY-DETAILS";
	private static final String READ_ASSET_LIST_ACTION = "READ-ALL-ASSET-LIBRARY-LIST-DETAILS";

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ALL_ASSET_ACTION)
//	@GetMapping("/asset/find/all")
	@PostMapping("/asset/find/all")
	public ResponseEntity<?> getAllAsset() {
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(assetLibService.getAllAssetByActiveflag(), CMAssetDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_ACTION)
	@GetMapping("/asset/find/{id}")
	public AssetReqResDTO getAssetById(@NonNull @PathVariable(value = "id") long assetId) {
		AssetReqResDTO resDto = new AssetReqResDTO();
		AssetDTO assetDTO = MapperUtils.mapToTargetClass(assetLibService.getAssetById(assetId), AssetDTO.class);
		// List<AssetFileUpload> filelist =
		// docService.getAllDocByRefId(String.valueOf(assetDTO.getAssetId()));
		List<AssetAttachmentsDTO> fileList = MapperUtils.mapToTargetClass(
				docService.getAllDocByRefId(String.valueOf(assetDTO.getAssetId())), AssetAttachmentsDTO.class);
		resDto.setAssetdto(assetDTO);
		resDto.setFiles(fileList);
		return resDto;
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_OR_EDIT_FILE_UPLOAD_ACTION)
	@PostMapping("/asset/attachment/new")
	public AssetReqResDTO createAssetAttachment(@NonNull @ModelAttribute AssetAttachmentsDTO assetAttachment) {
		AssetReqResDTO resDTO = new AssetReqResDTO();
		String result = assetLibService.createFiles(assetAttachment);
		System.out.println("file Upload result  => " + result);
		List<AssetAttachmentsDTO> fileList = MapperUtils
				.mapToTargetClass(docService.getAllDocByRefId(assetAttachment.getRefId()), AssetAttachmentsDTO.class);
		resDTO.setFiles(fileList);
		return resDTO;
	}

	@GetMapping("/asset/attachment/download/{refId}")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable String refId) {
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(assetLibService.downloadFile(refId), AssetAttachmentsDTO.class));
	}

	@PutMapping("/asset/attachment/remove/{docId}")
	public ResponseEntity<?> deleteFile(@NonNull @PathVariable String docId) {
		String attachment = null;
		try {
			attachment = assetLibService.fileDeleteByDocId(docId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AssetResponseEntity.success(attachment);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = SAVE_ASSET_ACTION)
//	@PostMapping("/asset/new/create")
	@PostMapping("/asset/new")
	public ResponseEntity<?> createAsset(Authentication auth, @NonNull @RequestBody CMAssetDTO assetDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assetDto.setCreatedBy(loginUserDetails.getUsername());
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(assetLibService.createAsset(assetDto), CMAssetDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = EDIT_ASSET_ACTION)
//	@PutMapping("/asset/modify/update")
	@PutMapping("/asset/modify")
	public ResponseEntity<?> updateAsset(Authentication auth, @NonNull @RequestBody CMAssetDTO assetDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assetDto.setModifiedBy(loginUserDetails.getUsername());
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(assetLibService.updateAsset(assetDto), CMAssetDTO.class));
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_ASSET_ACTION)
//	@PutMapping("/asset/remove/delete")
	@PutMapping("/asset/remove")
	public ResponseEntity<?> deleteAsset(Authentication auth, @NonNull @RequestBody CMAssetDTO assetDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
		assetDto.setModifiedBy(loginUserDetails.getUsername());
		return AssetResponseEntity
				.success(MapperUtils.mapToTargetClass(assetLibService.deleteAsset(assetDto), CMAssetDTO.class));
	}
	
	@PreAuthorize("isAuthenticated()")
	@Loggable(action = REMOVE_ALL_ASSET_ACTION)
	@PutMapping("/asset/remove/list")
	public ResponseEntity<?> deleteAssetList(Authentication auth, @NonNull @RequestBody List<CMAssetDTO> assetListDto) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		LoginUserDetails loginUserDetails = (LoginUserDetails) oAuth2AuthenticationDetails.getDecodedDetails();
	//	assetDto.setModifiedBy(loginUserDetails.getUsername());
		return AssetResponseEntity
				.success(assetLibService.deleteAssetList(assetListDto, loginUserDetails.getUsername()));
	}

	
	

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_LIST_ACTION)
//	@GetMapping("/asset/find/listwithcomplianceclass")
	@PostMapping("/asset/find/listwithcomplianceclass")
	public ResponseEntity<?> getAssetList() {
		AssetDetailsDTO assetDto = new AssetDetailsDTO();
		assetDto.setAssetListWithComplianceClass(assetLibService.getAssetListWithComplianceClass());
		return AssetResponseEntity.success(assetDto);
	}

	@PreAuthorize("isAuthenticated()")
	@Loggable(action = READ_ASSET_LIST_ACTION)
//	@GetMapping("/asset/find/countbycomplianceclass")
	@PostMapping("/asset/find/countbycomplianceclass")
	public ResponseEntity<?> getAssetCountList() {
		List<AssetAssessmentCountByPieChartDTO> scoreCountDto = assetLibService.getAssetCountListByComplianceClass();
		return AssetResponseEntity.success(scoreCountDto);
	}

	/*
	 * 
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @Loggable(action = SAVE_OR_EDIT_ACTION_WITH_DOC)
	 * 
	 * @PostMapping("/asset/new") public AssetReqResDTO createAsset(Authentication
	 * auth, @NonNull @ModelAttribute CMAssetDTO assetdto) { AssetReqResDTO resDTO =
	 * new AssetReqResDTO(); OAuth2AuthenticationDetails oAuth2AuthenticationDetails
	 * = (OAuth2AuthenticationDetails)auth.getDetails(); LoginUserDetails
	 * loginUserDetails =
	 * (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	 * assetdto.setCreatedBy(loginUserDetails.getUsername()); AssetDTO assetDTO =
	 * MapperUtils.mapToTargetClass(assetLibService.createAsset(assetdto),
	 * AssetDTO.class); // List<AssetFileUpload> filelist =
	 * docService.getAllDocByRefId(String.valueOf(assetDTO.getAssetId()));
	 * List<AssetAttachmentsDTO> filelist =
	 * MapperUtils.mapToTargetClass(docService.getAllDocByRefId(String.valueOf(
	 * assetDTO.getAssetId())), AssetAttachmentsDTO.class);
	 * resDTO.setAssetdto(assetDTO); resDTO.setFiles(filelist); return resDTO; }
	 * 
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @Loggable(action = SAVE_OR_EDIT_ACTION_WITH_DOC)
	 * 
	 * @PutMapping("/asset/modify") public AssetReqResDTO updateAsset(Authentication
	 * auth, @NonNull @ModelAttribute CMAssetDTO assetdto) {
	 * 
	 * AssetReqResDTO resDTO = new AssetReqResDTO(); OAuth2AuthenticationDetails
	 * oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	 * LoginUserDetails loginUserDetails =
	 * (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	 * assetdto.setModifiedBy(loginUserDetails.getUsername());
	 * 
	 * AssetDTO assetDTO =
	 * MapperUtils.mapToTargetClass(assetLibService.updateAsset(assetdto),
	 * AssetDTO.class); // List<AssetFileUpload> filelist =
	 * docService.getAllDocByRefId(String.valueOf(assetDTO.getAssetId()));
	 * List<AssetAttachmentsDTO> filelist =
	 * MapperUtils.mapToTargetClass(docService.getAllDocByRefId(String.valueOf(
	 * assetDTO.getAssetId())), AssetAttachmentsDTO.class);
	 * resDTO.setAssetdto(assetDTO); resDTO.setFiles(filelist); return resDTO; }
	 * 
	 * 
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @Loggable(action = SAVE_OR_EDIT_ACTION_WITH_DOC)
	 * 
	 * @PutMapping("/asset/remove") public ResponseEntity<?>
	 * deleteAsset(Authentication auth, @NonNull @ModelAttribute CMAssetDTO
	 * assetdto) { OAuth2AuthenticationDetails oAuth2AuthenticationDetails =
	 * (OAuth2AuthenticationDetails)auth.getDetails(); LoginUserDetails
	 * loginUserDetails =
	 * (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	 * assetdto.setModifiedBy(loginUserDetails.getUsername());
	 * 
	 * return
	 * AssetResponseEntity.success(MapperUtils.mapToTargetClass(assetLibService.
	 * deleteAsset(assetdto), CMAssetDTO.class)); }
	 * 
	 * 
	 */

}
