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

@Entity
@Table(name = "MST_EMPLOYEE")
public class MstEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "V_EMPLOYEE_ID")
	private String employeeID;

	@Column(name = "V_EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name = "V_DESIGNATION_NAME")
	private String designation;
	
	@Column(name = "V_EMAIL_ADDRESS")
	private String emailAddress;
	
	@OneToOne(targetEntity = MstDepartment.class)
	@JoinColumn(name = "V_DEPARTMENT_CODE", referencedColumnName = "V_DEPARTMENT_CODE", unique = false)
	private MstDepartment department;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public MstDepartment getDepartment() {
		return department;
	}

	public void setDepartment(MstDepartment department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	
	

}
