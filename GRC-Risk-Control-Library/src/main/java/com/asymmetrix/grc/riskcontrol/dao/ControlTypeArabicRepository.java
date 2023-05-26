/**
 * 
 */
package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.riskcontrol.entity.ControlTypeArabic;

@Repository
public interface ControlTypeArabicRepository extends JpaRepository<ControlTypeArabic, String> {
	@Query("FROM  ControlTypeArabic ORDER BY controlTypeOrder ASC ")
	List<ControlTypeArabic> findAllByOrder();
}
