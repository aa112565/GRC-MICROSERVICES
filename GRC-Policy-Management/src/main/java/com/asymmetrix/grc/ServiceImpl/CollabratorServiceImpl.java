package com.asymmetrix.grc.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.CollabratorDto;
import com.asymmetrix.grc.Entity.Collabrator;

import com.asymmetrix.grc.Repository.CollabratorRepo;
import com.asymmetrix.grc.Service.CollabratorService;
import com.asymmetrix.grc.Service.PolicyIdPreferenceService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;

@Service
public class CollabratorServiceImpl implements CollabratorService {
	
	@Autowired
	CollabratorRepo collabratorRepo;
	
//	@Autowired
//    private PolicyIdPreferenceService idPreference;

	@Override
	public List<Collabrator> getAllcollabrator() {
		return this.collabratorRepo.findAllByActiveflag();
	}
	
//	@Override
//	public List<Collabrator> getAllPolicyId() {
//		return this.collabratorRepo.findAllByPolicyId();
//	}
	
	

	@Override
	public Collabrator createCollabrator(CollabratorDto cDto) {
		cDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		cDto.setActiveFlag("Y");
		cDto.setDeleteFlag("N");
		cDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Collabrator policyUpdate = MapperUtils.mapToTargetClass(cDto, Collabrator.class);
		return this.collabratorRepo.save(policyUpdate);
	}

	@Override
	public Collabrator updateCollabrator(CollabratorDto cDto) {
		cDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		cDto.setActiveFlag("Y");
		cDto.setDeleteFlag("N");
		cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Collabrator collab = MapperUtils.mapToTargetClass(cDto, Collabrator.class);
		return this.collabratorRepo.save(collab);
	}

	@Override
	public Collabrator getCollabratorById(long collabratorId) {
		return collabratorRepo.findById(collabratorId)
				.orElseThrow(() -> new ResourceNotFoundException("collabratorId not found with  Id----> " + collabratorId));
	}

	@Override
	public Collabrator deleteCollabrator(CollabratorDto cDto) {
		Collabrator existingPolicyCollaborate = getCollabratorById(cDto.getCollabratorId());
		return this.collabratorRepo.save(existingPolicyCollaborate);
	}

	@Override
	public Collabrator approveCollabrator(CollabratorDto cDto) {
		cDto.setApprove("A");
		Collabrator Approve = MapperUtils.mapToTargetClass(cDto, Collabrator.class);
		cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return this.collabratorRepo.save(Approve);
	}

	@Override
	public Collabrator rejectCollabrator(CollabratorDto cDto) {
		cDto.setReject("R");
		Collabrator Approve = MapperUtils.mapToTargetClass(cDto, Collabrator.class);
		cDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return this.collabratorRepo.save(Approve);
	}

	@Override
	public List<Collabrator> getCollabratorByPolicyId(String PolicyId) {
		return collabratorRepo.findByPolicyId(PolicyId);
	}

	

	

}
