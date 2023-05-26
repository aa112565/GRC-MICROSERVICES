package com.asymmetrix.grc.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.PeriodicReviewDTO;
import com.asymmetrix.grc.Entity.PeriodicReview;
import com.asymmetrix.grc.Repository.PeriodicReviewRepo;
import com.asymmetrix.grc.Service.PeriodicReviewService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;

@Service
public class PeriodicReviewServiceImpl implements PeriodicReviewService {
	
	@Autowired
	PeriodicReviewRepo periodicReviewRepo;

	@Override
	public List<PeriodicReview> getAllPeriodicReview() {
		return this.periodicReviewRepo.findAllByOrder();
	}

	@Override
	public PeriodicReview createPeriodicReview(PeriodicReviewDTO createPolicyDto, String userName) {
		createPolicyDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
	//	createPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		createPolicyDto.setActiveFlag("Y");
		createPolicyDto.setDeleteFlag("N");
		PeriodicReview create = MapperUtils.mapToTargetClass(createPolicyDto, PeriodicReview.class);
		return this.periodicReviewRepo.save(create);
	}

	@Override
	public PeriodicReview updatePeriodicReview(PeriodicReviewDTO createPolicyDto) {
		createPolicyDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		createPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		createPolicyDto.setActiveFlag("Y");
		createPolicyDto.setDeleteFlag("N");
		PeriodicReview Update = MapperUtils.mapToTargetClass(createPolicyDto, PeriodicReview.class);
		return this.periodicReviewRepo.save(Update);
	}

	@Override
	public PeriodicReview getPeriodicReviewById(long periodicreviewId) {
		return periodicReviewRepo.findById(periodicreviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Policy not found with  Id----> " + periodicreviewId));
	}


	@Override
	public PeriodicReview deletePeriodicReview(PeriodicReviewDTO createPolicyDto) {
		PeriodicReview existingPolicy = getPeriodicReviewById(createPolicyDto.getPeriodicreviewId());
		existingPolicy.setActiveFlag("Y");
		existingPolicy.setDeleteFlag("D");
		return this.periodicReviewRepo.save(existingPolicy);
	}
	

	@Override
	public PeriodicReview approvePeriodicReview(PeriodicReviewDTO createPolicyDto) {
		createPolicyDto.setApprove("A");
		createPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		PeriodicReview policyApprove = MapperUtils.mapToTargetClass(createPolicyDto, PeriodicReview.class);
		return this.periodicReviewRepo.save(policyApprove);
	}

//	@Override
//	public PeriodicReview getPeriodicReviewByPolicyId(String policyId) {
//		return periodicReviewRepo.findPeriodicReviewByPolicyId(policyId);
//	}

}
