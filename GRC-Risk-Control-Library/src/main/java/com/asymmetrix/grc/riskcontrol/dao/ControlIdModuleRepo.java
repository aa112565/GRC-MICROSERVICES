package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.riskcontrol.entity.ControlIdPreferenceDD;


@Repository
public interface ControlIdModuleRepo extends JpaRepository<ControlIdPreferenceDD, String> {
	@Query("FROM  ControlIdPreferenceDD ORDER BY moduleOrder ASC ")
	List<ControlIdPreferenceDD> findAllByOrder();
}
