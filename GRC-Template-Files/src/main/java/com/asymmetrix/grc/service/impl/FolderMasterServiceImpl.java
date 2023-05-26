package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;
import com.asymmetrix.grc.dto.FolderMasterDTO;
//import com.asymmetrix.grc.dto.FolderMasterDDDTO;
import com.asymmetrix.grc.entity.FolderMaster;
import com.asymmetrix.grc.entity.FolderMasterLog;
import com.asymmetrix.grc.repository.FolderMasterLogRepository;
import com.asymmetrix.grc.repository.FolderMasterRepository;
import com.asymmetrix.grc.service.FolderMasterService;


@Service
public class FolderMasterServiceImpl implements FolderMasterService {

	@Autowired
	private FolderMasterRepository folderMasterRepo;
	
	@Autowired
	private FolderMasterLogRepository folderMasterLogRepo;

	@Override
	public List<FolderMaster> getAllFolder() {
		List<FolderMaster> orgs = folderMasterRepo.findAllFolder();
		 if (orgs.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_FOLDER_NOT_FOUND);
		    }
		
		return orgs;
	}
/*	
	@Override
	public List<FolderMasterDDDTO> getAllFolderDD() {
		List<FolderMasterDDDTO> orgs = folderMasterRepo.findAllOrgDD();
		 if (orgs.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_FOLDER_NOT_FOUND);
		    }
		
		return orgs;
	}
	

*/
	@Override
	public FolderMaster getFolderById(long folderMasterId) {
		return folderMasterRepo.findById(folderMasterId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Folder not found with  Id----> " + folderMasterId));
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + folderMasterId));
	}

	@Override
	public List<FolderMaster> getAllFolderByRefId(String refId) {
		List<FolderMaster> folders = folderMasterRepo.getAllFolderByRefId(refId);
		 if (folders.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_FOLDER_NOT_FOUND);
		    }
		
		return folders;	
	
	}

	

	public List<FolderMaster> saveAll(List<FolderMaster> folderMasterList) {
		return this.folderMasterRepo.saveAll(folderMasterList);
	}

	@Override
	public FolderMaster createFolder(FolderMasterDTO folderMasterDto) {		
		FolderMaster folderMaster = MapperUtils.mapToTargetClass(folderMasterDto, FolderMaster.class);
		folderMaster.setActiveFlag("Y");
		folderMaster.setDeleteFlag("N");	
		return this.folderMasterRepo.save(folderMaster);
	
	}
	

	public FolderMasterLog updateFolderLog(long folderMasterId) {	
		
		FolderMaster existingFolder = getFolderById(folderMasterId);		
		FolderMasterLog folderMasterLog = MapperUtils.mapToTargetClass(existingFolder, FolderMasterLog.class);
		return this.folderMasterLogRepo.save(folderMasterLog);
	}

	
	@Override
	@Transactional
	public FolderMaster updateFolder(FolderMasterDTO folderMasterDto) {		
		@SuppressWarnings("unused")
//		FolderMasterLog log = updateFolderLog(folderMasterDto.getFolderId());
		FolderMaster folderMaster = MapperUtils.mapToTargetClass(folderMasterDto, FolderMaster.class);
		folderMaster.setActiveFlag("Y");
		folderMaster.setDeleteFlag("N");
		return this.folderMasterRepo.save(folderMaster);
	}

	

	@Override
	public boolean deleteFolder(FolderMasterDTO folderMasterDto) {
		FolderMaster existingFolder = getFolderById(folderMasterDto.getFolderId());
		existingFolder.setActiveFlag("N");
		existingFolder.setDeleteFlag("D");
		existingFolder.setRemarks(folderMasterDto.getRemarks());
	//	return this.folderMasterRepo.save(existingFolder);
		 return (ObjectUtils.isEmpty(folderMasterRepo.save(existingFolder))) ? Boolean.FALSE : Boolean.TRUE;

	}

	@Override
	public boolean inActiveFolder(FolderMasterDTO folderMasterDto) {
		FolderMaster existingFolder = getFolderById(folderMasterDto.getFolderId());
		existingFolder.setActiveFlag("N");	
		existingFolder.setRemarks(folderMasterDto.getRemarks());
		 return (ObjectUtils.isEmpty(folderMasterRepo.save(existingFolder))) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean activeFolder(FolderMasterDTO folderMasterDto) {
		FolderMaster existingFolder = getFolderById(folderMasterDto.getFolderId());
		existingFolder.setActiveFlag("Y");	
		existingFolder.setRemarks(folderMasterDto.getRemarks());
		 return (ObjectUtils.isEmpty(folderMasterRepo.save(existingFolder))) ? Boolean.FALSE : Boolean.TRUE;
	}

	
}
