package com.asymmetrix.grc.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.AttestationsDto;
import com.asymmetrix.grc.Entity.Attestations;
import com.asymmetrix.grc.Entity.PolicyCollaborate;
import com.asymmetrix.grc.Repository.AttestationsRepo;
import com.asymmetrix.grc.Service.AttestationsService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;


@Service
public class AttestationsServiceImpl implements AttestationsService {
	
	@Resource
	AttestationsRepo attestationsRepo;

	@Override
	public Attestations createAttestations(AttestationsDto attestationsDto) {
		attestationsRepo.updateAlert(attestationsDto.getPolicyId(), attestationsDto.getAttestaionsId() );
		attestationsDto.setAlertMessage("Attestation is Pending for new policy publish");
		Attestations policycreate = MapperUtils.mapToTargetClass(attestationsDto, Attestations.class);
		return this.attestationsRepo.save(policycreate);
	}

	@Override
	public Attestations updateAttestations(AttestationsDto attestationsDto) {
		Attestations policycreate = MapperUtils.mapToTargetClass(attestationsDto, Attestations.class);
		attestationsDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return this.attestationsRepo.save(policycreate);
	}

	@Override
	public Attestations getAttestationsById(long attestaionsId) {
		return attestationsRepo.findById(attestaionsId)
				.orElseThrow(() -> new ResourceNotFoundException("Attestaions not found with  Id----> " + attestaionsId));
	}

	@Override
	public List<Attestations> getAllAttestations() {
		return this.attestationsRepo.findAll();
	}

	@Override
	public List<Attestations> getAttestationsByPolicyId(String PolicyId) {
		return attestationsRepo.findByPolicyId(PolicyId);
	}

	@Override
	public Attestations deleteAttestations(AttestationsDto attestationsDto) {
		Attestations existingAttestations = getAttestationsById(attestationsDto.getAttestaionsId());
		return this.attestationsRepo.save(existingAttestations);
	}

}
