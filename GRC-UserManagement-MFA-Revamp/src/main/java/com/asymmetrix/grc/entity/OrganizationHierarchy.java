package com.asymmetrix.grc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "ORGANIZATION_HIERARCHY")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationHierarchy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "V_VERSION")
	private String version;
	
	@Column(name = "V_LEVEL")
	private int level;
	
	@Column(name = "V_LEVEL_NAME")
	private String levelName;
	
	@Column(name = "V_BOARD_MEMBER_ID")
	private String boardMemberID;
	
	@Column(name = "V_REGISTRATION_ID")
	private String registrationID;
		
	@OneToOne(targetEntity = MstEmployee.class)
	@JoinColumn(name = "V_L0_EMP_ID", referencedColumnName = "V_EMPLOYEE_ID", unique = false)
	private MstEmployee topLevelEmpInfo;
	
	@OneToOne(targetEntity = MstDepartment.class)
	@JoinColumn(name = "V_DEPT_ID", referencedColumnName = "V_DEPARTMENT_CODE", unique = false)
	private MstDepartment departmentID;
	
	@Column(name = "V_BUSINESS_UNIT_NAME")
	private String businessUnitName;
	
	@Column(name = "V_PARENT_ID")
	private String parentID;
	
	@OneToOne(targetEntity = MstEmployee.class)
	@JoinColumn(name = "V_BU_HEAD_ID", referencedColumnName = "V_EMPLOYEE_ID", unique = false)	
	private MstEmployee buHeadEmpInfo;
	
	@OneToOne(targetEntity = MstEmployee.class)
	@JoinColumn(name = "V_BL_USER_ID", referencedColumnName = "V_EMPLOYEE_ID", unique = false)	
	private MstEmployee blUserEmpInfo;
	
	
	@OneToOne(targetEntity = MstEmployee.class)
	@JoinColumn(name = "V_BU_RISK_OWNER_ID", referencedColumnName = "V_EMPLOYEE_ID", unique = false)
	private MstEmployee buRiskOwnerEmpInfo;
	
	
	@OneToOne(targetEntity = MstEmployee.class)
	@JoinColumn(name = "V_RISK_CHAMPION_ID", referencedColumnName = "V_EMPLOYEE_ID", unique = false)
	private MstEmployee riskChampionEmpInfo;
	
	@Column(name = "V_PARENT_MAPPING")
	private String parentMapping;
	
	@Column(name = "V_WEIGHTAGE")
	private String weightage;
	
	@Column(name = "V_ACTIVE")
	private String active = "Y";

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
	

	public MstDepartment getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(MstDepartment departmentID) {
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

	public MstEmployee getTopLevelEmpInfo() {
		return topLevelEmpInfo;
	}

	public void setTopLevelEmpInfo(MstEmployee topLevelEmpInfo) {
		this.topLevelEmpInfo = topLevelEmpInfo;
	}

	public MstEmployee getBuHeadEmpInfo() {
		return buHeadEmpInfo;
	}

	public void setBuHeadEmpInfo(MstEmployee buHeadEmpInfo) {
		this.buHeadEmpInfo = buHeadEmpInfo;
	}

	public MstEmployee getBuRiskOwnerEmpInfo() {
		return buRiskOwnerEmpInfo;
	}

	public void setBuRiskOwnerEmpInfo(MstEmployee buRiskOwnerEmpInfo) {
		this.buRiskOwnerEmpInfo = buRiskOwnerEmpInfo;
	}

	public MstEmployee getRiskChampionEmpInfo() {
		return riskChampionEmpInfo;
	}

	public void setRiskChampionEmpInfo(MstEmployee riskChampionEmpInfo) {
		this.riskChampionEmpInfo = riskChampionEmpInfo;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public MstEmployee getBlUserEmpInfo() {
		return blUserEmpInfo;
	}

	public void setBlUserEmpInfo(MstEmployee blUserEmpInfo) {
		this.blUserEmpInfo = blUserEmpInfo;
	}
		

}
