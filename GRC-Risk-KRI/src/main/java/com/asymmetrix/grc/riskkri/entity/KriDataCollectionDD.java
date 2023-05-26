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
@Table(name = "KRI_DATA_COLLECTION_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriDataCollectionDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String dataCollectionId;

	@Column(name = "NAME")
	private String dataCollectionName;

	@Column(name = "DESCRIPTION")
	private String dataCollectionDesc;
	
	@Column(name = "DC_ORDER")
	private String dataCollectionOrder;

	public String getDataCollectionId() {
		return dataCollectionId;
	}

	public void setDataCollectionId(String dataCollectionId) {
		this.dataCollectionId = dataCollectionId;
	}

	public String getDataCollectionName() {
		return dataCollectionName;
	}

	public void setDataCollectionName(String dataCollectionName) {
		this.dataCollectionName = dataCollectionName;
	}

	public String getDataCollectionDesc() {
		return dataCollectionDesc;
	}

	public void setDataCollectionDesc(String dataCollectionDesc) {
		this.dataCollectionDesc = dataCollectionDesc;
	}

	public String getDataCollectionOrder() {
		return dataCollectionOrder;
	}

	public void setDataCollectionOrder(String dataCollectionOrder) {
		this.dataCollectionOrder = dataCollectionOrder;
	}

	
}
