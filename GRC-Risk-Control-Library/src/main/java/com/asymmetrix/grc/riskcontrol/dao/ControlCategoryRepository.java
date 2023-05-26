package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskcontrol.entity.ControlCategory;


@Repository
public interface ControlCategoryRepository extends JpaRepository<ControlCategory, String> {
	@Query("FROM  ControlCategory ORDER BY controlCategoryOrder ASC ")
	List<ControlCategory> findAllByOrder();
}
