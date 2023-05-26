package com.asymmetrix.grc.risk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRIMARY_REASON_SOURCE")
@NoArgsConstructor
@AllArgsConstructor

public class PrimaryReasonSourceDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PRIM_SOURCE_ID")
	private String id;

	@Column(name = "PRIM_SOURCE_NAME")
	private String primarySourceName;

	@Column(name = "PRIM_SOURCE_DESC")
	private String primarySourceDesc;
	
	@Column(name = "PRIM_SOURCE_ORDER")
	private String primarySourceOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrimarySourceName() {
		return primarySourceName;
	}

	public void setPrimarySourceName(String primarySourceName) {
		this.primarySourceName = primarySourceName;
	}

	public String getPrimarySourceDesc() {
		return primarySourceDesc;
	}

	public void setPrimarySourceDesc(String primarySourceDesc) {
		this.primarySourceDesc = primarySourceDesc;
	}

	public String getPrimarySourceOrder() {
		return primarySourceOrder;
	}

	public void setPrimarySourceOrder(String primarySourceOrder) {
		this.primarySourceOrder = primarySourceOrder;
	}
	
	

}
