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
@Table(name = "KRI_FORMULA_DD")
@NoArgsConstructor
@AllArgsConstructor
public class KriFormulaTypeDD {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String formulaTypeId;

	@Column(name = "FORMULA_NAME")
	private String formulaTypeName;

	@Column(name = "DESCRIPTION")
	private String formulaTypeDesc;

	@Column(name = "FORMULA_ID")
	private String formulaId;
	
	@Column(name = "FORMULA_ORDER")
	private String formulaOrder;

	public String getFormulaTypeId() {
		return formulaTypeId;
	}

	public void setFormulaTypeId(String formulaTypeId) {
		this.formulaTypeId = formulaTypeId;
	}

	public String getFormulaTypeName() {
		return formulaTypeName;
	}

	public void setFormulaTypeName(String formulaTypeName) {
		this.formulaTypeName = formulaTypeName;
	}

	public String getFormulaTypeDesc() {
		return formulaTypeDesc;
	}

	public void setFormulaTypeDesc(String formulaTypeDesc) {
		this.formulaTypeDesc = formulaTypeDesc;
	}

	public String getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}

	public String getFormulaOrder() {
		return formulaOrder;
	}

	public void setFormulaOrder(String formulaOrder) {
		this.formulaOrder = formulaOrder;
	}

	
}
