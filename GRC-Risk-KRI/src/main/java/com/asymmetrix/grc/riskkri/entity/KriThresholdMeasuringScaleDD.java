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
@Table(name = "KRI_THRESHOLD_MEASURINGSCALE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriThresholdMeasuringScaleDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String measuringScaleId;

	@Column(name = "NAME")
	private String measuringScaleName;

	@Column(name = "DESCRIPTION")
	private String measuringScaleDesc;
	
	@Column(name = "TMS_ORDER")
	private String measuringScaleOrder;

	public String getMeasuringScaleId() {
		return measuringScaleId;
	}

	public void setMeasuringScaleId(String measuringScaleId) {
		this.measuringScaleId = measuringScaleId;
	}

	public String getMeasuringScaleName() {
		return measuringScaleName;
	}

	public void setMeasuringScaleName(String measuringScaleName) {
		this.measuringScaleName = measuringScaleName;
	}

	public String getMeasuringScaleDesc() {
		return measuringScaleDesc;
	}

	public void setMeasuringScaleDesc(String measuringScaleDesc) {
		this.measuringScaleDesc = measuringScaleDesc;
	}

	public String getMeasuringScaleOrder() {
		return measuringScaleOrder;
	}

	public void setMeasuringScaleOrder(String measuringScaleOrder) {
		this.measuringScaleOrder = measuringScaleOrder;
	}

	
}
