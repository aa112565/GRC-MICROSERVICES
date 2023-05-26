package com.asymmetrix.grc.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.asymmetrix.grc.common.utils.GRCConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CnfgMenuDTO {

  private String menuId;

  private String menuName;

  private String subMenuName;

  private String access;

  private String roleName;

  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getSubMenuName() {
    return subMenuName;
  }

  public void setSubMenuName(String subMenuName) {
    this.subMenuName = subMenuName;
  }

  public String getAccess() {
    return access;
  }

  public void setAccess(String access) {
    this.access = access;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public CnfgMenuDTO() {}

  public CnfgMenuDTO(String menuId, String menuName, String subMenuName, String access,
      String roleName) {
    super();
    this.menuId = menuId;
    this.menuName = menuName;
    this.subMenuName = subMenuName;
    this.access = access;
    this.roleName = roleName;
  }

  public static List<String> getRoles(List<CnfgMenuDTO> menuModel) {
    return menuModel.stream().map(menu -> menu.getRoleName()).collect(Collectors.toList());
  }

  public static List<CnfgMenuDTO> deGroupByMenuName(List<CnfgMenuDTO> uiMenuList,
      List<CnfgMenuDTO> dbMenuList) {
    Map<String, List<CnfgMenuDTO>> menuMap = new HashMap<>();
    uiMenuList.stream().forEach(ui -> checkByName(dbMenuList, ui, menuMap));
    return menuMap.values().stream().collect(ArrayList::new, List::addAll, List::addAll);
  }

  private static void checkByName(List<CnfgMenuDTO> dbMenuList, CnfgMenuDTO uiMenu,
      Map<String, List<CnfgMenuDTO>> menuMap) {
    dbMenuList.stream().forEach(dbMenu -> {
      if (uiMenu.getMenuName().equals(dbMenu.getMenuName())) {
        checkByAccess(dbMenu, uiMenu, menuMap);
      }
    });
  }

  private static void checkByAccess(CnfgMenuDTO dbMenu, CnfgMenuDTO uiMenu,
      Map<String, List<CnfgMenuDTO>> menuMap) {
    if ("RW".equalsIgnoreCase(uiMenu.getAccess()) || "WR".equalsIgnoreCase(uiMenu.getAccess())
        || dbMenu.getAccess().equals(uiMenu.getAccess())) {
      updateMenuMap(dbMenu, menuMap);
    }
  }

  private static void updateMenuMap(CnfgMenuDTO dbMenu,
      Map<String, List<CnfgMenuDTO>> menuMap) {
    List<CnfgMenuDTO> valueList =
        menuMap.containsKey(dbMenu.getMenuName()) ? menuMap.get(dbMenu.getMenuName())
            : new ArrayList<>();
    valueList.add(dbMenu);
    menuMap.put(dbMenu.getMenuName(), valueList);
  }

  public static List<CnfgMenuDTO> groupByMenuName(List<CnfgMenuDTO> menuList) {
    Map<String, CnfgMenuDTO> menuMap = new HashMap<>();
    menuList.forEach(m -> menuMap.merge(m.getMenuName(), m, (o, n) -> {
      return mapMenu(o, n);
    }));
    return new ArrayList<>(menuMap.values());
  }

  private static CnfgMenuDTO mapMenu(CnfgMenuDTO model1, CnfgMenuDTO model2) {
    CnfgMenuDTO cnfgMenu = new CnfgMenuDTO();
    cnfgMenu.setMenuName(model1.getMenuName());
    cnfgMenu.setSubMenuName(model1.getSubMenuName());
    cnfgMenu.setMenuId(model1.getMenuId().concat(GRCConstants.COMMA).concat(model2.getMenuId()));
    cnfgMenu
        .setRoleName(model1.getRoleName().concat(GRCConstants.COMMA).concat(model2.getRoleName()));
    cnfgMenu.setAccess(model1.getAccess().concat(model2.getAccess()));
    return cnfgMenu;
  }

}
