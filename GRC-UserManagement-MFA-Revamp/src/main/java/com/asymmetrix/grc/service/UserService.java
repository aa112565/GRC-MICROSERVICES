package com.asymmetrix.grc.service;

import java.util.List;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.CnfgUserWithManagerDTO;
import com.asymmetrix.grc.dto.UserPreferencesDTO;

public interface UserService {

  public void saveOrUpdateUser(CnfgUserDTO cnfgUserModel, String action);

  public List<CnfgUserDTO> getAllUser();
  
  

  public CnfgUserDTO getUserById(String userId);

  public String bulkUserCreation(MultipartFile file, String defaultPassword);

  public void updatePassword(String encryptPassword, String userId);

  public void updatePasswordByUserIdAndOldPassword(String newEncryptPassword, String userId,
      String oldEncryptPassword);

  public Set<String> getAllRptL1UsrBranchCodes(String userId);

  public List<CnfgUserWithManagerDTO> getLvl1UsersWithManagersUptoUsrLvl(String userLevel,
      Set<String> branchCodes);

  public void saveUserPreferences(UserPreferencesDTO userPreference);

  public UserPreferencesDTO getUserPreferencesByPage(String userId, String page);
  
  public List<CnfgUserDTO> getAllUserDetails();
  
  public CnfgUserDTO getUserByIdWithOutException(String userId);

}
