package com.asymmetrix.grc.dto;

import java.util.Date;

public abstract class Auditable {

	private Date createdDate;

	private Date modifiedDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Auditable(Date createdDate, Date modifiedDate) {
		super();
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public Auditable() {
		super();
	}

}
