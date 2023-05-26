package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.CnfgMenuDTO;
import com.asymmetrix.grc.dto.CnfgUserGroupDTO;

public interface GroupService {

  public CnfgUserGroupDTO saveOrUpdateGroup(CnfgUserGroupDTO model, String action);

  public List<CnfgUserGroupDTO> getGroups();

  public CnfgUserGroupDTO getGroupById(String groupId);

  public void deleteGroupById(String groupId);

  List<String> getRolesByGroupId(String groupId);

  List<CnfgMenuDTO> getAllMenu();
}
