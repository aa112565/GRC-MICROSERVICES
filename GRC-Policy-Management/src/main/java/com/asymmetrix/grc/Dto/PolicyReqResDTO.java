package com.asymmetrix.grc.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolicyReqResDTO {
	
	private CreatePolicyDto createpolicy;
	private PolicyCollaborateDTO policyCollaborateDTO;
	private AttestationsDto attestationsDto;
	private PolicyIdPreferenceDTO policyIdPreferenceDTO;
	private PublishAttestationDTO publishAttestationDTO;
	
	public CreatePolicyDto getCreatepolicy() {
		return createpolicy;
	}
	public void setCreatepolicy(CreatePolicyDto createpolicy) {
		this.createpolicy = createpolicy;
	}
	public PolicyCollaborateDTO getPolicyCollaborateDTO() {
		return policyCollaborateDTO;
	}
	public void setPolicyCollaborateDTO(PolicyCollaborateDTO policyCollaborateDTO) {
		this.policyCollaborateDTO = policyCollaborateDTO;
	}
	public AttestationsDto getAttestationsDto() {
		return attestationsDto;
	}
	public void setAttestationsDto(AttestationsDto attestationsDto) {
		this.attestationsDto = attestationsDto;
	}
	public PolicyIdPreferenceDTO getPolicyIdPreferenceDTO() {
		return policyIdPreferenceDTO;
	}
	public void setPolicyIdPreferenceDTO(PolicyIdPreferenceDTO policyIdPreferenceDTO) {
		this.policyIdPreferenceDTO = policyIdPreferenceDTO;
	}
	public PublishAttestationDTO getPublishAttestationDTO() {
		return publishAttestationDTO;
	}
	public void setPublishAttestationDTO(PublishAttestationDTO publishAttestationDTO) {
		this.publishAttestationDTO = publishAttestationDTO;
	}
	
	
	
	
	
	
	

}
