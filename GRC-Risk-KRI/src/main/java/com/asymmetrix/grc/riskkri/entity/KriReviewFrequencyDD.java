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
@Table(name = "KRI_REVIEWFREQUENCY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriReviewFrequencyDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String frequencyId;

	@Column(name = "NAME")
	private String frequencyName;

	@Column(name = "DESCRIPTION")
	private String frequencyDesc;
	
	@Column(name = "RF_ORDER")
	private String frequencyOrder;

	public String getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(String frequencyId) {
		this.frequencyId = frequencyId;
	}

	public String getFrequencyName() {
		return frequencyName;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	public String getFrequencyDesc() {
		return frequencyDesc;
	}

	public void setFrequencyDesc(String frequencyDesc) {
		this.frequencyDesc = frequencyDesc;
	}

	public String getFrequencyOrder() {
		return frequencyOrder;
	}

	public void setFrequencyOrder(String frequencyOrder) {
		this.frequencyOrder = frequencyOrder;
	}

	
}
