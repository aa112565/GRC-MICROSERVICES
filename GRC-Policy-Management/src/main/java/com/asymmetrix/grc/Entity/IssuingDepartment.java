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
@Table(name = "PM_ISSUINGDEPARTMENT_DD")
@NoArgsConstructor
@AllArgsConstructor
public class IssuingDepartment {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_ISSUINGDEP_ID")
	private String id;

	@Column(name = "PM_ISSUINGDEP_NAME")
	private String IssuingDepName;

	@Column(name = "PM_ISSUINGDEP_DESC")
	private String IssuingDepDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIssuingDepName() {
		return IssuingDepName;
	}

	public void setIssuingDepName(String issuingDepName) {
		IssuingDepName = issuingDepName;
	}

	public String getIssuingDepDesc() {
		return IssuingDepDesc;
	}

	public void setIssuingDepDesc(String issuingDepDesc) {
		IssuingDepDesc = issuingDepDesc;
	}

	
	
	
}
