package com.asymmetrix.grc.controller;

import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.service.GroupService;

@RestController
@RequestMapping({"/menus"})
public class MenuController {

  private static final String HAS_ROLE_GROUP_WRITE_OR_READ =
      "hasRole('ROLE_GROUP_READ') or hasRole('ROLE_GROUP_WRITE')";
  private static final String FIND_MENU_ACTION = "FIND-MENU";

  @Resource
  GroupService groupService;

  @PreAuthorize(HAS_ROLE_GROUP_WRITE_OR_READ)
  @Loggable(action = FIND_MENU_ACTION)
  @GetMapping({"/menu"})
  public ResponseEntity<GRCResponse<?>> findAllMenu(Authentication auth) {
    return GRCResponseEntity.success(groupService.getAllMenu());
  }

}
