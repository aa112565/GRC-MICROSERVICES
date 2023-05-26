package com.asymmetrix.grc.entity;

import org.springframework.web.multipart.MultipartFile;

public class AttachmentsDTO {	
	
	private String workshopID;
	private MultipartFile[] files;
	public String getWorkshopID() {
		return workshopID;
	}
	public void setWorkshopID(String workshopID) {
		this.workshopID = workshopID;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}	
	
}
