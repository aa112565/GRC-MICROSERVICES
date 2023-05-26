package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriOtherDetailsDTO;
import com.asymmetrix.grc.riskkri.entity.KriOtherDetails;

public interface KriOtherDetailsService {
	
	List<KriOtherDetails> getKriOtherDetails();
	KriOtherDetails getKriOtherDetailById(long detailId);
	KriOtherDetails getKriOtherDetailByKriId(String kriId);
	KriOtherDetails createKriOtherDetail(KriOtherDetailsDTO otherdetailDto);
	KriOtherDetails updateKriOtherDetail(String kriId, KriOtherDetailsDTO otherdetailDto);
	KriOtherDetails deleteKriOtherDetail(KriOtherDetailsDTO otherdetailDto);
	String getKriFrequencyByKriId(String kriId);

}
