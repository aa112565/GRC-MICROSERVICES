package com.asymmetrix.grc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationChartDTO implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private String nameStr;
	private EmployeeDTO topLevelEmpInfo;
	private int level;	
	private String parentID;	
	private EmployeeDTO buHeadEmpInfo;	
	private EmployeeDTO blUserEmpInfo;
	private String parentMapping;
	private EmployeeDTO name;

	private List<OrganizationChartDTO> child =  new ArrayList<OrganizationChartDTO>();
	

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getParentMapping() {
		return parentMapping;
	}

	public void setParentMapping(String parentMapping) {
		this.parentMapping = parentMapping;
	}

	public EmployeeDTO getTopLevelEmpInfo() {
		return topLevelEmpInfo;
	}

	public void setTopLevelEmpInfo(EmployeeDTO topLevelEmpInfo) {
		this.topLevelEmpInfo = topLevelEmpInfo;
	}

	public EmployeeDTO getBuHeadEmpInfo() {
		return buHeadEmpInfo;
	}

	public void setBuHeadEmpInfo(EmployeeDTO buHeadEmpInfo) {
		this.buHeadEmpInfo = buHeadEmpInfo;
	}
	
	public List<OrganizationChartDTO> getChild() {
		return child;
	}

	public void setChild(List<OrganizationChartDTO> child) {
		this.child = child;
	}
	
	public void addChild(OrganizationChartDTO child) {
		this.child.add(child);
	}

	public EmployeeDTO getBlUserEmpInfo() {
		return blUserEmpInfo;
	}

	public void setBlUserEmpInfo(EmployeeDTO blUserEmpInfo) {
		this.blUserEmpInfo = blUserEmpInfo;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getNameStr() {
		return nameStr;
	}

	public void setNameStr(String nameStr) {
		this.nameStr = nameStr;
	}

	public EmployeeDTO getName() {
		return name;
	}

	public void setName(EmployeeDTO name) {
		this.name = name;
	}

	

}
