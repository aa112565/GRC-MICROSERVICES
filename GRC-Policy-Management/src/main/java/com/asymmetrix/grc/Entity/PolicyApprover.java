package com.asymmetrix.grc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PM_AAPROVER_DD")
@NoArgsConstructor
@AllArgsConstructor
public class PolicyApprover {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_AAPROVER_ID")
	private String id;

	@Column(name = "PM_AAPROVER_NAME")
	private String approversName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApproversName() {
		return approversName;
	}

	public void setApproversName(String approversName) {
		this.approversName = approversName;
	}
	
	
	

}
