package com.asymmetrix.asset.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.asset.dao.AssetLogRepository;
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.AssetAssessmentCountByPieChartDTO;
import com.asymmetrix.asset.dto.AssetAttachmentsDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetScoreCountByComplianceClassDTO;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.entity.AssetLog;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.common.constants.AssetConstants;
import com.asymmetrix.asset.common.utils.AssetUtils;
import com.asymmetrix.asset.common.utils.MapperUtils;
import com.asymmetrix.asset.dao.AssetLogRepository;
import com.asymmetrix.asset.dao.AssetRepository;
import com.asymmetrix.asset.dao.AssetScoringRepository;
import com.asymmetrix.asset.dto.CMAssetDTO;
import com.asymmetrix.asset.dto.AssetFileUploadDTO;
import com.asymmetrix.asset.dto.AssetScoreImliedLevelDTO;
import com.asymmetrix.asset.dto.AssetScoringDTO;
import com.asymmetrix.asset.dto.AssetWithComplianceClassDTO;
import com.asymmetrix.asset.dto.AssetDTO;
import com.asymmetrix.asset.entity.CMAsset;
import com.asymmetrix.asset.entity.AssetFileUpload;
import com.asymmetrix.asset.entity.AssetLog;
import com.asymmetrix.asset.entity.AssetScoring;
import com.asymmetrix.asset.exception.ResourceNotFoundException;

import com.asymmetrix.asset.service.AssetLibraryService;


@SuppressWarnings("unused")
@Service
public class AssetLibraryServiceImpl implements AssetLibraryService {

	@Autowired
	private AssetRepository assetRepo;

	@Autowired
	private AssetLogRepository assetLogRepo;

	@Autowired
	private AssetScoringRepository assetScoreRepo;

	@Autowired
	private AssetFileUploadServiceImpl docService;

	AssetFileUploadDTO fileUpload;

	@Override
	public List<CMAsset> getAllAsset() {
		return this.assetRepo.findAllAsset();
	}

	@Override
	public List<CMAsset> getAllAssetByActiveflag() {
		return this.assetRepo.findAllByActiveflag();
	}

	@Override
	public int getAssetCountByActiveflag() {
		return this.assetRepo.findCountByActiveflag();
	}

	@Override
	public AssetScoring getAssetScoreByAssetId(String assetId) {
		return assetScoreRepo.findByAssetId(assetId);
	}

	@Override
	public CMAsset getAssetById(long assetId) {
		return assetRepo.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("CM-Asset not found with  Id----> " + assetId));
	}

	@Override
	public CMAsset createAsset(CMAssetDTO cmAssetDto) {
		AssetDTO assetDTO = new AssetDTO(cmAssetDto.getAssetType(), cmAssetDto.getAssetName(),
				cmAssetDto.getAssetDesc(), cmAssetDto.getAssetCode(), cmAssetDto.getAssetSerialNumber(),
				cmAssetDto.getAssetCategory(), cmAssetDto.getLeasedDate(), cmAssetDto.getLeaseEndingDate(),
				cmAssetDto.getAssetPurchaseDate(), cmAssetDto.getGlCode(), cmAssetDto.getPurchaseOrderNumber(),
				cmAssetDto.getAssetSupplierDetails(), cmAssetDto.getManufacturerDetails(), cmAssetDto.getWarrantyTill(),
				cmAssetDto.getAssetIndustry(), cmAssetDto.getAssetClassification(), cmAssetDto.getUploadImage(),
				cmAssetDto.getAssetPrimaryOwnerId(), cmAssetDto.getAssetSecondaryOwnerId(),
				cmAssetDto.getAssetSecurityOwnerId(), cmAssetDto.getAssetAllocatedToId(),
				cmAssetDto.getAssetPrimaryOwner(), cmAssetDto.getAssetSecurityOwner(),
				cmAssetDto.getAssetSecondaryOwner(), cmAssetDto.getAssetAllocatedTo(), cmAssetDto.getCreatedBy(),
				cmAssetDto.getModifiedBy(), "Y", "N");
		
		
		CMAsset cmasset = assetRepo.save(MapperUtils.mapToTargetClass(assetDTO, CMAsset.class));
		return cmasset;
	}

	@Override
	public List<CMAsset> saveAllAsset(List<CMAsset> assetList) {
		return this.assetRepo.saveAll(assetList);
	}

	public AssetLog updateAssetLog(long assetId) {
		CMAsset cmAsset = getAssetById(assetId);
		cmAsset.setActiveFlag("N");
		cmAsset.setDeleteFlag("D");
		AssetLog assetlog = assetLogRepo.save(MapperUtils.mapToTargetClass(cmAsset, AssetLog.class));
		return assetlog;
	}


	@Override
	public CMAsset updateAsset(CMAssetDTO cmaAssetDto) {
		AssetLog assetlog = updateAssetLog(cmaAssetDto.getAssetId());
//		AssetDTO assetDto = MapperUtils.mapToTargetClass(cmaAssetDto, AssetDTO.class);
//		assetDto.setActiveFlag("Y");
//		assetDto.setDeleteFlag("N");
		
		AssetDTO assetDto = new AssetDTO(cmaAssetDto.getAssetId(),
				  cmaAssetDto.getAssetType(), cmaAssetDto.getAssetName(), cmaAssetDto.getAssetDesc(),
				  cmaAssetDto.getAssetCode(), cmaAssetDto.getAssetSerialNumber(),
				  cmaAssetDto.getAssetCategory(), cmaAssetDto.getLeasedDate(),
				  cmaAssetDto.getLeaseEndingDate(), cmaAssetDto.getAssetPurchaseDate(),
				  cmaAssetDto.getGlCode(), cmaAssetDto.getPurchaseOrderNumber(),
				  cmaAssetDto.getAssetSupplierDetails(), cmaAssetDto.getManufacturerDetails(),
				  cmaAssetDto.getWarrantyTill(), cmaAssetDto.getAssetIndustry(),
				  cmaAssetDto.getAssetClassification(), cmaAssetDto.getUploadImage(),
				  cmaAssetDto.getAssetPrimaryOwnerId(), cmaAssetDto.getAssetSecondaryOwnerId(),
				  cmaAssetDto.getAssetSecurityOwnerId(), cmaAssetDto.getAssetAllocatedToId(),
				  cmaAssetDto.getAssetPrimaryOwner(), cmaAssetDto.getAssetSecurityOwner(),
				  cmaAssetDto.getAssetSecondaryOwner(), cmaAssetDto.getAssetAllocatedTo(),
				  cmaAssetDto.getCreatedBy(), cmaAssetDto.getModifiedBy(), "Y", "N"); 
	
	
		CMAsset cmasset = assetRepo.save(MapperUtils.mapToTargetClass(assetDto, CMAsset.class));
		return cmasset;
	}

	@Override
	public CMAsset deleteAsset(CMAssetDTO cmAssetDto) {	
		AssetLog assetlog = updateAssetLog(cmAssetDto.getAssetId());
		CMAsset cmasset = getAssetById(cmAssetDto.getAssetId());
		cmasset.setDeleteFlag("D");
		cmasset.setActiveFlag("N");
		cmasset.setModifiedBy(cmAssetDto.getModifiedBy());
		return assetRepo.save(cmasset);
	}
	
	@Override
	public String deleteAssetList(List<CMAssetDTO> assetListDto, String userName) {
		List<CMAsset> assetList = null;
		assetList = new ArrayList<>();
		for(CMAssetDTO assetInfo: assetListDto) {	
			AssetLog assetlog = updateAssetLog(assetInfo.getAssetId());
			CMAsset cmasset = getAssetById(assetInfo.getAssetId());
			cmasset.setDeleteFlag("D");
			cmasset.setActiveFlag("N");
			cmasset.setModifiedBy(userName);
			assetList.add(assetRepo.save(cmasset));
		}		
		return StringUtils.replace(AssetConstants.ASSET_LIST_DELETE_SUCCESS, AssetConstants.CURLY_BRACKETS_SYMBOL,
				Integer.toString(assetList.size()));
	}



	@Override
	public List<CMAssetDTO> getAssetByList(List<Long> biaIdList) {
		List<CMAssetDTO> assetList = new ArrayList<>();
		for (long mapId : biaIdList) {
			CMAssetDTO detailAsset = MapperUtils.mapToTargetClass(getAssetById(mapId), CMAssetDTO.class);
			assetList.add(detailAsset);
		}
		return assetList;
	}

	@Override
	public List<AssetWithComplianceClassDTO> getAssetListWithComplianceClass() {
		List<AssetWithComplianceClassDTO> assetScoreDto = new ArrayList<AssetWithComplianceClassDTO>();
		List<AssetWithComplianceClassDTO> assetDto = MapperUtils.mapToTargetClass(getAllAssetByActiveflag(),
				AssetWithComplianceClassDTO.class);
		for (AssetWithComplianceClassDTO asset : assetDto) {
			int count = assetScoreRepo.getAssetScoreCount(String.valueOf(asset.getAssetId()));
		//	 System.out.println("Value-AssetID+++++++++++"+asset.getAssetId());
		//	System.out.println("Value-count+++++++++++" + count);
			if (count > 0) {
		//		System.out.println("Value-AssetID+++++++++++" + asset.getAssetId());
				 String complianceclass =
				 assetScoreRepo.getAssetComplianceClass(String.valueOf(asset.getAssetId()));
		//		 System.out.println("Value-complianceclass+++++++++++"+complianceclass);
				AssetScoring assetscore = assetScoreRepo.findByAssetId(String.valueOf(asset.getAssetId()));
				asset.setMinimumComplianceClass(assetscore.getChoosenMinimumComplianceClass());
				asset.setLastUpdatedMinimumComplianceClassDate(assetscore.getModifiedDate());
			}
			assetScoreDto.add(asset);
		}
		return assetScoreDto;
	}

	@Override
	public List<AssetAssessmentCountByPieChartDTO> getAssetCountListByComplianceClass() {
		// AssetScoreCountByComplianceClassDTO scoreCount = new
		// AssetScoreCountByComplianceClassDTO();
		List<AssetWithComplianceClassDTO> assetScoreDto = getAssetListWithComplianceClass();
		AssetAssessmentCountByPieChartDTO ciaCountDto;
		List<AssetAssessmentCountByPieChartDTO> ciaChartData = new ArrayList<>();

		// int totalCount = 0;
		int greenCount = 0;
		int lightGreenCount = 0;
		int amberCount = 0;
		int redCount = 0;
		int darkRed = 0;
		for (AssetWithComplianceClassDTO asset : assetScoreDto) {
			if (asset.getMinimumComplianceClass() != null) {
				// totalCount = totalCount + 1;
				int number = Integer.parseInt(asset.getMinimumComplianceClass());
				switch (number) {
				case 0:
					greenCount = greenCount + 1;
					break;
				case 1:
					lightGreenCount = lightGreenCount + 1;
					break;
				case 2:
					amberCount = amberCount + 1;
					break;
				case 3:
					redCount = redCount + 1;
					break;
				case 4:
					darkRed = darkRed + 1;
					break;
				}
			}
		}
		// scoreCount.setTotalCount(String.valueOf(totalCount));
		/*
		 * ciacountdto = new AssetAssessmentCountByPieChartDTO();
		 * ciacountdto.setName("totalCount");
		 * ciacountdto.setValue(String.valueOf(totalCount));
		 * ciachartdata.add(ciacountdto);
		 */
		// scoreCount.setGreenCount(String.valueOf(greenCount));
		ciaCountDto = new AssetAssessmentCountByPieChartDTO();
		ciaCountDto.setName("green");
		ciaCountDto.setValue(String.valueOf(greenCount));
		ciaChartData.add(ciaCountDto);

		// scoreCount.setLightGreenCount(String.valueOf(lightGreenCount));
		ciaCountDto = new AssetAssessmentCountByPieChartDTO();
		ciaCountDto.setName("lightGreen");
		ciaCountDto.setValue(String.valueOf(lightGreenCount));
		ciaChartData.add(ciaCountDto);

		// scoreCount.setAmberCount(String.valueOf(amberCount));
		ciaCountDto = new AssetAssessmentCountByPieChartDTO();
		ciaCountDto.setName("amber");
		ciaCountDto.setValue(String.valueOf(amberCount));
		ciaChartData.add(ciaCountDto);

		// scoreCount.setRedCount(String.valueOf(redCount));
		ciaCountDto = new AssetAssessmentCountByPieChartDTO();
		ciaCountDto.setName("red");
		ciaCountDto.setValue(String.valueOf(redCount));
		ciaChartData.add(ciaCountDto);

		// scoreCount.setDarkRed(String.valueOf(darkRed));
		ciaCountDto = new AssetAssessmentCountByPieChartDTO();
		ciaCountDto.setName("darkRed");
		ciaCountDto.setValue(String.valueOf(darkRed));
		ciaChartData.add(ciaCountDto);

		return ciaChartData;
	}

	// Asset - Soft Delete
	@Override
	@Transactional
	public CMAsset deleteUpdate(CMAsset cmasset) {

		// System.out.println("DeleteUpdate Asset Id => "+ cmasset.getAssetId());
		cmasset.setDeleteFlag("D");
		cmasset.setActiveFlag("N");
		CMAsset tempAsset = assetRepo.save(cmasset);

		try {
			String refId = String.valueOf(tempAsset.getAssetId());
			String filedelete = fileDelete(refId);
			refId = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempAsset;
	}
	
	
	// file upload
	private String fileUpload(AssetAttachmentsDTO assetdto) {
		if (!assetdto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : assetdto.getFiles()) {
				// System.out.println(assetdto.getFiles().getContentType() + "-=--=> "+
				// assetdto.getFile().getOriginalFilename());
				try {
					fileUpload = new AssetFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), assetdto.getRefId());
					AssetFileUpload upload = docService.createDoc(fileUpload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}

	// file upload
	private String fileUpload(CMAssetDTO cmAssetDto) {
		if (!cmAssetDto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : cmAssetDto.getFiles()) {
				System.out.println(file.getContentType() + "-=--=> " + file.getOriginalFilename());
				try {
					fileUpload = new AssetFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), String.valueOf(cmAssetDto.getAssetId()));
					AssetFileUpload upload = docService.createDoc(fileUpload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}

	// file delete
	@Override
	public String fileDelete(String refId) {
		List<AssetFileUpload> existfilelist = docService.getAllDocByRefId(refId);
		for (AssetFileUpload file : existfilelist) {
			docService.deleteUpdate(file);
		}
		return "success";
	}

	// file delete
	@Override
	public String fileDeleteByDocId(String docId) {
		AssetFileUpload existFile = docService.deleteUpdate(docId);
		return "success";
	}

	@Override
	@Transactional
	public String createFiles(AssetAttachmentsDTO assetDto) {
		// int testcount = assetdto.getFile().length;
		// System.out.println("file count => "+ testcount);
		if (!assetDto.getFiles()[0].isEmpty()) {
			String fileUpload = fileUpload(assetDto);
		}
		return "succuess";
	}

	@Override
	public List<AssetFileUploadDTO> downloadFile(String docId) {
		List<AssetFileUploadDTO> attachments = docService.downloadFile(docId);
		AssetUtils.isValid(attachments, "No Attachment found !");
		// return MapperUtils.mapToTargetClass(attachments, AssetAttachmentsDTO.class);
		return attachments;
	}

	

	/*
	 * @Transactional public CMAsset createAsset(CMAssetDTO assetdto) { AssetDTO
	 * assetDTO=new AssetDTO(assetdto.getAssetType(), assetdto.getAssetName(),
	 * assetdto.getAssetDesc(), assetdto.getAssetCode(),
	 * assetdto.getAssetSerialNumber(), assetdto.getAssetCategory(),
	 * assetdto.getLeasedDate(),
	 * assetdto.getLeaseEndingDate(),assetdto.getAssetPurchaseDate(),
	 * assetdto.getGlCode(), assetdto.getPurchaseOrderNumber(),
	 * assetdto.getAssetSupplierDetails(), assetdto.getManufacturerDetails(),
	 * assetdto.getWarrantyTill(), assetdto.getAssetIndustry(),
	 * assetdto.getAssetClassification(),
	 * assetdto.getUploadImage(),assetdto.getAssetPrimaryOwnerId(),assetdto.
	 * getAssetSecondaryOwnerId(), assetdto.getAssetSecurityOwnerId(),
	 * assetdto.getAssetAllocatedToId(), assetdto.getAssetPrimaryOwner(),
	 * assetdto.getAssetSecurityOwner(), assetdto.getAssetSecondaryOwner(),
	 * assetdto.getAssetAllocatedTo(), assetdto.getCreatedBy(),
	 * assetdto.getModifiedBy(), "Y", "N");
	 * 
	 * CMAsset cmasset = assetRepo.save(MapperUtils.mapToTargetClass(assetDTO,
	 * CMAsset.class));
	 * 
	 * int testcount = assetdto.getFiles().length;
	 * System.out.println("file count  => "+ testcount); if(!
	 * assetdto.getFiles()[0].isEmpty()) { // String refId =
	 * String.valueOf(cmasset.getAssetId());
	 * assetdto.setAssetId(cmasset.getAssetId()); String fileupload =
	 * fileUpload(assetdto); // refId = null;
	 * 
	 * }
	 * 
	 * return cmasset; }
	 * 
	 */

	/*
	 * 
	 * @Transactional public CMAsset updateAsset(CMAssetDTO assetdto) { AssetLog
	 * assetlog = updateLog(assetdto); AssetDTO assetDTO=new
	 * AssetDTO(assetdto.getAssetId(), assetdto.getAssetType(),
	 * assetdto.getAssetName(), assetdto.getAssetDesc(), assetdto.getAssetCode(),
	 * assetdto.getAssetSerialNumber(), assetdto.getAssetCategory(),
	 * assetdto.getLeasedDate(),
	 * assetdto.getLeaseEndingDate(),assetdto.getAssetPurchaseDate(),
	 * assetdto.getGlCode(), assetdto.getPurchaseOrderNumber(),
	 * assetdto.getAssetSupplierDetails(), assetdto.getManufacturerDetails(),
	 * assetdto.getWarrantyTill(), assetdto.getAssetIndustry(),
	 * assetdto.getAssetClassification(), assetdto.getUploadImage(),
	 * assetdto.getAssetPrimaryOwnerId(),assetdto.getAssetSecondaryOwnerId(),
	 * assetdto.getAssetSecurityOwnerId(), assetdto.getAssetAllocatedToId(),
	 * assetdto.getAssetPrimaryOwner(), assetdto.getAssetSecurityOwner(),
	 * assetdto.getAssetSecondaryOwner(), assetdto.getAssetAllocatedTo(),
	 * assetdto.getCreatedBy(), assetdto.getModifiedBy(), "Y", "N"); CMAsset cmasset
	 * = assetRepo.save(MapperUtils.mapToTargetClass(assetDTO, CMAsset.class));
	 * 
	 * try { String filedelete = fileDelete(String.valueOf(cmasset.getAssetId())); }
	 * catch (IOException e) { e.printStackTrace(); }
	 * 
	 * if(! assetdto.getFiles()[0].isEmpty()) {
	 * assetdto.setAssetId(cmasset.getAssetId()); // String refId =
	 * String.valueOf(cmasset.getAssetId()); String fileupload =
	 * fileUpload(assetdto); // refId = null;
	 * 
	 * }
	 * 
	 * return cmasset; }
	 * 
	 */

	/*
	 * 
	 * public CMAsset deleteAsset(CMAssetDTO bia) {
	 * System.out.println("Delete  Asset Id  => "+ bia.getAssetId()); CMAsset
	 * cmasset = getAssetById(bia.getAssetId()); CMAsset deleteAsset =
	 * this.deleteUpdate(cmasset); return deleteAsset; }
	 * 
	 */

}
