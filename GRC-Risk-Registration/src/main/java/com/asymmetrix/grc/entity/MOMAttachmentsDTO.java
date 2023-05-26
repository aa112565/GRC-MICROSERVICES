package com.asymmetrix.grc.entity;

import org.springframework.web.multipart.MultipartFile;

public class MOMAttachmentsDTO {	
	
	private long momID;
	private String workshopID;	
	private MultipartFile[] files;
			
	public long getMomID() {
		return momID;
	}
	public void setMomID(long momID) {
		this.momID = momID;
	}
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
