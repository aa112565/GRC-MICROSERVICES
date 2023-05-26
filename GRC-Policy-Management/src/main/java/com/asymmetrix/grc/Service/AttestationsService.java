package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.AttestationsDto;
import com.asymmetrix.grc.Dto.PolicyCollaborateDTO;
import com.asymmetrix.grc.Entity.Attestations;
import com.asymmetrix.grc.Entity.PolicyCollaborate;

public interface AttestationsService {
	
	public List<Attestations> getAllAttestations();
	public Attestations createAttestations(AttestationsDto attestationsDto);
	public Attestations updateAttestations(AttestationsDto attestationsDto);
	public Attestations getAttestationsById(long attestaionsId);
	public List<Attestations> getAttestationsByPolicyId(String PolicyId);
	public Attestations deleteAttestations(AttestationsDto attestationsDto);
//	public Attestations getAttestationsCollabrateByPolicyId(long attestaionsId , String PolicyId , String collabrateId);

}
