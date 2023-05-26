package com.asymmetrix.grc.riskkri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriFormula;

@Repository
public interface KriFormulaRepo extends JpaRepository<KriFormula, Long> {

	@Query("FROM  KriFormula WHERE kriId = :kriId AND deleteFlag = 'N'  AND activeFlag = 'Y' ")
	KriFormula findByKriId(String kriId);

}
