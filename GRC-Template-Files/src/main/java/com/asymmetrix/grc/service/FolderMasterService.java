package com.asymmetrix.grc.service;

import java.util.List;

//import com.asymmetrix.grc.dto.FolderMasterDDDTO;
import com.asymmetrix.grc.dto.FolderMasterDTO;

import com.asymmetrix.grc.entity.FolderMaster;

public interface FolderMasterService {

	List<FolderMaster> getAllFolder(); 

	FolderMaster getFolderById(long folderMasterId);	

	FolderMaster createFolder(FolderMasterDTO folderMasterDto);

	FolderMaster updateFolder(FolderMasterDTO folderMasterDto);

	boolean deleteFolder(FolderMasterDTO folderMasterDto);

	boolean inActiveFolder(FolderMasterDTO folderMaster);

	boolean activeFolder(FolderMasterDTO folderMaster);

	List<FolderMaster> getAllFolderByRefId(String refId);

//	List<FolderMasterDDDTO> getAllFolderDD();

	
}
