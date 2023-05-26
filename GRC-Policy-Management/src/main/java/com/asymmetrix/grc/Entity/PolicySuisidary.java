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
@Table(name = "PM_SUBISIDARY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class PolicySuisidary {
	
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_SUB_ID")
	private String id;
	
	@Column(name = "PM_SUB_NAME")
	private String SubisidaryName;

//	@Column(name = "PM_SUB_DESC")
//	private String SubisidaryDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubisidaryName() {
		return SubisidaryName;
	}

	public void setSubisidaryName(String subisidaryName) {
		SubisidaryName = subisidaryName;
	}

//	public String getSubisidaryDesc() {
//		return SubisidaryDesc;
//	}
//
//	public void setSubisidaryDesc(String subisidaryDesc) {
//		SubisidaryDesc = subisidaryDesc;
//	}
//	
//	

}
