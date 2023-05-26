package com.asymmetrix.grc.controller;


import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.dto.LoginUserDetails;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.dto.RiskWorkshopDTO;
import com.asymmetrix.grc.entity.AttachmentsDTO;
import com.asymmetrix.grc.entity.MOMAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskWorkshopAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskWorkshopMomDTO;
import com.asymmetrix.grc.service.RiskWorkshopService;


@RestController
@RequestMapping("/riskWorkshop")
@PreAuthorize("isAuthenticated()")  
public class RiskWorkshopController {
	
	private static final String ERROR_MSG_INVALID_ATTACHMENT_ID = "Please provide the valid attachment ID to be deleted";
	
	@Resource
	RiskWorkshopService riskWorkshopService;
	
	@GetMapping("/allWorkshops")	
	public ResponseEntity<GRCResponse<?>> getAllWorkshops(Authentication auth) {
	//	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	//  	  LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	//  	  String uname = loginUserDetails.getUsername();
	//  	  String branchname = loginUserDetails.getBranchCode();	  	
	//  	 System.out.println("auth name"+uname+"---------------"+" additonal info--------"+branchname);
	  
	    return GRCResponseEntity.success(riskWorkshopService.getAllWorshopList());
	}
	
	@GetMapping("/workshop/{workshopID}")	
	public ResponseEntity<GRCResponse<?>> getWorkshop(@PathVariable(required = true) String workshopID) {
	    return GRCResponseEntity.success(riskWorkshopService.getWorkshop(workshopID));
	}
	
	@PostMapping("/create")
	public ResponseEntity<GRCResponse<?>> createWorkshop(Authentication auth, @RequestBody RiskWorkshopDTO riskWorkshopDTO) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	  	LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	  	riskWorkshopDTO.setCreatedBy(loginUserDetails.getUsername());
	//  	riskWorkshopDTO.setBranchName(loginUserDetails.getBranchCode());
	//  	 System.out.println("auth name"+loginUserDetails.getUsername()+"---------------"+" additonal info--------"+loginUserDetails.getBranchCode());
		return GRCResponseEntity.success(riskWorkshopService.createWorkshop(riskWorkshopDTO));
	}
	
	@PutMapping("/workshop/update")
	public ResponseEntity<GRCResponse<?>> updateWorkshop(Authentication auth, @RequestBody RiskWorkshopDTO riskWorkshopDTO) {
		//Method name - getRiskTreatments 
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	  	LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	  	riskWorkshopDTO.setModifiedBy(loginUserDetails.getUsername());
	//  	riskWorkshopDTO.setBranchName(loginUserDetails.getBranchCode());
	//  	System.out.println("auth name"+loginUserDetails.getUsername()+"---------------"+" additonal info--------"+loginUserDetails.getBranchCode());
		return GRCResponseEntity.success(riskWorkshopService.updateWorkshop(riskWorkshopDTO));
	}
	
	@DeleteMapping("/workshop/{workshopID}")
	public ResponseEntity<GRCResponse<?>> deleteWorkshop(@PathVariable(required = true) String workshopID){
		return GRCResponseEntity.success(riskWorkshopService.deleteWorkshop(workshopID));  
	}
	
	//Attachments
	
	@GetMapping("/workshop/attachment/{workshopID}")	
	public ResponseEntity<GRCResponse<?>> getAttachmentsOfWorkshop(@PathVariable(required = true) String workshopID) {
	    return GRCResponseEntity.success(riskWorkshopService.getAttachmentsOfWorkshop(workshopID));
	}
	
	@PostMapping("/attachment/create")
	public ResponseEntity<GRCResponse<?>> createWorkshopAttachment(@ModelAttribute AttachmentsDTO attachmentDTO) {		
		if(riskWorkshopService.createWorkshopAttachment(attachmentDTO))
				return GRCResponseEntity.success("Attachments are uploaded");  
		else
			return GRCResponseEntity.badRequest("Error: Attachments are not uploaded");
	}	
		
	@DeleteMapping("/workshop/remove/attachment/{attachmentID}")
	public ResponseEntity<GRCResponse<?>> deleteWorkshopAttachment(@PathVariable(required = true) String attachmentID){
		if(attachmentID != null && !attachmentID.equals(""))
			return GRCResponseEntity.success(riskWorkshopService.deleteWorkshopAttachment(Long.parseLong(attachmentID)));  
		else
			return GRCResponseEntity.badRequest(ERROR_MSG_INVALID_ATTACHMENT_ID);
	}
	
	@GetMapping("/file/{attachmentID}/{fileName}/download")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable Long attachmentID, @NonNull @PathVariable String fileName) {
		RiskWorkshopAttachmentsDTO attachmentDTO = riskWorkshopService.downloadFile(attachmentID,fileName);
		return GRCResponseEntity.downloadResponse(attachmentDTO.getFileBytes(), attachmentDTO.getFiletype(), attachmentDTO.getFileName());  
	}
	
	@GetMapping("/departments/all")
	public ResponseEntity<?> getAllDepartments(){		
//		List<DepartmentDTO> departmentList = new ArrayList<DepartmentDTO>();
//		departmentList.add(new DepartmentDTO("D1", "Logistics Department"));
//		departmentList.add(new DepartmentDTO("D2", "HR Department"));
//		departmentList.add(new DepartmentDTO("D3", "Engineering Department"));
//		departmentList.add(new DepartmentDTO("D4", "Hospitality Department"));
//		departmentList.add(new DepartmentDTO("D5", "Security Department"));		
		return GRCResponseEntity.success(riskWorkshopService.getAllDepartments());		
	}
	
	@GetMapping("/employees/all")
	public ResponseEntity<?> getAllEmployees(){
//		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
//		employeeList.add(new EmployeeDTO("E1", "Rajesh", "D1", new DepartmentDTO("D1", "Logistics Department")));
//		employeeList.add(new EmployeeDTO("E2", "Kumar","D1", new DepartmentDTO("D1", "Logistics Department")));
//		employeeList.add(new EmployeeDTO("E3", "Mohan", "D5", new DepartmentDTO("D5", "Security Department")));
//		employeeList.add(new EmployeeDTO("E4", "Saravanan", "D5", new DepartmentDTO("D5", "Security Department")));
//		employeeList.add(new EmployeeDTO("E5", "Selva", "D2", new DepartmentDTO("D2", "HR Department")));
//		employeeList.add(new EmployeeDTO("E6", "Sankar", "D3", new DepartmentDTO("D3", "Engineering Department")));
//		employeeList.add(new EmployeeDTO("E7", "Ajesh", "D4", new DepartmentDTO("D4", "Hospitality Department")));
//		employeeList.add(new EmployeeDTO("E8", "Guru", "D5", new DepartmentDTO("D5", "Security Department")));
//		return GRCResponseEntity.success(employeeList);
		return GRCResponseEntity.success(riskWorkshopService.getAllEmployees());
	}
	
	//MOM
	
	@PostMapping("mom/create")
	public ResponseEntity<GRCResponse<?>> createRiskMOM(@RequestBody RiskWorkshopMomDTO riskWorkshopMomDTO) {
	    return GRCResponseEntity.success(riskWorkshopService.createWorskhopMOM(riskWorkshopMomDTO));
	}
	
	@GetMapping("/workshop/mom/{workshopID}")	
	public ResponseEntity<GRCResponse<?>> getMomOfWorkshop(@PathVariable(required = true) String workshopID) {
	    return GRCResponseEntity.success(riskWorkshopService.getWorskhopMOM(workshopID));
	}
	
	@GetMapping("/workshop/department/{departmentID}")	
	public ResponseEntity<GRCResponse<?>> getWorkshopAndParticipants(Authentication auth, @PathVariable(required = true) String departmentID) {
	//	OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails)auth.getDetails();
	 // 	  LoginUserDetails loginUserDetails = (LoginUserDetails)oAuth2AuthenticationDetails.getDecodedDetails();
	 // 	  String uname = loginUserDetails.getUsername();
	 // 	  String branchname = loginUserDetails.getBranchCode();	  	
	 // 	 System.out.println("auth name"+uname+"---------------"+" additonal info--------"+branchname);
		return GRCResponseEntity.success(riskWorkshopService.getWorkshopAndParticipants(departmentID));
	}
	
	@PostMapping("mom/attachment/create")
	public ResponseEntity<GRCResponse<?>> createWorkshopMOMAttachment(@ModelAttribute MOMAttachmentsDTO attachmentDTO) {		
		if(riskWorkshopService.createWorkshopMomAttachments(attachmentDTO))
				return GRCResponseEntity.success("Attachments are uploaded");  
		else
			return GRCResponseEntity.badRequest("Error: Attachments are not uploaded");
	}	
}
