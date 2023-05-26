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
@Table(name = "CONTROL_TYPE")
@NoArgsConstructor
@AllArgsConstructor
public class ControlType {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "CONTROL_TYPE_ID")
	private String id;

	@Column(name = "CONTROL_TYPE_NAME")
	private String controlTypeName;

	@Column(name = "CONTROL_TYPE_DESC")
	private String controlTypeDesc;
	
	@Column(name = "CONTROL_TYPE_ORDER")
	private String controlTypeOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getControlTypeName() {
		return controlTypeName;
	}

	public void setControlTypeName(String controlTypeName) {
		this.controlTypeName = controlTypeName;
	}

	public String getControlTypeDesc() {
		return controlTypeDesc;
	}

	public void setControlTypeDesc(String controlTypeDesc) {
		this.controlTypeDesc = controlTypeDesc;
	}

	public String getControlTypeOrder() {
		return controlTypeOrder;
	}

	public void setControlTypeOrder(String controlTypeOrder) {
		this.controlTypeOrder = controlTypeOrder;
	}

	
}
