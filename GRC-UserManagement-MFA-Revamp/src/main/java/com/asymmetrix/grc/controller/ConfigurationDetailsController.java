package com.asymmetrix.grc.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.dto.CnfgPropertyDetailsDTO;
import com.asymmetrix.grc.service.CnfgPropertyDetailsService;

@RestController
@RequestMapping({"/config"})
public class ConfigurationDetailsController {

  private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-LDAP-DETAILS";
  private static final String SAVE_OR_EDIT_ACTION_DB = "SAVE-OR-EDIT-DB-DETAILS";
  private static final String SAVE_OR_EDIT_ACTION_AUTH_TYPE = "SAVE-OR-EDIT-AUTH-TYPE-DETAILS";
  private static final String FIND_ACTION = "FIND-LDAP-DETAILS";
  private static final String FIND_ACTION_DB = "FIND-DB-DETAILS";
  private static final String FIND_ACTION_AUTH_TYPE = "FIND-AUTH-TYPE-DETAILS";
  private static final String GET_ACTION_USER_GRADE = "GET-ALL-GRADE";

  private static final String HAS_ROLE_CNFG_WRITE = "hasRole('ROLE_CNFG_WRITE')";
  private static final String HAS_ROLE_CNFG_WRITE_OR_READ =
      "hasRole('ROLE_CNFG_READ') or hasRole('ROLE_CNFG_WRITE')";

  @Resource
  CnfgPropertyDetailsService cnfgExternalAuthService;

  @PreAuthorize(HAS_ROLE_CNFG_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION)
  @RequestMapping(value = {"/external/ldap"}, method = {RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<GRCResponse<?>> saveLdapDetails(Authentication auth,
      @NonNull @RequestBody List<CnfgPropertyDetailsDTO> model) {
    cnfgExternalAuthService.saveExternalCnfgDetails(model);
    return GRCResponseEntity.success(GRCConstants.SUCCESS);
  }

  @PreAuthorize(HAS_ROLE_CNFG_WRITE_OR_READ)
  @Loggable(action = FIND_ACTION)
  @GetMapping({"/external/ldap"})
  public ResponseEntity<GRCResponse<?>> findAllLdapCnfgDetails(Authentication auth) {
    return GRCResponseEntity
        .success(cnfgExternalAuthService.getAllCnfgDetailsByCnfgName(GRCConstants.LDAP));
  }

  @PreAuthorize(HAS_ROLE_CNFG_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION_DB)
  @RequestMapping(value = {"/external/db"}, method = {RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<GRCResponse<?>> saveDbDetails(Authentication auth,
      @NonNull @RequestBody List<CnfgPropertyDetailsDTO> model) {
    cnfgExternalAuthService.saveExternalCnfgDetails(model);
    return GRCResponseEntity.success(GRCConstants.SUCCESS);
  }

  @PreAuthorize(HAS_ROLE_CNFG_WRITE_OR_READ)
  @Loggable(action = FIND_ACTION_DB)
  @GetMapping({"/external/db"})
  public ResponseEntity<GRCResponse<?>> findAllDbCnfgDetails(Authentication auth) {
    return GRCResponseEntity
        .success(cnfgExternalAuthService.getAllCnfgDetailsByCnfgName(GRCConstants.DB));
  }

  @PreAuthorize(HAS_ROLE_CNFG_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION_AUTH_TYPE)
  @RequestMapping(value = {"/auth/type"}, method = {RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<GRCResponse<?>> saveAuthType(Authentication auth,
      @NonNull @RequestBody List<CnfgPropertyDetailsDTO> model) {
    cnfgExternalAuthService.saveExternalCnfgDetails(model);
    return GRCResponseEntity.success(GRCConstants.SUCCESS);
  }

  @PreAuthorize(HAS_ROLE_CNFG_WRITE_OR_READ)
  @Loggable(action = FIND_ACTION_AUTH_TYPE)
  @GetMapping({"/auth/type"})
  public ResponseEntity<GRCResponse<?>> findCnfgAuthType(Authentication auth) {
    return GRCResponseEntity
        .success(cnfgExternalAuthService.getAllCnfgDetailsByCnfgName(GRCConstants.CONFIG));
  }

  @PreAuthorize(HAS_ROLE_CNFG_WRITE_OR_READ)
  @Loggable(action = GET_ACTION_USER_GRADE)
  @GetMapping({"/user/grades"})
  public ResponseEntity<GRCResponse<?>> getAllUserGrades(Authentication auth) {
    return GRCResponseEntity.success(cnfgExternalAuthService.getAllGradeAsList());
  }

}
