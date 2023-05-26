package com.asymmetrix.grc.riskkri.service;

import java.util.List;

import com.asymmetrix.grc.riskkri.dto.KriFormulaDTO;
import com.asymmetrix.grc.riskkri.entity.KriFormula;

public interface KriFormulaService {
	
	List<KriFormula> getKriFormula();
	KriFormula getKriFormulaId(long formId);
	KriFormula getKriFormulaByKriId(String kriId);
	KriFormula createKriFormula(KriFormulaDTO kriFormulaDto);
	KriFormula updateKriFormula(String kriId, KriFormulaDTO kriFormulaDto);
	KriFormula deleteKriFormula(KriFormulaDTO kriFormulaDto);

}
