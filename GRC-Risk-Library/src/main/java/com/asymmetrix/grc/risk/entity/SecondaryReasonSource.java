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
@Table(name = "SECONDARY_REASON_SOURCE")
@NoArgsConstructor
@AllArgsConstructor

public class SecondaryReasonSource {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "SECOND_SOURCE_ID")
	private String id;

	@Column(name = "SECOND_SOURCE_NAME")
	private String secondarySourceName;

	@Column(name = "SECOND_SOURCE_DESC")
	private String secondarySourceDesc;
	
	@Column(name = "SECOND_SOURCE_ORDER")
	private String secondarySourceOrder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecondarySourceName() {
		return secondarySourceName;
	}

	public void setSecondarySourceName(String secondarySourceName) {
		this.secondarySourceName = secondarySourceName;
	}

	public String getSecondarySourceDesc() {
		return secondarySourceDesc;
	}

	public void setSecondarySourceDesc(String secondarySourceDesc) {
		this.secondarySourceDesc = secondarySourceDesc;
	}

	public String getSecondarySourceOrder() {
		return secondarySourceOrder;
	}

	public void setSecondarySourceOrder(String secondarySourceOrder) {
		this.secondarySourceOrder = secondarySourceOrder;
	}

	
}
