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
@Table(name = "KI_NATURE_OF_KRI_DD")
@NoArgsConstructor
@AllArgsConstructor

public class NatureOfKriDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "KRI_NATURE_ID")
	private String id;

	@Column(name = "KRI_NATURE_NAME")
	private String natureOfKri;

	@Column(name = "KRI_NATURE_DESC")
	private String kriNatureDesc;
	
	@Column(name = "KRI_NATURE_ORDER")
	private String kriNatureOrder;

	public String getId() {
		return id;
	}

	public String getKriNatureDesc() {
		return kriNatureDesc;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setKriNatureDesc(String kriNatureDesc) {
		this.kriNatureDesc = kriNatureDesc;
	}

	public String getNatureOfKri() {
		return natureOfKri;
	}

	public void setNatureOfKri(String natureOfKri) {
		this.natureOfKri = natureOfKri;
	}

	public String getKriNatureOrder() {
		return kriNatureOrder;
	}

	public void setKriNatureOrder(String kriNatureOrder) {
		this.kriNatureOrder = kriNatureOrder;
	}

	
}
