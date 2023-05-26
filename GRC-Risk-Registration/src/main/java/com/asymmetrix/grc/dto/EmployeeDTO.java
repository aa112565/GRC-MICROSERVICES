package com.asymmetrix.grc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO implements Serializable{	
	
	private static final long serialVersionUID = -7115988039450672317L;
	private String employeeID;
	private String employeeName;
	private String emailAddress;
	private String phoneNumber;	
	private String departmentID;
	private DepartmentDTO department;
	
	public EmployeeDTO(String employeeID, String employeeName, String departmentID, DepartmentDTO departmentDTO) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.departmentID = departmentID;
		this.department = departmentDTO;
	}	
	
	public EmployeeDTO() {
		
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
		
}
