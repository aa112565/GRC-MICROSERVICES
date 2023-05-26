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
@Table(name = "PM_CATEGORY_DD")
@NoArgsConstructor
@AllArgsConstructor

public class Category {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_CATEGORY_ID")
	private String id;

	@Column(name = "PM_CATEGORY_NAME")
	private String controlCategoryeName;

//	@Column(name = "PM_CATEGORY_DESC")
//	private String controlCategoryDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getControlCategoryeName() {
		return controlCategoryeName;
	}

	public void setControlCategoryeName(String controlCategoryeName) {
		this.controlCategoryeName = controlCategoryeName;
	}

//	public String getControlCategoryDesc() {
//		return controlCategoryDesc;
//	}
//
//	public void setControlCategoryDesc(String controlCategoryDesc) {
//		this.controlCategoryDesc = controlCategoryDesc;
//	}
//	
//	
	
}
