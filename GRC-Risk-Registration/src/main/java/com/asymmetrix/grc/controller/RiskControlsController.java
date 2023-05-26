package com.asymmetrix.grc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.dto.RiskControlAssessmentDTO;
import com.asymmetrix.grc.dto.RiskControlMappingDTO;
import com.asymmetrix.grc.entity.AssessmentAttachmentsDTO;
import com.asymmetrix.grc.entity.RiskControlAssessmentAttachmentsDTO;
import com.asymmetrix.grc.service.RiskAssessmentService;
import com.asymmetrix.grc.service.RiskRegisterService;

@RestController
@PreAuthorize("isAuthenticated()")
public class RiskControlsController {
	
	private static final String ERROR_MSG_INVALID_ATTACHMENT_ID = "Please provide the valid attachment ID to be deleted";

	@Resource
	RiskRegisterService riskRegisterService;
	
	@Resource
	RiskAssessmentService riskAssessmentService;

	@PostMapping("/controls/save")
	public ResponseEntity<?> saveRiskControls(@RequestBody(required = true) RiskControlMappingDTO model) {
		return GRCResponseEntity.success(riskRegisterService.saveRiskControlMapping(model));
	}
	
	@GetMapping("/{riskRegId}/risk/{riskId}/controls/getActiveIds")
	public ResponseEntity<?> getActiveControlIds(@PathVariable(required = true, value = "riskRegId") String riskRegId,
			@PathVariable(required = true, value = "riskId") Long riskId) {
		return GRCResponseEntity.success(riskRegisterService.getActiveControlIds(riskRegId, riskId));
	}
	
	//Risk Control Assessment
	
	@PostMapping("/risk/controls/assessment/update")
	public ResponseEntity<?> saveRiskControlAssessment(@RequestBody(required = true) List<RiskControlAssessmentDTO> riskControlAssessmentDTO) {
		return GRCResponseEntity.success(riskAssessmentService.saveRiskControlAssessment(riskControlAssessmentDTO));
	}
	
	@GetMapping("/risk/{riskId}/regId/{riskRegId}/controls/assessment/all")
	public ResponseEntity<?> getControlAssessments(@PathVariable(required = true, value = "riskRegId") String riskRegId,
			@PathVariable(required = true, value = "riskId") Long riskId) {
		return GRCResponseEntity.success(riskAssessmentService.getAllRiskControlAssessments(riskRegId, riskId));
	}
	
	@GetMapping("/risk/controls/assessments/all")
	public ResponseEntity<?> getAllControlAssessments() {
		return GRCResponseEntity.success(riskAssessmentService.getAllControlAssessments());
	}
	
	//Risk Control Assessment Attachments
	
	@GetMapping("/risk/{riskId}/regId/{riskRegId}/control/{controlId}/assessment/attachment")	
	public ResponseEntity<GRCResponse<?>> getAttachmentsOfWorkshop(@PathVariable(required = true, value = "riskRegId") String riskRegId,
			@PathVariable(required = true, value = "riskId") Long riskId,
			@PathVariable(required = true, value = "controlId") Long controlId) {
		return GRCResponseEntity.success(riskAssessmentService.getAttachmentsOfRiskControlAssessment(riskRegId, riskId, controlId));
	}

	@PostMapping("risk/control/assessment/attachment/create")
	public ResponseEntity<GRCResponse<?>> createWorkshopAttachment(@ModelAttribute AssessmentAttachmentsDTO attachmentDTO) {		
		if(riskAssessmentService.createRiskControlAssessmentAttachment(attachmentDTO))
				return GRCResponseEntity.success("Attachments are uploaded");  
		else
			return GRCResponseEntity.badRequest("Error: Attachments are not uploaded");
	}	
		
	@DeleteMapping("/risk/control/assessment/remove/attachment/{attachmentID}")
	public ResponseEntity<GRCResponse<?>> deleteWorkshopAttachment(@PathVariable(required = true) String attachmentID){
		if(attachmentID != null && !attachmentID.equals(""))
			return GRCResponseEntity.success(riskAssessmentService.deleteRiskControlAssessmentAttachment(Long.parseLong(attachmentID)));  
		else
			return GRCResponseEntity.badRequest(ERROR_MSG_INVALID_ATTACHMENT_ID);
	}
	
	@GetMapping("/risk/control/assessment/file/{attachmentID}/{fileName}/download")
	public ResponseEntity<?> downloadFile(@NonNull @PathVariable Long attachmentID, @NonNull @PathVariable String fileName) {
		RiskControlAssessmentAttachmentsDTO attachmentDTO = riskAssessmentService.downloadFile(attachmentID,fileName);
		return GRCResponseEntity.downloadResponse(attachmentDTO.getFileBytes(), attachmentDTO.getFiletype(), attachmentDTO.getFileName());  
	}
	
	@GetMapping("/risk/assessment/types")
	public ResponseEntity<GRCResponse<?>> getAllAssessmentTypes() {
		return GRCResponseEntity.success(riskAssessmentService.getAllRiskAssessmentTypes());
	}

}
