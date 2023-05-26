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
@Table(name = "KRI_BUSINESSLINE_ONE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriBusinessLineOneDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String businessLineOneId;

	@Column(name = "NAME")
	private String businessLineOneName;

	@Column(name = "DESCRIPTION")
	private String businessLineOneDesc;
	
	@Column(name = "BL_ORDER")
	private String businessLineOneOrder;

	public String getBusinessLineOneId() {
		return businessLineOneId;
	}

	public void setBusinessLineOneId(String businessLineOneId) {
		this.businessLineOneId = businessLineOneId;
	}

	public String getBusinessLineOneName() {
		return businessLineOneName;
	}

	public void setBusinessLineOneName(String businessLineOneName) {
		this.businessLineOneName = businessLineOneName;
	}

	public String getBusinessLineOneDesc() {
		return businessLineOneDesc;
	}

	public void setBusinessLineOneDesc(String businessLineOneDesc) {
		this.businessLineOneDesc = businessLineOneDesc;
	}

	public String getBusinessLineOneOrder() {
		return businessLineOneOrder;
	}

	public void setBusinessLineOneOrder(String businessLineOneOrder) {
		this.businessLineOneOrder = businessLineOneOrder;
	}

	
}
