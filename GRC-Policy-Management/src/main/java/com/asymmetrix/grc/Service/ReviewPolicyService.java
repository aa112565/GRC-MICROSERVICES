package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.CreatePolicyDto;
import com.asymmetrix.grc.Dto.ReviewPolicyDto;
import com.asymmetrix.grc.Entity.CreatePolicy;
import com.asymmetrix.grc.Entity.ReviewPolicy;


public interface ReviewPolicyService {
	
	public List<ReviewPolicy> getAllReview();
	public ReviewPolicy createReview(ReviewPolicyDto reviewPolicyDto);
	public ReviewPolicy updateReview(ReviewPolicyDto reviewPolicyDto);
	public ReviewPolicy getReviewById(long reviewId);
	public ReviewPolicy deleteReview(ReviewPolicyDto reviewPolicyDto);
	public ReviewPolicy getReviewByPolicyId(long PolicyId);
	public List<CreatePolicy> getAllPolicy();
	
	public ReviewPolicy createApprove(ReviewPolicyDto reviewPolicyDto, CreatePolicyDto createPolicyDto);
//	public ReviewPolicyDto createWorskhopMOM(ReviewPolicyDto riskWorkshopMomDTO);
	
	public ReviewPolicy Reject(ReviewPolicyDto reviewPolicyDto,CreatePolicyDto createPolicyDto );

	int getPolicyAgeing();
}
