package com.asymmetrix.grc.entity;

import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "CNFG_OTP")
public class CnfgOTP {
	@Id
	@Column(name = "N_OTP")
	private int otp;
	
	@OneToOne(targetEntity = CnfgUser.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "V_USER_ID")
	private CnfgUser cnfgUser;
	
	@Column(name = "D_EXPIRY")	
	private Date expiryDate;
	
	@Column(name = "N_FALIED_ATTEMPT")
	private int failedAttempt;

	public CnfgOTP() {
		this.failedAttempt = 0;
	}

	public CnfgOTP(final int otp, final int expirationTime) {
		this.failedAttempt = 0;
		this.otp = otp;
		this.expiryDate = this.calculateExpiryDate(expirationTime);
	}

	public CnfgOTP(final int otp, final CnfgUser cnfgUser, final int expirationTime) {
		this.failedAttempt = 0;
		this.otp = otp;
		this.cnfgUser = cnfgUser;
		this.expiryDate = this.calculateExpiryDate(expirationTime);
	}

	public int getOtp() {
		return this.otp;
	}

	public void setOtp(final int otp) {
		this.otp = otp;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(final Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		return new Date(System.currentTimeMillis() + expiryTimeInMinutes * 60000);
	}

	public CnfgUser getCnfgUser() {
		return this.cnfgUser;
	}

	public void setCnfgUser(final CnfgUser cnfgUser) {
		this.cnfgUser = cnfgUser;
	}

	public int getFailedAttempt() {
		return this.failedAttempt;
	}

	public void setFailedAttempt(final int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("CnfgOTP [otp=").append(this.otp).append(", cnfgUserId=").append(this.cnfgUser.getUserId())
				.append(", expiryDate=").append(this.expiryDate).append(", failedAttempt=").append(this.failedAttempt)
				.append("]");
		return builder.toString();
	}
}
