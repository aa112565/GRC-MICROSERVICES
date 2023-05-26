package com.asymmetrix.grc.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyApprovalHistoryDTO {
	
	 private String approvalLevel;
	    private String approvalStatus;
	    private String comments;
	    private Date createdDate;
	    private String createdBy;
	    
	    public PolicyApprovalHistoryDTO() {
	    }
	    
	    public PolicyApprovalHistoryDTO(final String approvalLevel, final String approvalStatus, final String comments, final Date createdDate, final String createdBy) {
	        this.approvalLevel = approvalLevel;
	        this.approvalStatus = approvalStatus;
	        this.comments = comments;
	        this.createdDate = createdDate;
	        this.createdBy = createdBy;
	    }

		public String getApprovalLevel() {
			return approvalLevel;
		}

		public void setApprovalLevel(String approvalLevel) {
			this.approvalLevel = approvalLevel;
		}

		public String getApprovalStatus() {
			return approvalStatus;
		}

		public void setApprovalStatus(String approvalStatus) {
			this.approvalStatus = approvalStatus;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
	    
	    

}
