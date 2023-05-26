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
@Table(name = "CM_ASSET_GLNUMBER_DD")
@NoArgsConstructor
@AllArgsConstructor
public class GlNumberDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String gLNumberId;

	@Column(name = "NAME")
	private String gLNumber;

	@Column(name = "DESCRIPTION")
	private String gLNumberDesc;

	public String getgLNumberId() {
		return gLNumberId;
	}

	public void setgLNumberId(String gLNumberId) {
		this.gLNumberId = gLNumberId;
	}

	public String getgLNumber() {
		return gLNumber;
	}

	public void setgLNumber(String gLNumber) {
		this.gLNumber = gLNumber;
	}

	public String getgLNumberDesc() {
		return gLNumberDesc;
	}

	public void setgLNumberDesc(String gLNumberDesc) {
		this.gLNumberDesc = gLNumberDesc;
	}



}
