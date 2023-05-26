package com.asymmetrix.grc.service.impl;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.CnfgMenuDTO;
import com.asymmetrix.grc.dto.CnfgUserGroupDTO;
import com.asymmetrix.grc.entity.CnfgUserGroup;
import com.asymmetrix.grc.repository.GroupRepository;
import com.asymmetrix.grc.repository.MenuRepository;
import com.asymmetrix.grc.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

  @Resource
  private GroupRepository groupRepo;

  @Resource
  private MenuRepository menuRepo;

  @Override
  public CnfgUserGroupDTO saveOrUpdateGroup(CnfgUserGroupDTO model, String action) {
    if (GRCConstants.ACTION_SAVE.equals(action)) {
      vaildateGroup(model.getGroupName());
    }
    List<CnfgMenuDTO> dbMenuList =
        MapperUtils.mapToTargetClass(menuRepo.findAll(), CnfgMenuDTO.class);
    model.setCnfgMenu(CnfgMenuDTO.deGroupByMenuName(model.getCnfgMenu(), dbMenuList));
    return MapperUtils.mapToTargetClass(
        groupRepo.save(MapperUtils.mapToTargetClass(model, CnfgUserGroup.class)),
        CnfgUserGroupDTO.class);
  }

  private void vaildateGroup(String groupName) {
    if (isGroupNameAlreadyExisits(groupName)) {
      throw new GRCException(GRCErrorConstants.ERROR_GROUP_NAME_ALREAD_EXISITS);
    }
  }

  private boolean isGroupNameAlreadyExisits(String groupName) {
    CnfgUserGroup group = groupRepo.findByGroupName(groupName);
    return (ObjectUtils.isEmpty(group)) ? Boolean.FALSE : Boolean.TRUE;
  }

  @Override
  public List<CnfgUserGroupDTO> getGroups() {
    List<CnfgUserGroupDTO> cnfgGroupModelList =
        MapperUtils.mapToTargetClass(groupRepo.findAll(), CnfgUserGroupDTO.class);
    for (CnfgUserGroupDTO cnfgGroupModel : cnfgGroupModelList) {
      cnfgGroupModel.setCnfgMenu(CnfgMenuDTO.groupByMenuName(cnfgGroupModel.getCnfgMenu()));
    }
    return cnfgGroupModelList;
  }

  @Override
  public CnfgUserGroupDTO getGroupById(String groupId) {
    Optional<CnfgUserGroup> cnfgUserGroup = groupRepo.findById(groupId);
    CnfgUserGroupDTO cnfgGroupModel = MapperUtils.mapToTargetClass(
        cnfgUserGroup.isPresent() ? cnfgUserGroup.get() : null, CnfgUserGroupDTO.class);
    cnfgGroupModel.setCnfgMenu(CnfgMenuDTO.groupByMenuName(cnfgGroupModel.getCnfgMenu()));
    return cnfgGroupModel;
  }

  @Override
  public void deleteGroupById(String groupId) {
    groupRepo.deleteById(groupId);
  }

  @Override
  public List<String> getRolesByGroupId(String groupId) {
    Optional<CnfgUserGroup> cnfgUserGroup = groupRepo.findById(groupId);
    List<CnfgMenuDTO> menuList = MapperUtils.mapToTargetClass(
        cnfgUserGroup.isPresent() ? cnfgUserGroup.get().getCnfgMenu() : null, CnfgMenuDTO.class);
    return CnfgMenuDTO.getRoles(menuList);
  }

  @Override
  public List<CnfgMenuDTO> getAllMenu() {
    List<CnfgMenuDTO> menuList =
        MapperUtils.mapToTargetClass(menuRepo.findAll(), CnfgMenuDTO.class);
    return CnfgMenuDTO.groupByMenuName(menuList);
  }

}
