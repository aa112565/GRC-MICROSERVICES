package com.asymmetrix.grc.Service;

import java.util.List;

import com.asymmetrix.grc.Dto.CollabratorDto;
import com.asymmetrix.grc.Entity.Collabrator;


public interface CollabratorService {
	
	public List<Collabrator> getAllcollabrator();
	public Collabrator createCollabrator(CollabratorDto cDto);
	public Collabrator updateCollabrator(CollabratorDto cDto);
	public Collabrator getCollabratorById(long collabratorId);
	public Collabrator deleteCollabrator(CollabratorDto cDto);
	public Collabrator approveCollabrator(CollabratorDto cDto);
	public Collabrator rejectCollabrator(CollabratorDto cDto);
	
//	public List<Collabrator> getAllPolicyId();
	
	public List<Collabrator> getCollabratorByPolicyId(String PolicyId);

}
