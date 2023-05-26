package com.asymmetrix.grc.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;



import javax.annotation.Resource;
import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.ReviewPolicyDto;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.ReviewPolicy;
import com.asymmetrix.grc.Repository.CreatePolicyRepo;
import com.asymmetrix.grc.Repository.ReviewPolicyRepo;
import com.asymmetrix.grc.Service.ReviewPolicyService;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.exception.ResourceNotFoundException;

@Service
public class ReviewPolicyServiceImpl implements ReviewPolicyService {
	
	@Resource
	ReviewPolicyRepo reviewPolicyRepo;
	
	@Autowired
	private CreatePolicyRepo createPolicyRepo;

	@Override
	public List<ReviewPolicy> getAllReview() {
		return this.reviewPolicyRepo.findAll();
	}

	
	@Override
	public ReviewPolicy createReview(ReviewPolicyDto reviewPolicyDto ) {
		reviewPolicyRepo.updatereviewToInactive(reviewPolicyDto.getPolicyId());
	ReviewPolicy Collaborate = MapperUtils.mapToTargetClass(reviewPolicyDto, ReviewPolicy.class);
		return this.reviewPolicyRepo.save(Collaborate);

	}

	@Override
	public ReviewPolicy updateReview(ReviewPolicyDto reviewPolicyDto) {
		reviewPolicyRepo.updatereviewToInactive(reviewPolicyDto.getPolicyId());
		ReviewPolicy Collaborate = MapperUtils.mapToTargetClass(reviewPolicyDto, ReviewPolicy.class);
		reviewPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return this.reviewPolicyRepo.save(Collaborate);
	}

	@Override
	public ReviewPolicy getReviewById(long reviewId) {
		return reviewPolicyRepo.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review Id not found with  Id----> " + reviewId));
	}

	@Override
	public ReviewPolicy deleteReview(ReviewPolicyDto reviewPolicyDto) {
		ReviewPolicy existingPolicyReview = getReviewById(reviewPolicyDto.getReviewId());
		return this.reviewPolicyRepo.save(existingPolicyReview);
	}
	

	@Override
	public ReviewPolicy getReviewByPolicyId(long PolicyId) {
		return reviewPolicyRepo.findByPolicyId(PolicyId);
	}

	@Override
	public ReviewPolicy Reject(ReviewPolicyDto reviewPolicyDto , CreatePolicyDto createPolicyDto ) {
		ReviewPolicy Collaborate = MapperUtils.mapToTargetClass(reviewPolicyDto, ReviewPolicy.class);
		reviewPolicyRepo.updateReject(reviewPolicyDto.getPolicyId());
		reviewPolicyRepo.updateRejectinReview(reviewPolicyDto.getPolicyId());
		reviewPolicyRepo.updateRejectinCollabrate(reviewPolicyDto.getPolicyId());
		reviewPolicyRepo.updateReject(createPolicyDto.getPolicyId());
		reviewPolicyRepo.updateRejectinReview(createPolicyDto.getPolicyId());
		reviewPolicyRepo.updateRejectinCollabrate(createPolicyDto.getPolicyId());
		reviewPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		return this.reviewPolicyRepo.save(Collaborate);
	}

	@Override
	public List<CreatePolicy> getAllPolicy() {
		return this.reviewPolicyRepo.findAllPolicy();
	}


	@Override
	public ReviewPolicy createApprove(ReviewPolicyDto reviewPolicyDto, CreatePolicyDto createPolicyDto) {
		reviewPolicyRepo.updateApprove(reviewPolicyDto.getPolicyId());
		reviewPolicyRepo.updateReview(reviewPolicyDto.getPolicyId());
	reviewPolicyDto.setPolicyApprove("AA");
//		createPolicyDto.setPolicyApprove("AA");
//	reviewPolicyRepo.updatepublishAttestationToactive(reviewPolicyDto.getPolicyId());
//	createPolicyDto.setPublishAttestation("P");
		reviewPolicyRepo.updateApprove(reviewPolicyDto.getPolicyId());
		reviewPolicyDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		ReviewPolicy app = MapperUtils.mapToTargetClass(reviewPolicyDto, ReviewPolicy.class);
			return this.reviewPolicyRepo.save(app);
	}


	@Override
	public int getPolicyAgeing() {
		return this.reviewPolicyRepo.getPolicyAgeing();
	}


	

	
}
