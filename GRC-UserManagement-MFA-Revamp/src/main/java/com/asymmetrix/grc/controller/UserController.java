package com.asymmetrix.grc.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.aspect.MaskUserField;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.ExcelHelper;
import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.CnfgUserWithManagerDTO;
import com.asymmetrix.grc.dto.PasswordDTO;
import com.asymmetrix.grc.dto.UserPreferencesDTO;
import com.asymmetrix.grc.service.UserService;

@RestController
@RequestMapping({"/users"})
public class UserController {

  @Resource
  UserService userService;

  public static final String PASSWORD_CHANGED_SUCCESS = "Password Changed Successfully";
  public static final String USER_PREFERENCES_SUCCESS =
      "User Preferences Saved or Update  Successfully";

  private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-USER";
  private static final String FIND_USER_ACTION = "FIND-USER";
  private static final String BULK_USER_CREATION_ACTION = "BULK-USER-CREATION";
  private static final String CHANGE_USER_PASSWORD_ACTION = "CHANGE-USER-PASSWORD";
  private static final String FIND_L1_USER_BRNC_ACTION = "FIND-L1_BRN_CODE";
  private static final String SAVE_OR_UPDATE_USER_PREFERENCES = "SAVE_OR_UPDATE_USER_PREFERENCES";
  private static final String FIND_USER_PREFERENCES = "FIND_USER_PREFERENCES";
  private static final String GET_ALL_USER_DETAILS = "GET_ALL_USER_DETAILS";


  private static final String HAS_ROLE_USER_WRITE = "hasRole('ROLE_USER_WRITE')";
  private static final String HAS_ROLE_USER_WRITE_OR_READ =
      "hasRole('ROLE_USER_READ') or hasRole('ROLE_USER_WRITE')";

  private static final String HAS_ROLE_NOTIFICATION_READ_OR_WRITE_OR_ROLE_USER_READ_OR_WRITE =
      "hasRole('ROLE_NOTIFICATION_READ') or hasRole('ROLE_NOTIFICATION_WRITE') OR "
          + HAS_ROLE_USER_WRITE_OR_READ;

  private static final String IS_AUTHENTICATED = "isAuthenticated()";

  @PreAuthorize(HAS_ROLE_USER_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION)
  @PostMapping(value = {"/user"})
  public ResponseEntity<GRCResponse<?>> saveUser(Authentication auth,
      @NonNull @RequestBody CnfgUserDTO model) {
    userService.saveOrUpdateUser(model, GRCConstants.ACTION_SAVE);
    return GRCResponseEntity.success(GRCConstants.CREATE_OR_EDIT_SUCCESS);
  }

  @PreAuthorize(HAS_ROLE_USER_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION)
  @PutMapping(value = {"/user"})
  public ResponseEntity<GRCResponse<?>> updateUser(Authentication auth,
      @NonNull @RequestBody CnfgUserDTO model) {
    userService.saveOrUpdateUser(model, GRCConstants.ACTION_UPDATE);
    return GRCResponseEntity.success(GRCConstants.CREATE_OR_EDIT_SUCCESS);
  }
/*
  @PreAuthorize(HAS_ROLE_USER_WRITE_OR_READ)
  @Loggable(action = FIND_USER_ACTION)
  @GetMapping({"/user", "/user/{userId}"})
  public ResponseEntity<GRCResponse<?>> findAllUserOrById(Authentication auth,
      @PathVariable(required = false) String userId) {
    return GRCResponseEntity.success(
        (ObjectUtils.isEmpty(userId)) ? userService.getAllUser() : userService.getUserById(userId));
  }
 */ 
  
  @PreAuthorize(HAS_ROLE_USER_WRITE_OR_READ)
  @Loggable(action = FIND_USER_ACTION)
  @GetMapping({"/user/{action}", "/user/{userId}/{action}"})
  @MaskUserField
  public ResponseEntity<GRCResponse<?>> findAllUserOrById(Authentication auth,
      @PathVariable(required = false) String userId) {
    return GRCResponseEntity.success(
        (ObjectUtils.isEmpty(userId)) ? userService.getAllUser() : userService.getUserById(userId));
  }

  @PreAuthorize(HAS_ROLE_USER_WRITE)
  @Loggable(action = BULK_USER_CREATION_ACTION)
  @PostMapping(value = "/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<GRCResponse<?>> bulkUserUpload(Authentication auth,
      @NonNull @RequestPart String defaultPassword, @NonNull @RequestPart MultipartFile file) {
    if (!ExcelHelper.hasExcelFormat(file)) {
      return GRCResponseEntity.failure(
          new GRCResponse<>(GRCErrorConstants.FAILED, GRCErrorConstants.INVALID_EXCEL_FILE_FORMAT),
          HttpStatus.BAD_REQUEST);
    }
    return GRCResponseEntity.success(userService.bulkUserCreation(file, defaultPassword));
  }

  @PreAuthorize(IS_AUTHENTICATED)
  @Loggable(action = CHANGE_USER_PASSWORD_ACTION)
  @PostMapping("/user/changePassword")
  public ResponseEntity<GRCResponse<?>> changePassword(Authentication auth,
      @RequestBody(required = true) PasswordDTO passwordModel) {
    userService.updatePasswordByUserIdAndOldPassword(passwordModel.getNewEncryptedPassword(),
        auth.getName(), passwordModel.getOldEncryptedPassword());
    return GRCResponseEntity.success(PASSWORD_CHANGED_SUCCESS);
  }

  @PreAuthorize(HAS_ROLE_NOTIFICATION_READ_OR_WRITE_OR_ROLE_USER_READ_OR_WRITE)
  @Loggable(action = FIND_L1_USER_BRNC_ACTION)
  @GetMapping("/user/reportees/level1/branchCodes")
  public ResponseEntity<Set<String>> getAllReportingLevel1BranchCodes(Authentication auth) {
    return ResponseEntity.ok(userService.getAllRptL1UsrBranchCodes(auth.getName()));
  }

  @PostMapping("/user/{uptoUserLevel}/hierarchy")
  public ResponseEntity<List<CnfgUserWithManagerDTO>> getLvl1UsersWithManagersUptoUsrLvl(
      @NonNull @RequestBody(required = true) Set<String> branchCode,
      @NonNull @PathVariable(name = "uptoUserLevel", required = true) final String uptoUserLevel) {
    return ResponseEntity
        .ok(userService.getLvl1UsersWithManagersUptoUsrLvl(uptoUserLevel, branchCode));
  }

  @PreAuthorize(IS_AUTHENTICATED)
  @Loggable(action = SAVE_OR_UPDATE_USER_PREFERENCES)
  @PostMapping("/user/page/preferences")
  public ResponseEntity<?> saveUserPreferences(Authentication auth,
      @NonNull @RequestBody(required = true) UserPreferencesDTO userPreference) {
    userPreference.setUserId(auth.getName());
    userService.saveUserPreferences(userPreference);
    return GRCResponseEntity.success(USER_PREFERENCES_SUCCESS);
  }

  @PreAuthorize(IS_AUTHENTICATED)
  @Loggable(action = FIND_USER_PREFERENCES)
  @GetMapping("/user/{page}/preferences")
  public ResponseEntity<?> getUserPreferences(Authentication auth,
      @PathVariable(required = true) String page) {
    return GRCResponseEntity.success(userService.getUserPreferencesByPage(auth.getName(), page));
  }
  
  @Loggable(action = GET_ALL_USER_DETAILS)
  @GetMapping({"/user/details"})
  public ResponseEntity<GRCResponse<?>> findAllUserDetails(Authentication auth) {
    return GRCResponseEntity.success(userService.getAllUserDetails());
  }
  
}
