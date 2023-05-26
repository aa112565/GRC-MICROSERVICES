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
@Table(name = "KRI_BUSINESSLINE_TWO_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriBusinessLineTwoDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String businessLineTwoId;

	@Column(name = "NAME")
	private String businessLineTwoName;

	@Column(name = "DESCRIPTION")
	private String businessLineTwoDesc;
	
	@Column(name = "BL_ORDER")
	private String businessLineTwoOrder;

	public String getBusinessLineTwoId() {
		return businessLineTwoId;
	}

	public void setBusinessLineTwoId(String businessLineTwoId) {
		this.businessLineTwoId = businessLineTwoId;
	}

	public String getBusinessLineTwoName() {
		return businessLineTwoName;
	}

	public void setBusinessLineTwoName(String businessLineTwoName) {
		this.businessLineTwoName = businessLineTwoName;
	}

	public String getBusinessLineTwoDesc() {
		return businessLineTwoDesc;
	}

	public void setBusinessLineTwoDesc(String businessLineTwoDesc) {
		this.businessLineTwoDesc = businessLineTwoDesc;
	}

	public String getBusinessLineTwoOrder() {
		return businessLineTwoOrder;
	}

	public void setBusinessLineTwoOrder(String businessLineTwoOrder) {
		this.businessLineTwoOrder = businessLineTwoOrder;
	}

	
}
