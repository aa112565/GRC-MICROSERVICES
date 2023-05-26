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
@Table(name = "KI_ENTERPRISE_KI_DD")
@NoArgsConstructor
@AllArgsConstructor

public class EnterpriseKiDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ENTERPRISE_KI_ID")
	private String id;

	@Column(name = "ENTERPRISE_KI_NAME")
	private String enterpriseKi;

	@Column(name = "ENTERPRISE_KI_DESC")
	private String enterpriseKiDesc;
	
	@Column(name = "ENTERPRISE_KI_ORDER")
	private String enterpriseKiOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEnterpriseKiDesc() {
		return enterpriseKiDesc;
	}

	public void setEnterpriseKiDesc(String enterpriseKiDesc) {
		this.enterpriseKiDesc = enterpriseKiDesc;
	}

	public String getEnterpriseKi() {
		return enterpriseKi;
	}

	public void setEnterpriseKi(String enterpriseKi) {
		this.enterpriseKi = enterpriseKi;
	}

	public String getEnterpriseKiOrder() {
		return enterpriseKiOrder;
	}

	public void setEnterpriseKiOrder(String enterpriseKiOrder) {
		this.enterpriseKiOrder = enterpriseKiOrder;
	}

	
}
