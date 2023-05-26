package com.asymmetrix.grc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CNFG_USERS")
public class CnfgUserEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "V_USER_ID", updatable = false)
	private String userId;

	@Column(name = "V_EMAIL")
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
