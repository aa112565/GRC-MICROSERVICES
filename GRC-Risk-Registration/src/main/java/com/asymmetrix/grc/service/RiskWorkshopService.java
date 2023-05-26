package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.DepartmentDTO;
import com.asymmetrix.grc.dto.EmployeeDTO;
import com.asymmetrix.grc.dto.RiskWorkshopDTO;
import com.asymmetrix.grc.dto.RiskWorkshopParticipantsDTO;
import com.asymmetrix.grc.entity.AttachmentsDTO;
import com.asymmetrix.grc.entity.MOMAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskWorkshopAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskWorkshopMomDTO;

public interface RiskWorkshopService {
	
	public RiskWorkshopDTO createWorkshop(RiskWorkshopDTO riskWorkshopDTO);
	public RiskWorkshopDTO updateWorkshop(RiskWorkshopDTO riskWorkshopDTO);
	public RiskWorkshopDTO getWorkshop(String workshopID);
	public List<RiskWorkshopDTO> getAllWorshopList();
	public Integer deleteWorkshop(String workshopID);
	
	//Attachments
	public List<RiskWorkshopAttachmentsDTO> getAttachmentsOfWorkshop(String workshopID);
	public boolean createWorkshopAttachment(AttachmentsDTO attachments);
	public Integer deleteWorkshopAttachment(Long attachmentIDList);
	public RiskWorkshopAttachmentsDTO downloadFile(Long attachmentID, String fileName);	
	
	//MOM
	public RiskWorkshopMomDTO createWorskhopMOM(RiskWorkshopMomDTO riskWorkshopMomDTO);
	public RiskWorkshopMomDTO getWorskhopMOM(String workshopID);
	public boolean createWorkshopMomAttachments(MOMAttachmentsDTO momAttachments);
	
	//MST
	public List<DepartmentDTO> getAllDepartments();
	public List<EmployeeDTO> getAllEmployees();
	
	//Workshop And Participants
	List<RiskWorkshopParticipantsDTO> getWorkshopAndParticipants(String departmentID);

}
