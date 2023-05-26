package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.PeriodicReviewDTO;
import com.asymmetrix.grc.Entity.PeriodicReview;

public interface PeriodicReviewService {
	
	public List<PeriodicReview> getAllPeriodicReview();
	public PeriodicReview createPeriodicReview(PeriodicReviewDTO createPolicyDto, String userName);
	public PeriodicReview updatePeriodicReview(PeriodicReviewDTO createPolicyDto);
	public PeriodicReview getPeriodicReviewById(long periodicreviewId);
	public PeriodicReview deletePeriodicReview(PeriodicReviewDTO createPolicyDto);
	public PeriodicReview approvePeriodicReview(PeriodicReviewDTO createPolicyDto);
//	PeriodicReview getPeriodicReviewByPolicyId(String policyId);

}
