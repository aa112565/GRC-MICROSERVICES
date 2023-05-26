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
@Table(name = "KRI_COUNT_DATA_COLLECT_FIELD_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriCountDataCollectFieldDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String countDataCollectFieldId;

	@Column(name = "NAME")
	private String countDataCollectFieldName;

	@Column(name = "DESCRIPTION")
	private String countDataCollectFieldDesc;
	
	@Column(name = "CDC_ORDER")
	private String countDataCollectFieldOrder;

	public String getCountDataCollectFieldId() {
		return countDataCollectFieldId;
	}

	public void setCountDataCollectFieldId(String countDataCollectFieldId) {
		this.countDataCollectFieldId = countDataCollectFieldId;
	}

	public String getCountDataCollectFieldName() {
		return countDataCollectFieldName;
	}

	public void setCountDataCollectFieldName(String countDataCollectFieldName) {
		this.countDataCollectFieldName = countDataCollectFieldName;
	}

	public String getCountDataCollectFieldDesc() {
		return countDataCollectFieldDesc;
	}

	public void setCountDataCollectFieldDesc(String countDataCollectFieldDesc) {
		this.countDataCollectFieldDesc = countDataCollectFieldDesc;
	}

	public String getCountDataCollectFieldOrder() {
		return countDataCollectFieldOrder;
	}

	public void setCountDataCollectFieldOrder(String countDataCollectFieldOrder) {
		this.countDataCollectFieldOrder = countDataCollectFieldOrder;
	}

	
}
