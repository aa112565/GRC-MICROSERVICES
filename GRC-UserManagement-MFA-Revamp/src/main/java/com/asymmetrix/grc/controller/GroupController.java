package com.asymmetrix.grc.controller;

import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.dto.CnfgUserGroupDTO;
import com.asymmetrix.grc.service.GroupService;

@RestController
@RequestMapping({"/groups"})
public class GroupController {

  private static final String SAVE_OR_EDIT_ACTION = "SAVE-OR-EDIT-GROUP";
  private static final String FIND_GROUP_ACTION = "FIND-GROUP";
  private static final String DELETE_GROUP_ACTION = "DELETE-BY-GROUPID";

  private static final String HAS_ROLE_GROUP_WRITE = "hasRole('ROLE_GROUP_WRITE')";
  private static final String HAS_ROLE_GROUP_WRITE_OR_READ =
      "hasRole('ROLE_GROUP_READ') or hasRole('ROLE_GROUP_WRITE')";

  private static final String HAS_ROLE_GROUP_WRITE_OR_READ_OR_HAS_ROLE_USER_WRITE_OR_READ =
      HAS_ROLE_GROUP_WRITE_OR_READ + " or hasRole('ROLE_USER_READ') or hasRole('ROLE_USER_WRITE')";

  @Resource
  GroupService groupService;

  @PreAuthorize(HAS_ROLE_GROUP_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION)
  @PostMapping(value = {"/group"})
  public ResponseEntity<GRCResponse<?>> saveGroup(Authentication auth,
      @NonNull @RequestBody CnfgUserGroupDTO model) {
    return GRCResponseEntity
        .success(groupService.saveOrUpdateGroup(model, GRCConstants.ACTION_SAVE));
  }

  @PreAuthorize(HAS_ROLE_GROUP_WRITE)
  @Loggable(action = SAVE_OR_EDIT_ACTION)
  @PutMapping(value = {"/group"})
  public ResponseEntity<GRCResponse<?>> updateGroup(Authentication auth,
      @NonNull @RequestBody CnfgUserGroupDTO model) {
    return GRCResponseEntity
        .success(groupService.saveOrUpdateGroup(model, GRCConstants.ACTION_UPDATE));
  }

  @PreAuthorize(HAS_ROLE_GROUP_WRITE_OR_READ_OR_HAS_ROLE_USER_WRITE_OR_READ)
  @Loggable(action = FIND_GROUP_ACTION)
  @GetMapping({"/group", "/group/{groupId}"})
  public ResponseEntity<GRCResponse<?>> findAllGroupOrById(Authentication auth,
      @PathVariable(required = false) String groupId) {
    return GRCResponseEntity.success((ObjectUtils.isEmpty(groupId)) ? groupService.getGroups()
        : groupService.getGroupById(groupId));
  }

  @PreAuthorize(HAS_ROLE_GROUP_WRITE_OR_READ_OR_HAS_ROLE_USER_WRITE_OR_READ)
  @Loggable(action = FIND_GROUP_ACTION)
  @GetMapping({"/group/{groupId}/roles"})
  public ResponseEntity<GRCResponse<?>> findAllRolesByGroupId(Authentication auth,
      @PathVariable(required = true) String groupId) {
    return GRCResponseEntity.success(groupService.getRolesByGroupId(groupId));
  }

  @PreAuthorize(HAS_ROLE_GROUP_WRITE)
  @Loggable(action = DELETE_GROUP_ACTION)
  @DeleteMapping({"/group/{groupId}"})
  public ResponseEntity<GRCResponse<?>> deleteGroupById(Authentication auth,
      @NonNull @PathVariable(required = true) String groupId) {
    groupService.deleteGroupById(groupId);
    return GRCResponseEntity.success(GRCConstants.SUCCESS);
  }

}
