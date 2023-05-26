package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "KRI_FORMULA")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KriFormula extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "F_ID")
	private long formId;

	@Column(name = "FIELD_NAME_ONE")
	private String fieldNameOne;

	@Column(name = "FIELD_NAME_TWO")
	private String fieldNameTwo;

	@Column(name = "FORMULA")
	private String formula;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "KRI_ID", updatable = false)
	private String kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String kriUniqueId;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "FORMULA_ID")
	private String formulaId;

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getFieldNameOne() {
		return fieldNameOne;
	}

	public void setFieldNameOne(String fieldNameOne) {
		this.fieldNameOne = fieldNameOne;
	}

	public String getFieldNameTwo() {
		return fieldNameTwo;
	}

	public void setFieldNameTwo(String fieldNameTwo) {
		this.fieldNameTwo = fieldNameTwo;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getKriId() {
		return kriId;
	}

	public void setKriId(String kriId) {
		this.kriId = kriId;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}

}
