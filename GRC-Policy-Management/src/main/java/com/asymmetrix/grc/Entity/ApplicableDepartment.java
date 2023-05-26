package com.asymmetrix.grc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PM_APPLICABLEDEPARTMENT_DD")
@NoArgsConstructor
@AllArgsConstructor
public class ApplicableDepartment {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_APPLICABLEDEP_ID")
	private String id;

	@Column(name = "PM_APPLICABLEDEP_NAME")
	private String ApplicableDepName;

	@Column(name = "PM_APPLICABLEDEP_DESC")
	private String ApplicableDepDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicableDepName() {
		return ApplicableDepName;
	}

	public void setApplicableDepName(String applicableDepName) {
		ApplicableDepName = applicableDepName;
	}

	public String getApplicableDepDesc() {
		return ApplicableDepDesc;
	}

	public void setApplicableDepDesc(String applicableDepDesc) {
		ApplicableDepDesc = applicableDepDesc;
	}
	
	
	

}
