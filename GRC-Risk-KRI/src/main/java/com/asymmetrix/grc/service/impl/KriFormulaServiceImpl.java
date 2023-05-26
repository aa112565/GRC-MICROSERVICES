package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.riskkri.dao.KriFormulaRepo;
import com.asymmetrix.grc.riskkri.dto.KriFormulaDTO;
import com.asymmetrix.grc.riskkri.entity.KriFormula;
import com.asymmetrix.grc.riskkri.exception.ResourceNotFoundException;
import com.asymmetrix.grc.riskkri.service.KriFormulaService;

@Service
public class KriFormulaServiceImpl implements KriFormulaService{

	@Autowired
	private KriFormulaRepo formulaRepo;

	@Override
	public List<KriFormula> getKriFormula() {
		return this.formulaRepo.findAll();
	}

	@Override
	public KriFormula getKriFormulaId(long formId) {
		return formulaRepo.findById(formId)
				.orElseThrow(() -> new ResourceNotFoundException("Kri-Formula not found with  Id----> " + formId));
	}

	@Override
	public KriFormula getKriFormulaByKriId(String kriId) {
		return formulaRepo.findByKriId(kriId);
	}

	@Override
	public KriFormula createKriFormula(KriFormulaDTO kriFormulaDto) {
		KriFormula kriformula = MapperUtils.mapToTargetClass(kriFormulaDto, KriFormula.class);
		kriformula.setActiveFlag("Y");
		kriformula.setDeleteFlag("N");
		return formulaRepo.save(kriformula);
	}

	@Override
	public KriFormula updateKriFormula(String kriId, KriFormulaDTO kriFormulaDto) {
		@SuppressWarnings("unused")
		KriFormula existingkriformula = deleteUpdate(getKriFormulaByKriId(kriId));
		return createKriFormula(kriFormulaDto);
	}

//  Kri-Formula - Soft Delete
	public KriFormula deleteUpdate(KriFormula kriFormulaTemp) {
		KriFormula existingkriformula = getKriFormulaId(kriFormulaTemp.getFormId());
		existingkriformula.setActiveFlag("N");
		existingkriformula.setDeleteFlag("D");
		return this.formulaRepo.save(existingkriformula);
	}

	@Override
	public KriFormula deleteKriFormula(KriFormulaDTO kriFormulaDto) {
		KriFormula kriformula = MapperUtils.mapToTargetClass(kriFormulaDto, KriFormula.class);
		kriformula.setActiveFlag("N");
		kriformula.setDeleteFlag("D");
		return this.formulaRepo.save(kriformula);
	}

}
