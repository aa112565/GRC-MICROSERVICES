package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.riskcontrol.entity.ControlCategoryArabic;

@Repository
public interface ControlCategoryArabicRepository extends JpaRepository<ControlCategoryArabic, String> {
	@Query("FROM  ControlCategoryArabic ORDER BY controlCategoryOrder ASC ")
	List<ControlCategoryArabic> findAllByOrder();
}
