package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.asymmetrix.grc.service.CnfgPropertyDetailsService;
import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.CnfgMenuDTO;
import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.CnfgUserWithManagerDTO;
import com.asymmetrix.grc.dto.UserPreferencesDTO;
import com.asymmetrix.grc.entity.CnfgPropertyDetails;
import com.asymmetrix.grc.entity.CnfgUser;
import com.asymmetrix.grc.entity.CnfgUserGroup;
import com.asymmetrix.grc.entity.UserPreferences;
import com.asymmetrix.grc.repository.CnfgPropertyDetailsRepository;
import com.asymmetrix.grc.repository.GroupRepository;
import com.asymmetrix.grc.repository.UserPrefernecesRepository;
import com.asymmetrix.grc.repository.UserRepository;
import com.asymmetrix.grc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Resource
  UserRepository userRepo;

  @Resource
  GroupRepository groupRepo;

  @Resource
  CnfgPropertyDetailsRepository cnfgExternalAuthRepo;

  @Resource
  UserPrefernecesRepository userPrefRepo;
  
  @Resource
  CnfgPropertyDetailsService CnfgPrptDtlServiceImpl;

  private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public void saveOrUpdateUser(CnfgUserDTO cnfgUserModel, String action) {
    if (GRCConstants.ACTION_SAVE.equals(action)) {
      vaildateUser(cnfgUserModel.getUserId());
    }
    CnfgUser userEntity = MapperUtils.mapToTargetClass(cnfgUserModel, CnfgUser.class);
    Optional<CnfgUserGroup> groupEntity =
        groupRepo.findById(cnfgUserModel.getCnfgUserGroup().getGroupId());
    if (groupEntity.isPresent()) {
      userEntity.setCnfgUserGroup(groupEntity.get());
      userRepo.save(userEntity);
    }
  }

  private void vaildateUser(String userId) {
    if (isMaxLicensedUserLimitReached(1))
      throw new GRCException(GRCErrorConstants.MAXIMUM_LICENSE_USER_LIMIT_EXCEEDED);
    if (isUserIdAlreadyExisits(userId)) {
      throw new GRCException(GRCErrorConstants.ERROR_USER_ALREAD_EXISITS);
    }
  }

  private boolean isUserIdAlreadyExisits(String userId) {
    Optional<CnfgUser> user = userRepo.findById(userId);
    return user.isPresent();
  }

  @Override
  public List<CnfgUserDTO> getAllUser() {
    String[] ignoreFields = {GRCConstants.PASSWORD};
    List<CnfgUserDTO> cnfgUserModelList =
        MapperUtils.mapToTargetClass(userRepo.findAll(), CnfgUserDTO.class, ignoreFields);
    for (CnfgUserDTO cnfgUserModel : cnfgUserModelList) {
      if (null == cnfgUserModel.getCnfgUserGroup())
        continue;
      cnfgUserModel.getCnfgUserGroup()
          .setCnfgMenu(CnfgMenuDTO.groupByMenuName(cnfgUserModel.getCnfgUserGroup().getCnfgMenu()));
    }
    return cnfgUserModelList;
  }

  @Override
  public CnfgUserDTO getUserById(String userId) {
    String[] ignoreFields = {GRCConstants.PASSWORD};
    Optional<CnfgUser> cnfgUser = userRepo.findById(userId);
    if (!cnfgUser.isPresent()) {
      throw new GRCException(GRCErrorConstants.USER_NOT_FOUND);
    }
    CnfgUserDTO userModel =
        MapperUtils.mapToTargetClass(cnfgUser.get(), CnfgUserDTO.class, ignoreFields);
    userModel.getCnfgUserGroup()
        .setCnfgMenu(CnfgMenuDTO.groupByMenuName(userModel.getCnfgUserGroup().getCnfgMenu()));
    return userModel;
  }
  
  @Override
  public CnfgUserDTO getUserByIdWithOutException(String userId) {
    Optional<CnfgUser> cnfgUser = userRepo.findById(userId);
    if (!cnfgUser.isPresent()) {
      /* Jira-PEA-62-User Enumeration error */
      LOG.error("UserId -{}  not found ", userId);	
      return new CnfgUserDTO();
    }
    CnfgUserDTO userModel =
        MapperUtils.mapToTargetClass(cnfgUser.get(), CnfgUserDTO.class);
    userModel.getCnfgUserGroup()
        .setCnfgMenu(CnfgMenuDTO.groupByMenuName(userModel.getCnfgUserGroup().getCnfgMenu()));
    return userModel;
  }
  

  @Override
  public String bulkUserCreation(MultipartFile file, String defaultPassword) {
    List<Map<String, Object>> userDetails =
        ExcelHelper.getDetailsFromExcel(file, GRCConstants.BULK_UPLOAD_EXCEL_SHEET_NAME);
    List<CnfgUser> userDetailsList = MapperUtils.mapToTargetClass(
        MapperUtils.mapToTargetClass(userDetails, CnfgUserDTO.class), CnfgUser.class);
    validateBulkUserAndSetDefaultValues(defaultPassword, userDetails, userDetailsList);
    userRepo.saveAll(userDetailsList);
    return StringUtils.replace(GRCConstants.BULK_USERS_UPLOAD_SUCCESS,
        GRCConstants.CURLY_BRACKETS_SYMBOL, Integer.toString(userDetailsList.size()));
  }

  private void validateBulkUserAndSetDefaultValues(String defaultPassword,
      List<Map<String, Object>> userDetails, List<CnfgUser> userDetailsList) {
    validateUserLicense(userDetailsList.size());
    Map<String, String> excelUserGroupMap =
        mapByUserIdAndSearchStr(userDetails, ExcelHelper.GROUP_HEADER_NAME);
    Map<String, CnfgUserGroup> userGrpList =
        validateAndGetUserGroupList(new HashSet<>(excelUserGroupMap.values()));
    validateGrade(userDetails);
    setUserGrpAndPassword(userDetailsList, defaultPassword, userGrpList, excelUserGroupMap);
  }
/*
  private void validateGrade(List<Map<String, Object>> userDetails) {
    Map<String, String> excelUserGradeMap =
        mapByUserIdAndSearchStr(userDetails, ExcelHelper.USER_GRADE_HEADER_NAME);
    Set<String> grades = userRepo.findByGradeIn(new HashSet<>(excelUserGradeMap.values()));
    GRCUtils.isValid(grades, GRCErrorConstants.ERROR_GRADE_IS_INVALID + excelUserGradeMap.values());
    validateGivenData(new HashSet<>(excelUserGradeMap.values()), grades,
        GRCErrorConstants.ERROR_GRADE_IN_EXCEL_IS_EMPTY,
        GRCErrorConstants.ERROR_GRADE_IN_EXCEL_IS_INVALID,
        GRCErrorConstants.ERROR_GRADE_IS_INVALID);
  }

  private Map<String, CnfgUserGroup> validateAndGetUserGroupList(Set<String> groupNamesFromExcel) {
    Map<String, CnfgUserGroup> userGrpList = getUserGroupsByGrpNames(groupNamesFromExcel);
    validateGivenData(groupNamesFromExcel, userGrpList.keySet(),
        GRCErrorConstants.ERROR_GROUP_NAME_IN_EXCEL_IS_EMPTY,
        GRCErrorConstants.ERROR_GROUP_NAME_IN_EXCEL_IS_INVALID,
        GRCErrorConstants.ERROR_GROUP_NAME_IS_INVALID);
    return userGrpList;
  }
*/
  
  
  private void validateGrade(List<Map<String, Object>> userDetails) {
	    List<String> gradesFromExcel = validateAndGetDistinctValue(
	        mapByUserIdAndSearchStr(userDetails, ExcelHelper.USER_GRADE_HEADER_NAME).values(),
	       GRCErrorConstants.ERROR_GRADE_IN_EXCEL_IS_EMPTY);
	    List<String> gradesFromDB = validateAndGetDistinctValue(
	        CnfgPrptDtlServiceImpl.getAllGradeAsList(), GRCErrorConstants.NOT_VALID);
	    gradesFromExcel.removeAll(gradesFromDB);
	    if (!ObjectUtils.isEmpty(gradesFromExcel)) {
	      throw new GRCException(GRCErrorConstants.ERROR_GRADE_IS_INVALID
	          .concat(String.join(GRCConstants.COMMA, gradesFromExcel)));
	    }
	  }

	  private Map<String, CnfgUserGroup> validateAndGetUserGroupList(Set<String> groupNamesFromExcel) {
	    List<String> groupFromExcel = validateAndGetDistinctValue(groupNamesFromExcel,
	        GRCErrorConstants.ERROR_GROUP_NAME_IN_EXCEL_IS_EMPTY);
	    Map<String, CnfgUserGroup> userGrpList = getUserGroupsByGrpNames(groupNamesFromExcel);
	    List<String> groupFromDB =
	        validateAndGetDistinctValue(userGrpList.keySet(), GRCErrorConstants.NOT_VALID);
	    groupFromExcel.removeAll(groupFromDB);
	    if (!ObjectUtils.isEmpty(groupFromExcel)) {
	      throw new GRCException(GRCErrorConstants.ERROR_GROUP_NAME_IS_INVALID
	          .concat(String.join(GRCConstants.COMMA, groupFromExcel)));
	    }
	    return userGrpList;
	  }

	@SuppressWarnings("unused")
	private List<String> validateAndGetDistinctValue(Collection<String> values, String errorMsg) {
		GRCUtils.isValid(values, errorMsg);
	 return values.stream().distinct().collect(Collectors.toList());
	 }
	  
  private void validateUserLicense(int licensedcount) {
    if (isMaxLicensedUserLimitReached(licensedcount)) {
      throw new GRCException(GRCErrorConstants.MAXIMUM_LICENSE_USER_LIMIT_EXCEEDED);
    }
  }
  



  private Map<String, String> mapByUserIdAndSearchStr(List<Map<String, Object>> bulkUsrDtl,
      String searchColumnStr) {
    Map<String, String> userMap = new HashMap<>();
    for (Map<String, Object> map : bulkUsrDtl) {
      if (map.containsKey(searchColumnStr)) {
        userMap.put(map.get(ExcelHelper.USER_ID_HEADER_NAME).toString(),
            map.get(searchColumnStr).toString());
      }
    }
    return userMap;
  }

  private Map<String, CnfgUserGroup> getUserGroupsByGrpNames(Set<String> groupNames) {
    GRCUtils.isValid(groupNames, GRCErrorConstants.ERROR_GROUP_NAME_IN_EXCEL_IS_EMPTY);
    List<CnfgUserGroup> cnfgUserGroups = groupRepo.findByGroupNameIn(groupNames);
    GRCUtils.isValid(cnfgUserGroups,
        GRCErrorConstants.ERROR_GROUP_NAME_IS_INVALID + groupNames.toString());
    return cnfgUserGroups.stream()
        .collect(Collectors.toMap(CnfgUserGroup::getGroupName, cnfgUserGroup -> cnfgUserGroup));
  }
/*
  private void validateGivenData(Set<String> nameInExcel, Set<String> validNamesFromDB,
      String errMsgOnEmpty, String errMsgOnInvalid, String errorMsg) {
    GRCUtils.isValid(nameInExcel, errMsgOnEmpty + nameInExcel);
    GRCUtils.isValid(validNamesFromDB, errMsgOnInvalid);
    String invalidNames = nameInExcel.stream().filter(e -> !validNamesFromDB.contains(e))
        .collect(Collectors.joining(","));
    if (!ObjectUtils.isEmpty(invalidNames)) {
      throw new GRCException(errorMsg + invalidNames);
    }
  }
*/
  private void setUserGrpAndPassword(List<CnfgUser> userDetailsList, String defaultPassword,
      Map<String, CnfgUserGroup> userGrpList, Map<String, String> usergroupMapFromExcel) {
    userDetailsList.stream().forEach(l -> {
      l.setPassword(defaultPassword);
      l.setCnfgUserGroup(userGrpList.get(usergroupMapFromExcel.get(l.getUserId())));
    });
  }


  @Override
  public void updatePassword(String encyptPassword, String userId) {
    userRepo.updatePasswordById(encyptPassword, userId);
  }

  @Override
  public void updatePasswordByUserIdAndOldPassword(String newEncryptPassword, String userId,
      String oldEncryptPassword) {
    int updatedRecCount = userRepo.updatePasswordByUserIdAndOldPassword(newEncryptPassword, userId,
        oldEncryptPassword);
    if (updatedRecCount == 0) {
      throw new GRCException(GRCErrorConstants.ERROR_USER_ID_OR_PASSWORD_NOT_MATCHED);
    }
  }

  private boolean isMaxLicensedUserLimitReached(long noOfUserNeedToBeCreated) {
    CnfgPropertyDetails bankUserLicenceCount =
        cnfgExternalAuthRepo.findByCnfgNameIgnoreCaseAndCnfgKeyIgnoreCase(
            GRCConstants.PROP_CNFG_NAME_LICENSE, GRCConstants.PROP_CNFG_KEY_LICENSE_USER_COUNT);
    long licenseCount = Long.parseLong(bankUserLicenceCount.getCnfgValue());
    return (licenseCount <= userRepo.count() + noOfUserNeedToBeCreated) ? Boolean.TRUE
        : Boolean.FALSE;
  }

  @Override
  public Set<String> getAllRptL1UsrBranchCodes(String userId) {
    Optional<CnfgUser> cnfgUser = userRepo.findById(userId);
    if (!cnfgUser.isPresent()) {
      throw new GRCException(GRCErrorConstants.USER_NOT_FOUND);
    }
    List<CnfgUser> userList = new ArrayList<>();
    userList.add(cnfgUser.get());
    return getAllLevel1ReporteesBranchCode(userList, new HashSet<String>());
  }

  private Set<String> getAllLevel1ReporteesBranchCode(List<CnfgUser> reportingUsers,
      Set<String> branchCodes) {
    Set<String> managerIds = new HashSet<>();
    if (ObjectUtils.isEmpty(reportingUsers)) {
      return branchCodes;
    }
    for (CnfgUser cnfgUser : reportingUsers) {
      if (GRCUtils.isLevel1User(cnfgUser.getUserLevel())) {
        branchCodes.add(cnfgUser.getBranchCode());
      } else {
        managerIds.add(cnfgUser.getUserId());
      }
    }
    if (!ObjectUtils.isEmpty(managerIds)) {
      getAllLevel1ReporteesBranchCode(userRepo.findByManagerIdIn(managerIds), branchCodes);
    }
    return branchCodes;
  }

  @Override
  public List<CnfgUserWithManagerDTO> getLvl1UsersWithManagersUptoUsrLvl(String uptoUserLevel,
      Set<String> branchCodes) {
    LOG.info("getLvl1UsersWithManagersUptoUsrLvl for {} and userlevel {} ", branchCodes,
        uptoUserLevel);
    List<CnfgUserWithManagerDTO> level1UesrDTO = MapperUtils.mapToTargetClass(
        userRepo.findByUserLevelAndBranchCodeIn(GRCConstants.LEVEL_1, branchCodes),
        CnfgUserWithManagerDTO.class);
    if (GRCUtils.isLevel1User(uptoUserLevel)) {
      return level1UesrDTO;
    }
    return getLvl1UsersWithManagers(level1UesrDTO, uptoUserLevel, new ArrayList<>(level1UesrDTO));
  }

  private List<CnfgUserWithManagerDTO> getLvl1UsersWithManagers(
      List<CnfgUserWithManagerDTO> reportingUsers, String userLevel,
      List<CnfgUserWithManagerDTO> level1UesrDTO) {
    Set<String> mgrIds = getMgrIds(reportingUsers, userLevel);
    if (!ObjectUtils.isEmpty(mgrIds)) {
      List<CnfgUserWithManagerDTO> nextLvlUsers = MapperUtils
          .mapToTargetClass(userRepo.findByUserIdIn(mgrIds), CnfgUserWithManagerDTO.class);
      Map<String, CnfgUserWithManagerDTO> nextLvlUsersMapById = mapUserById(nextLvlUsers);
      setManager(nextLvlUsersMapById, level1UesrDTO);
      getLvl1UsersWithManagers(nextLvlUsers, userLevel, level1UesrDTO);
    }
    LOG.info("getLvl1UsersWithManagers - size {} ", level1UesrDTO.size());
    return level1UesrDTO;
  }

  private void setManager(Map<String, CnfgUserWithManagerDTO> nextLvlUsers,
      List<CnfgUserWithManagerDTO> level1UesrDTO) {
    for (CnfgUserWithManagerDTO lvlUser : level1UesrDTO) {
      setMgrToLvl1User(lvlUser, nextLvlUsers);
    }
  }

  private void setMgrToLvl1User(CnfgUserWithManagerDTO lvlUser,
      Map<String, CnfgUserWithManagerDTO> nextLvlUsers) {
    CnfgUserWithManagerDTO tempUser = lvlUser;
    while (true) {
      if (nextLvlUsers.containsKey(tempUser.getManagerId())) {
        CnfgUserWithManagerDTO mgrUser = MapperUtils.mapToTargetClass(
            nextLvlUsers.get(tempUser.getManagerId()), CnfgUserWithManagerDTO.class);
        tempUser.setManager(mgrUser);
        break;
      } else if (!ObjectUtils.isEmpty(tempUser.getManager())) {
        tempUser = tempUser.getManager();
      } else {
        break;
      }
    }
  }

  private Set<String> getMgrIds(List<CnfgUserWithManagerDTO> reportingUsers, String uptoUserLevel) {
    return reportingUsers.stream().filter(e -> !uptoUserLevel.equalsIgnoreCase(e.getUserLevel()))
        .map(CnfgUserWithManagerDTO::getManagerId).collect(Collectors.toSet());
  }

  private Map<String, CnfgUserWithManagerDTO> mapUserById(
      List<CnfgUserWithManagerDTO> nextLvlUsers) {
    return nextLvlUsers.stream()
        .collect(Collectors.toMap(CnfgUserWithManagerDTO::getUserId, Function.identity()));
  }

  @Override
  public void saveUserPreferences(UserPreferencesDTO userPreference) {
    userPrefRepo.save(MapperUtils.mapToTargetClass(userPreference, UserPreferences.class));
  }

  @Override
  public UserPreferencesDTO getUserPreferencesByPage(String userId, String page) {
    UserPreferences entity = userPrefRepo.findByUserIdAndPage(userId, page);
    entity = ObjectUtils.isEmpty(entity) ? new UserPreferences() : entity;
    return MapperUtils.mapToTargetClass(entity, UserPreferencesDTO.class);
  }
  
  @Override
  public List<CnfgUserDTO> getAllUserDetails() {
    return userRepo.getAllUserDetails();
  }

}
