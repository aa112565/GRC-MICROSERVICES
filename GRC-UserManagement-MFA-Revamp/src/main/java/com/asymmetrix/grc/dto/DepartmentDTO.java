package com.asymmetrix.grc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDTO implements Serializable{
		
	private static final long serialVersionUID = -1777865372743974237L;
	private long id;
	private String departmentID;
	private String departmentName;
	private String subDepartmentID;
	private String subDepartmentName;
		
	public DepartmentDTO(String departmentID, String departmentName) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}
	
	public DepartmentDTO() {
		
	}	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSubDepartmentID() {
		return subDepartmentID;
	}

	public void setSubDepartmentID(String subDepartmentID) {
		this.subDepartmentID = subDepartmentID;
	}

	public String getSubDepartmentName() {
		return subDepartmentName;
	}

	public void setSubDepartmentName(String subDepartmentName) {
		this.subDepartmentName = subDepartmentName;
	}	
	
}
