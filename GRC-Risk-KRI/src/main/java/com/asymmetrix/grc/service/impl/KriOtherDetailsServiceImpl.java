package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriOtherDetailsRepo;
import com.asymmetrix.grc.riskkri.dto.KriOtherDetailsDTO;
import com.asymmetrix.grc.riskkri.entity.KriOtherDetails;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriOtherDetailsService;

@Service
public class KriOtherDetailsServiceImpl implements KriOtherDetailsService{

	@Autowired
	private KriOtherDetailsRepo detailsRepo;

	@Override
	public List<KriOtherDetails> getKriOtherDetails() {
		return this.detailsRepo.findAll();
	}

	@Override
	public KriOtherDetails getKriOtherDetailById(long detailId) {
		return detailsRepo.findById(detailId).orElseThrow(
				() -> new ResourceNotFoundException("Kri-Other Detail not found with  Id----> " + detailId));
	}

	@Override
	public KriOtherDetails getKriOtherDetailByKriId(String kriId) {
		return detailsRepo.findByKriId(kriId);
	}

	@Override
	public KriOtherDetails createKriOtherDetail(KriOtherDetailsDTO otherdetailDto) {
		KriOtherDetails kriformula = MapperUtils.mapToTargetClass(otherdetailDto, KriOtherDetails.class);
		kriformula.setDeleteFlag("N");
		kriformula.setActiveFlag("Y");
		return detailsRepo.save(kriformula);
	}

	@Transactional
	@Modifying
	@Override
	public KriOtherDetails updateKriOtherDetail(String kriId, KriOtherDetailsDTO otherdetailDto) {
		/*
		 * KriOtherDetails kridetail = MapperUtils.mapToTargetClass(otherdetailDto,
		 * KriOtherDetails.class);
		 * 
		 * KriOtherDetails existingkridetail
		 * =getKriOtherDetailById(kridetail.getDetailId());
		 * 
		 * @SuppressWarnings("unused") KriOtherDetails otherdetailExisting =
		 * deleteUpdate(existingkridetail);
		 * 
		 * KriOtherDetailsDTO otherDetailCreate = new KriOtherDetailsDTO();
		 * otherDetailCreate.setStartDate(otherdetailDto.getStartDate());
		 * otherDetailCreate.setReviewFrequency(otherdetailDto.getReviewFrequency());
		 * otherDetailCreate.setUploadFileName(otherdetailDto.getUploadFileName());
		 * otherDetailCreate.setUploadFile(otherdetailDto.getUploadFile());
		 * otherDetailCreate.setKriId(otherdetailDto.getKriId());
		 * 
		 * KriOtherDetails otherdetailNew = createKriOtherDetail(otherDetailCreate);
		 */
		@SuppressWarnings("unused")
		KriOtherDetails otherdetail = deleteUpdate(getKriOtherDetailByKriId(kriId));
		return createKriOtherDetail(otherdetailDto);
	}

//  Kri-Other-Details - Soft Delete
	public KriOtherDetails deleteUpdate(KriOtherDetails otherdetail) {
		KriOtherDetails existingkridetail = getKriOtherDetailById(otherdetail.getDetailId());
		existingkridetail.setActiveFlag("N");
		existingkridetail.setDeleteFlag("D");
		return this.detailsRepo.save(existingkridetail);
	}

	@Override
	public KriOtherDetails deleteKriOtherDetail(KriOtherDetailsDTO otherdetailDto) {
		KriOtherDetails kridetail = MapperUtils.mapToTargetClass(otherdetailDto, KriOtherDetails.class);
		kridetail.setActiveFlag("N");
		kridetail.setDeleteFlag("D");
		return this.detailsRepo.save(kridetail);
	}

	@Override
	public String getKriFrequencyByKriId(String kriId) {
		return detailsRepo.getKriFrequencyByKriId(kriId);
	}

}
