package com.grc.threat.risk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "THREAT_TYPE")
@NoArgsConstructor
@AllArgsConstructor
public class ThreatType {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "THREAT_TYPE_ID")
	private String id;

	@Column(name = "THREAT_TYPE_NAME")
	private String threatTypeName;

	@Column(name = "THREAT_TYPE_DESC")
	private String threatTypeDesc;
	
	@Column(name = "THREAT_TYPE_ORDER")
	private String threatTypeOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThreatTypeName() {
		return threatTypeName;
	}

	public void setThreatTypeName(String threatTypeName) {
		this.threatTypeName = threatTypeName;
	}

	public String getThreatTypeDesc() {
		return threatTypeDesc;
	}

	public void setThreatTypeDesc(String threatTypeDesc) {
		this.threatTypeDesc = threatTypeDesc;
	}

	public String getThreatTypeOrder() {
		return threatTypeOrder;
	}

	public void setThreatTypeOrder(String threatTypeOrder) {
		this.threatTypeOrder = threatTypeOrder;
	}

	
}
