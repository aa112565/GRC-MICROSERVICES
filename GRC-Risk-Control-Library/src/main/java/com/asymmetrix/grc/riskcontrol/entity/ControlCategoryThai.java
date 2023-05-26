package com.asymmetrix.grc.riskcontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONTROL_CATEGORY_THAI")
@NoArgsConstructor
@AllArgsConstructor

public class ControlCategoryThai {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "CONTROL_CATEGORY_ID")
	private String id;

	@Column(name = "CONTROL_CATEGORY_NAME")
	private String controlCategoryeName;

	@Column(name = "CONTROL_CATEGORY_DESC")
	private String controlCategoryDesc;
	
	@Column(name = "CONTROL_CATEGORY_ORDER")
	private String controlCategoryOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getControlCategoryeName() {
		return controlCategoryeName;
	}

	public String getControlCategoryDesc() {
		return controlCategoryDesc;
	}

	public void setControlCategoryeName(String controlCategoryeName) {
		this.controlCategoryeName = controlCategoryeName;
	}

	public void setControlCategoryDesc(String controlCategoryDesc) {
		this.controlCategoryDesc = controlCategoryDesc;
	}

	public String getControlCategoryOrder() {
		return controlCategoryOrder;
	}

	public void setControlCategoryOrder(String controlCategoryOrder) {
		this.controlCategoryOrder = controlCategoryOrder;
	}

	
}
