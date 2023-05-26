package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Table(name = "CNFG_MENU")
@Immutable
public class CnfgMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "V_MENU_ID")
	private String menuId;

	@Column(name = "V_MENU_NAME", updatable = false)
	private String menuName;

	@Column(name = "V_SUB_MENU_NAME", updatable = false)
	private String subMenuName;

	@Column(name = "V_RW_ACCESS",updatable = false)
	private String access;

	@Column(name = "V_ROLE_NAME",updatable = false)
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

	public CnfgMenu() {
	}

	public CnfgMenu(String menuId, String menuName, String subMenuName, String access, String roleName) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.subMenuName = subMenuName;
		this.access = access;
		this.roleName = roleName;
	}

}
