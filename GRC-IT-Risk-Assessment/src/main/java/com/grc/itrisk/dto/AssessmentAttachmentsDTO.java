package com.grc.itrisk.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

import lombok.ToString;

@Data

@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssessmentAttachmentsDTO {

	public AssessmentAttachmentsDTO() {
		super();
	}

	private String docId;
	private String refId;
//	private MultipartFile file;	
	private MultipartFile[] files;
	private byte[] supportDoc;
	private String docName;
	private String docType;

	public AssessmentAttachmentsDTO(String refId, MultipartFile[] files) {
		super();
		this.refId = refId;
		this.files = files;
	}

	public AssessmentAttachmentsDTO(String docId, String refId, MultipartFile[] files, byte[] supportDoc, String docName,
			String docType) {
		super();
		this.docId = docId;
		this.refId = refId;
		this.files = files;
		this.supportDoc = supportDoc;
		this.docName = docName;
		this.docType = docType;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public byte[] getSupportDoc() {
		return supportDoc;
	}

	public void setSupportDoc(byte[] supportDoc) {
		this.supportDoc = supportDoc;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

}
