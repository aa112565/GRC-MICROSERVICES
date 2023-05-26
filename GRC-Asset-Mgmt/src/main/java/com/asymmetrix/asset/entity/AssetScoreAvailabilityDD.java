package com.asymmetrix.asset.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CM_ASSET_SCORE_AVAILABILITY_INFO_DD")
@NoArgsConstructor
@AllArgsConstructor
public class AssetScoreAvailabilityDD {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String availabilityId;

	@Column(name = "DESCRIPTION")
	private String AvailabilityDesc;

	@Column(name = "VALUE")
	private String availabilityValue;

	public String getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(String availabilityId) {
		this.availabilityId = availabilityId;
	}

	public String getAvailabilityDesc() {
		return AvailabilityDesc;
	}

	public void setAvailabilityDesc(String availabilityDesc) {
		AvailabilityDesc = availabilityDesc;
	}

	public String getAvailabilityValue() {
		return availabilityValue;
	}

	public void setAvailabilityValue(String availabilityValue) {
		this.availabilityValue = availabilityValue;
	}

}
