package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "KRI_THRESHOLD_THRESHOLD_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriThresholdTypeDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String thresholdTypeId;

	@Column(name = "NAME")
	private String thresholdTypeName;

	@Column(name = "DESCRIPTION")
	private String thresholdTypeDesc;
	
	@Column(name = "T_ORDER")
	private String thresholdTypeOrder;
	
	public String getThresholdTypeId() {
		return thresholdTypeId;
	}

	public void setThresholdTypeId(String thresholdTypeId) {
		this.thresholdTypeId = thresholdTypeId;
	}

	public String getThresholdTypeName() {
		return thresholdTypeName;
	}

	public void setThresholdTypeName(String thresholdTypeName) {
		this.thresholdTypeName = thresholdTypeName;
	}

	public String getThresholdTypeDesc() {
		return thresholdTypeDesc;
	}

	public void setThresholdTypeDesc(String thresholdTypeDesc) {
		this.thresholdTypeDesc = thresholdTypeDesc;
	}

	public String getThresholdTypeOrder() {
		return thresholdTypeOrder;
	}

	public void setThresholdTypeOrder(String thresholdTypeOrder) {
		this.thresholdTypeOrder = thresholdTypeOrder;
	}

}
