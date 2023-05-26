package com.grc.itrisk.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.exception.ITRiskException;
import com.grc.itrisk.common.utils.ITRiskUtils;
import com.grc.itrisk.common.utils.MapperUtils;
import com.grc.itrisk.dao.AssessmentAssesseeRepository;
import com.grc.itrisk.dao.AssessmentAssessorsRepository;
import com.grc.itrisk.dao.AssessmentLogRepository;
import com.grc.itrisk.dao.AssessmentRepository;
import com.grc.itrisk.dto.AssessmentAssesseeDTO;
import com.grc.itrisk.dto.AssessmentAssessorsDTO;
import com.grc.itrisk.dto.AssessmentAttachmentsDTO;
import com.grc.itrisk.dto.AssessmentDTO;
import com.grc.itrisk.dto.AssessmentFileUploadDTO;
import com.grc.itrisk.dto.ITRiskPreferenceDTO;
import com.grc.itrisk.entity.Assessment;
import com.grc.itrisk.entity.AssessmentFileUpload;
import com.grc.itrisk.entity.AssessmentLog;
import com.grc.itrisk.entity.ITRiskPreference;

import com.grc.itrisk.exception.ResourceNotFoundException;
import com.grc.itrisk.service.AssessmentFileUploadService;
import com.grc.itrisk.service.AssessmentService;
import com.grc.itrisk.service.ITRiskIdPreferenceService;


@Service
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentRepository assessmentRepo;
	
	@Autowired
	private AssessmentLogRepository assessmentLogRepo;
	
	@Resource
	AssessmentAssessorsRepository assessorRepo;
	
	@Resource
	AssessmentAssesseeRepository assesseeRepo;
	
	@Autowired
	private AssessmentFileUploadService docService;
	
	@Autowired
	private ITRiskIdPreferenceService idPreference;

	AssessmentFileUploadDTO fileupload;
	
	
	private static final String ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE = "Y";
	
	private static final String VERSION_PREFIX = "ITRisk/";


	@Override
	public List<AssessmentDTO> getAllAssessment() {
		List<Assessment> assessmentList = assessmentRepo.findAllAssessment();
		 if (assessmentList.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }		 
		 List<AssessmentDTO> assessList = MapperUtils.mapToTargetClass(assessmentList, AssessmentDTO.class);			
			for (AssessmentDTO assessorsAssessment : assessList){
				List<AssessmentAssessorsDTO> filteredAssessorsList = assessorsAssessment.getAssessors().stream()
					.filter(a -> a.getActive().equals(ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE)).collect(Collectors.toList());
				assessorsAssessment.setAssessors(filteredAssessorsList);			
			}			
			for (AssessmentDTO assesseeAssessment : assessList){
				List<AssessmentAssesseeDTO> filteredAssesseeList = assesseeAssessment.getAssessee().stream()
					.filter(a -> a.getActive().equals(ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE)).collect(Collectors.toList());
				assesseeAssessment.setAssessee(filteredAssesseeList);			
			}					
		return assessList;
	}


	@Override
	public List<AssessmentDTO> getAllAssessmentByTemplateId(long templateId) {
		List<Assessment> assessment = assessmentRepo.getAllAssessmentByTemplateId(templateId);		
		 if (assessment.size() <= 0) {
		      throw new ITRiskException(ITRiskErrorConstants.NOT_VALID);
		    }		 
		List<AssessmentDTO> assessList = MapperUtils.mapToTargetClass(assessment, AssessmentDTO.class);		
		for (AssessmentDTO assessorsAssessment : assessList){
			List<AssessmentAssessorsDTO> filteredAssessorsList = assessorsAssessment.getAssessors().stream()
				.filter(a -> a.getActive().equals(ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE)).collect(Collectors.toList());
			assessorsAssessment.setAssessors(filteredAssessorsList);			
		}		
		for (AssessmentDTO assesseeAssessment : assessList){
			List<AssessmentAssesseeDTO> filteredAssesseeList = assesseeAssessment.getAssessee().stream()
				.filter(a -> a.getActive().equals(ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE)).collect(Collectors.toList());
			assesseeAssessment.setAssessee(filteredAssesseeList);			
		}
		return assessList;		
	}

	
	@Override
	public AssessmentDTO getAssessmentById(long assessmentId) {
		
		//return assessmentRepo.findById(assessmentId)
		//		.orElseThrow(() -> new ITRiskException(ITRiskErrorConstants.ENTITY_NOT_FOUND + assessmentId));
		
		Assessment vAssessment = assessmentRepo.findById(assessmentId).orElseThrow(
				() -> new ResourceNotFoundException("IT-Risk-Assessment not found with  Id----> " + assessmentId));
		AssessmentDTO assessment = MapperUtils.mapToTargetClass( vAssessment, AssessmentDTO.class) ;		
		
		List<AssessmentAssessorsDTO> filteredAssessorsList = assessment.getAssessors().stream()
				.filter(a -> a.getActive().equals(ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE)).collect(Collectors.toList());
		assessment.setAssessors(filteredAssessorsList);	
		
		List<AssessmentAssesseeDTO> filteredAssesseeList = assessment.getAssessee().stream()
				.filter(a -> a.getActive().equals(ASSESSMENT_ASSESSORS_AND_ASSESSEE_ACTIVE)).collect(Collectors.toList());
		assessment.setAssessee(filteredAssesseeList);		
		return assessment;
		
	}

	public List<Assessment> saveAll(List<Assessment> assessmentList) {
		return this.assessmentRepo.saveAll(assessmentList);
	}

	@SuppressWarnings("unused")
	@Override
	public AssessmentDTO createAssessment(AssessmentDTO assessmentDto) {	
		String preOrg = null, preYear = null, uniqueIdPartOne = null, uniqueIdPartTwo = null;
		String uniqueId = null, module = "Assessment";
		ITRiskPreference preference = null;
		
		int count = idPreference.getITRiskIdPreferenceCountByActiveflag(module);
		int newCount = idPreference.findNewIdPreferenceCountByStatusFlag(module);
		if (count > 0) {
			preference = idPreference.getITRiskIdPreferenceByModule(module);
		}

		if (preference.getPreferenceOganization() != null) {
			uniqueIdPartOne = preference.getPreferenceOganization() + "/";
			if (preference.getPreferenceYear() != null) {
				uniqueIdPartOne = uniqueIdPartOne + preference.getPreferenceYear() + "/";
			}
		} else if (preference.getPreferenceYear() != null) {
			uniqueIdPartOne = preference.getPreferenceYear() + "/";
		}

		uniqueIdPartTwo = generateNewVersion(preference, newCount);

		if (uniqueIdPartOne != null) {
			uniqueId = uniqueIdPartOne + uniqueIdPartTwo;
		} else {
			uniqueId = uniqueIdPartTwo;
		}
		assessmentDto.setAssessmentUniqueId(uniqueIdPartTwo);
		if (preference.getPreferenceOganization() != null) {
			assessmentDto.setPreferenceOganization(preference.getPreferenceOganization());
		}
		if (preference.getPreferenceYear() != null) {
			assessmentDto.setPreferenceYear(preference.getPreferenceYear());
		}	

		Assessment assessment = MapperUtils.mapToTargetClass(assessmentDto, Assessment.class);
		
		if(assessmentDto.getSaveFlag() != null && "Y".equals(assessmentDto.getSaveFlag())) {		
			assessment.setActiveFlag("Y");
			assessment.setDeleteFlag("N");
			assessment.setSaveFlag("Y");
			assessment.setApprovalFlag("N");
			assessment.setApprovalStatus("Pending");
			assessment.setApprovalRemarks("Pending");
			assessment.setInitialAssessmentFlag("N");
			assessment.setInitialAssessmentStatus("Pending");
			assessment.setPostTreatmentFlag("N");
			assessment.setPostTreatmentStatus("Pending");
			assessment.setStatus("Assessment");
		}else {
				assessment.setActiveFlag("Y");
				assessment.setDeleteFlag("N");
				assessment.setSaveFlag("N");
				assessment.setApprovalFlag("N");
				assessment.setApprovalStatus("Pending");
				assessment.setApprovalRemarks("Pending");
				assessment.setInitialAssessmentFlag("N");
				assessment.setInitialAssessmentStatus("Pending");
				assessment.setPostTreatmentFlag("N");
				assessment.setPostTreatmentStatus("Pending");
				assessment.setStatus("Assessment");
				}
	
	//	return this.assessmentRepo.save(assessment);
		AssessmentDTO assess = MapperUtils.mapToTargetClass(assessmentRepo.save(assessment), AssessmentDTO.class);
		return assess;
	}
	
	public AssessmentLog updateAssessmentLog(long assessmentId) {			
		AssessmentDTO existingTemplate = getAssessmentById(assessmentId);		
		AssessmentLog assessmentLog = MapperUtils.mapToTargetClass(existingTemplate, AssessmentLog.class);
		return this.assessmentLogRepo.save(assessmentLog);
	}

	
	@Override
	@Transactional
	public AssessmentDTO updateAssessment(AssessmentDTO assessmentDto) {		
		@SuppressWarnings("unused")
		AssessmentLog log = updateAssessmentLog(assessmentDto.getAssessmentId());
		assessorRepo.updateITRiskAssessmentAssessorToInactive(assessmentDto.getAssessmentId());
		assesseeRepo.updateITRiskAssessmentAssesseeToInactive(assessmentDto.getAssessmentId());
		Assessment assessment = MapperUtils.mapToTargetClass(assessmentDto, Assessment.class);
		
		if(assessmentDto.getSaveFlag() != null && "Y".equals(assessmentDto.getSaveFlag())) {		
			assessment.setActiveFlag("Y");
			assessment.setDeleteFlag("N");
			assessment.setSaveFlag("Y");
			assessment.setApprovalFlag("N");
		//	assessment.setApprovalStatus("Pending");
		//	assessment.setApprovalRemarks("Pending");
		 }else {
				assessment.setActiveFlag("Y");
				assessment.setDeleteFlag("N");
				assessment.setSaveFlag("N");
				assessment.setApprovalFlag("N");
		//		assessment.setApprovalStatus("Pending");
		//		assessment.setApprovalRemarks("Pending");
				}
//		assessment.setActiveFlag("Y");
//		assessment.setDeleteFlag("N");
//		return this.assessmentRepo.save(assessment);	
		AssessmentDTO assess = MapperUtils.mapToTargetClass(assessmentRepo.save(assessment), AssessmentDTO.class);
		return assess;
	}


	@Override
	public boolean deleteAssessment(AssessmentDTO assessmentDto) {
		Assessment existingTemplate = MapperUtils.mapToTargetClass(getAssessmentById(assessmentDto.getAssessmentId()), Assessment.class);
		existingTemplate.setActiveFlag("N");
		existingTemplate.setDeleteFlag("D");
		existingTemplate.setRemarks(assessmentDto.getRemarks());
	//	return this.assessmentRepo.save(existingTemplate);	
		assessorRepo.updateITRiskAssessmentAssessorToInactive(assessmentDto.getAssessmentId());
		assesseeRepo.updateITRiskAssessmentAssesseeToInactive(assessmentDto.getAssessmentId());
		Assessment removeTemplate = assessmentRepo.save(existingTemplate);
		return (ObjectUtils.isEmpty(removeTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean inActiveAssessment(AssessmentDTO assessmentDto) {
		Assessment existingTemplate = MapperUtils.mapToTargetClass(getAssessmentById(assessmentDto.getAssessmentId()), Assessment.class);
		existingTemplate.setActiveFlag("N");	
		existingTemplate.setRemarks(assessmentDto.getRemarks());
		Assessment inActiveTemplate = assessmentRepo.save(existingTemplate);
		return (ObjectUtils.isEmpty(inActiveTemplate)) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean activeAssessment(AssessmentDTO assessmentDto) {
		Assessment existingTemplate = MapperUtils.mapToTargetClass(getAssessmentById(assessmentDto.getAssessmentId()), Assessment.class);
		existingTemplate.setActiveFlag("Y");	
		existingTemplate.setRemarks(assessmentDto.getRemarks());
		Assessment activeTemplate = assessmentRepo.save(existingTemplate);
		return (ObjectUtils.isEmpty(activeTemplate)) ? Boolean.FALSE : Boolean.TRUE;		
	}
	
	
	@Override
	@Transactional
	public String createFiles(AssessmentAttachmentsDTO vendorDto, String userName) {		
		String result= null;
		 @SuppressWarnings("unused")
		int testCount = vendorDto.getFiles().length;
	//	 System.out.println("file count => "+ testCount);
		if(!vendorDto.getFiles()[0].isEmpty()) {
			String fileupload = fileUpload(vendorDto, userName);
			result= fileupload;
		}else {			
				result= "No Attachment found !";	
				throw new ITRiskException("No Attachment found !");
			}
			
		return result;
	}
	
	// file delete
	@Override
	public String fileDelete(String refId) {
		List<AssessmentFileUpload> existFileList = docService.getAllDocByRefId(refId);
		for (AssessmentFileUpload file : existFileList) {
			docService.deleteUpdate(file);
		}
		return "success";
	}

	// file delete
	@Override
	public String fileDeleteByDocId(String docId) {
		@SuppressWarnings("unused")
		AssessmentFileUpload existfile = docService.deleteDocUpdate(docId);
		return "success";
	}
	
	@Override
	public List<AssessmentFileUploadDTO> findAllAttachment(String refId) {
		List<AssessmentFileUploadDTO> attachments = docService.findAllAttachment(refId);
		ITRiskUtils.isValid(attachments, "No Attachment found !");		
		return attachments;
	}
	
	@Override
	public AssessmentFileUploadDTO downloadFile(String docId) {
		AssessmentFileUploadDTO attachments = MapperUtils.mapToTargetClass(docService.getDocById(docId), AssessmentFileUploadDTO.class) ;
		ITRiskUtils.isValid(attachments, "No Attachment found !");		
		return attachments;
	}
	
	
	// file upload
	private String fileUpload(AssessmentAttachmentsDTO vendorAssessmentDto, String userName) {
		if (!vendorAssessmentDto.getFiles()[0].isEmpty()) {
			for (MultipartFile file : vendorAssessmentDto.getFiles()) {
			//	 System.out.println(file.getContentType() + "-=--=> "+ file.getOriginalFilename());
				try {
					fileupload = new AssessmentFileUploadDTO(file.getOriginalFilename(), file.getContentType(),
							file.getBytes(), vendorAssessmentDto.getRefId(), userName);
					@SuppressWarnings("unused")
					AssessmentFileUpload upload = docService.createDoc(fileupload);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "success";
	}


	private String generateNewVersion(ITRiskPreference idPref, int count) {
		String prefix = VERSION_PREFIX + idPref.getRunningSeries().trim() + "/";
		Assessment  templateMaster= assessmentRepo.findFirstByOrderByCreatedDateDescAssessmentIdDesc();
		int numberPartOfLastCreatedID = 0;
		if (count <= 0) {
			if (templateMaster.getAssessmentUniqueId() != null) {
				String lastCreatedworkshopID = templateMaster.getAssessmentUniqueId();
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(lastCreatedworkshopID);
				while (matcher.find()) {
					numberPartOfLastCreatedID = 0;
					numberPartOfLastCreatedID = Integer.parseInt(matcher.group());
				}
				// New ID
				int newVersionID = numberPartOfLastCreatedID + 1;
				return prefix + newVersionID;
			} else {
				return prefix + 1;
			}
		} else {
			String res = prefix + 1;
			idPref.setStatus("N");
			@SuppressWarnings("unused")
			ITRiskPreference preference = idPreference
					.updateITRiskIdPreference(MapperUtils.mapToTargetClass(idPref, ITRiskPreferenceDTO.class), "Admin");
			return res;
		}
	}
}
