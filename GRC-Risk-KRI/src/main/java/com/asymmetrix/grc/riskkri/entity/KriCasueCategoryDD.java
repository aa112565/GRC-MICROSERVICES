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
@Table(name = "KRI_CAUSEE_CATEGORY_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriCasueCategoryDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String causeCategoryId;

	@Column(name = "NAME")
	private String causeCategoryName;

	@Column(name = "DESCRIPTION")
	private String causeCategoryDesc;
	
	@Column(name = "CC_ORDER")
	private String causeCategoryOrder;

	public String getCauseCategoryId() {
		return causeCategoryId;
	}

	public void setCauseCategoryId(String causeCategoryId) {
		this.causeCategoryId = causeCategoryId;
	}

	public String getCauseCategoryName() {
		return causeCategoryName;
	}

	public void setCauseCategoryName(String causeCategoryName) {
		this.causeCategoryName = causeCategoryName;
	}

	public String getCauseCategoryDesc() {
		return causeCategoryDesc;
	}

	public void setCauseCategoryDesc(String causeCategoryDesc) {
		this.causeCategoryDesc = causeCategoryDesc;
	}

	public String getCauseCategoryOrder() {
		return causeCategoryOrder;
	}

	public void setCauseCategoryOrder(String causeCategoryOrder) {
		this.causeCategoryOrder = causeCategoryOrder;
	}

	
}
