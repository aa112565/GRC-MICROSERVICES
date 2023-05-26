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
@Table(name = "PM_ORGANIZATION_DD")
@NoArgsConstructor
@AllArgsConstructor
public class PolicyOrganization {
	
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_ORG_ID")
	private String id;

	@Column(name = "PM_ORG_NAME")
	private String OrgName;

	@Column(name = "PM_ORG_DESC")
	private String OrgDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}

	public String getOrgDesc() {
		return OrgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		OrgDesc = orgDesc;
	}
	
	
}
