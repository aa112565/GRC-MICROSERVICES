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
@Table(name = "THREAT_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor

public class ThreatCategory {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "THREAT_CATEGORY_ID")
	private String id;

	@Column(name = "THREAT_CATEGORY_NAME")
	private String threatCategoryeName;

	@Column(name = "THREAT_CATEGORY_DESC")
	private String threatCategoryDesc;
	
	@Column(name = "THREAT_CATEGORY_ORDER")
	private String threatCategoryOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThreatCategoryeName() {
		return threatCategoryeName;
	}

	public String getThreatCategoryDesc() {
		return threatCategoryDesc;
	}

	public void setThreatCategoryeName(String threatCategoryeName) {
		this.threatCategoryeName = threatCategoryeName;
	}

	public void setThreatCategoryDesc(String threatCategoryDesc) {
		this.threatCategoryDesc = threatCategoryDesc;
	}

	public String getThreatCategoryOrder() {
		return threatCategoryOrder;
	}

	public void setThreatCategoryOrder(String threatCategoryOrder) {
		this.threatCategoryOrder = threatCategoryOrder;
	}

	
}
