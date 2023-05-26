package com.asymmetrix.grc.risk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RISK_LIB_ID_PREFERENCE_DD")
@NoArgsConstructor
@AllArgsConstructor
public class RiskIdPreferenceDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String preId;

	@Column(name = "MODULE")
	private String preferenceModule;
	
	@Column(name = "MODULE_VALUE")
	private String moduleValue;

	@Column(name = "MODULE_ORDER")
	private String moduleOrder;

	public String getPreId() {
		return preId;
	}

	public void setPreId(String preId) {
		this.preId = preId;
	}

	public String getPreferenceModule() {
		return preferenceModule;
	}

	public void setPreferenceModule(String preferenceModule) {
		this.preferenceModule = preferenceModule;
	}

	public String getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(String moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getModuleValue() {
		return moduleValue;
	}

	public void setModuleValue(String moduleValue) {
		this.moduleValue = moduleValue;
	}

	

}
