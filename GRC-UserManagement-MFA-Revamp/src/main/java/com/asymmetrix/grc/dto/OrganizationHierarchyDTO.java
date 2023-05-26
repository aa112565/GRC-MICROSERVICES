package com.asymmetrix.grc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationHierarchyDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String version;
	private int level;
	private String levelName;
	private String boardMemberID;
	private String registrationID;
	private EmployeeDTO topLevelEmpInfo;
	private DepartmentDTO departmentID;
	private String businessUnitName;
	private String parentID;	
	private EmployeeDTO buHeadEmpInfo;
	private EmployeeDTO buRiskOwnerEmpInfo;
	private EmployeeDTO riskChampionEmpInfo;
	private EmployeeDTO blUserEmpInfo;
	private String parentMapping;
	private OrganizationHierarchyDTO parentMappingDTO;
	private String weightage;
	private List<OrganizationHierarchyDTO> child =  new ArrayList<OrganizationHierarchyDTO>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getBoardMemberID() {
		return boardMemberID;
	}

	public void setBoardMemberID(String boardMemberID) {
		this.boardMemberID = boardMemberID;
	}

	public String getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}
	

	public DepartmentDTO getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(DepartmentDTO departmentID) {
		this.departmentID = departmentID;
	}

	public String getBusinessUnitName() {
		return businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}

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

	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
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

	public EmployeeDTO getBuRiskOwnerEmpInfo() {
		return buRiskOwnerEmpInfo;
	}

	public void setBuRiskOwnerEmpInfo(EmployeeDTO buRiskOwnerEmpInfo) {
		this.buRiskOwnerEmpInfo = buRiskOwnerEmpInfo;
	}

	public EmployeeDTO getRiskChampionEmpInfo() {
		return riskChampionEmpInfo;
	}

	public void setRiskChampionEmpInfo(EmployeeDTO riskChampionEmpInfo) {
		this.riskChampionEmpInfo = riskChampionEmpInfo;
	}

	public List<OrganizationHierarchyDTO> getChild() {
		return child;
	}

	public void setChild(List<OrganizationHierarchyDTO> child) {
		this.child = child;
	}
	
	public void addChild(OrganizationHierarchyDTO child) {
		this.child.add(child);
	}

	public EmployeeDTO getBlUserEmpInfo() {
		return blUserEmpInfo;
	}

	public void setBlUserEmpInfo(EmployeeDTO blUserEmpInfo) {
		this.blUserEmpInfo = blUserEmpInfo;
	}

	public OrganizationHierarchyDTO getParentMappingDTO() {
		return parentMappingDTO;
	}

	public void setParentMappingDTO(OrganizationHierarchyDTO parentMappingDTO) {
		this.parentMappingDTO = parentMappingDTO;
	}
	

}
