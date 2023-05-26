package com.asymmetrix.grc.Dto;

import java.util.ArrayList;

import java.util.List;

import com.asymmetrix.grc.Entity.ApplicableDepartment;
import com.asymmetrix.grc.Entity.Category;
import com.asymmetrix.grc.Entity.EntityDD;
import com.asymmetrix.grc.Entity.IssuingDepartment;
import com.asymmetrix.grc.Entity.PolicyApprover;
import com.asymmetrix.grc.Entity.PolicyIdPreferenceDD;
import com.asymmetrix.grc.Entity.PolicyLocation;
import com.asymmetrix.grc.Entity.PolicyOrganization;
import com.asymmetrix.grc.Entity.PolicyReviewers;
import com.asymmetrix.grc.Entity.PolicySuisidary;
import com.asymmetrix.grc.Entity.User;
import com.asymmetrix.grc.Entity.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropDownValues {
	
	private List<IssuingDepartment> issuingDepartment;
	private List<Category> category;
	private List<ApplicableDepartment> applicableDepartment;
	private List<EntityDD> entityDD;
	private List<PolicySuisidary> suisidary;
	private List<PolicyLocation> location;
	private List<PolicyOrganization> organization;
	private List<PolicyReviewers> reviewers;
	private List<PolicyApprover> approvers;
	private List<PolicyIdPreferenceDD> idPreferenceModule; //For UniqueId
	private List<UserGroup> userGroup;
	private List<User> user;
	
	
	public List<IssuingDepartment> getIssuingDepartment() {
		return issuingDepartment;
	}
	public void setIssuingDepartment(List<IssuingDepartment> issuingDepartment) {
		this.issuingDepartment = issuingDepartment;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public List<ApplicableDepartment> getApplicableDepartment() {
		return applicableDepartment;
	}
	public void setApplicableDepartment(List<ApplicableDepartment> applicableDepartment) {
		this.applicableDepartment = applicableDepartment;
	}
	public List<EntityDD> getEntityDD() {
		return entityDD;
	}
	public void setEntityDD(List<EntityDD> entityDD) {
		this.entityDD = entityDD;
	}
	public List<PolicySuisidary> getSuisidary() {
		return suisidary;
	}
	public void setSuisidary(List<PolicySuisidary> suisidary) {
		this.suisidary = suisidary;
	}
	public List<PolicyLocation> getLocation() {
		return location;
	}
	public void setLocation(List<PolicyLocation> location) {
		this.location = location;
	}
	public List<PolicyOrganization> getOrganization() {
		return organization;
	}
	public void setOrganization(List<PolicyOrganization> organization) {
		this.organization = organization;
	}
	public List<PolicyReviewers> getReviewers() {
		return reviewers;
	}
	public void setReviewers(List<PolicyReviewers> reviewers) {
		this.reviewers = reviewers;
	}
	public List<PolicyApprover> getApprovers() {
		return approvers;
	}
	public void setApprovers(List<PolicyApprover> approvers) {
		this.approvers = approvers;
	}
	public List<PolicyIdPreferenceDD> getIdPreferenceModule() {
		return idPreferenceModule;
	}
	public void setIdPreferenceModule(List<PolicyIdPreferenceDD> idPreferenceModule) {
		this.idPreferenceModule = idPreferenceModule;
	}
	public List<UserGroup> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(List<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	

}
