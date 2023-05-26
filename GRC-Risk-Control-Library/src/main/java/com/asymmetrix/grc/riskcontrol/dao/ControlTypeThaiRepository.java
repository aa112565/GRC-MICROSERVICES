/**
 * 
 */
package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.asymmetrix.grc.riskcontrol.entity.ControlTypeThai;

@Repository
public interface ControlTypeThaiRepository extends JpaRepository<ControlTypeThai, String> {
	@Query("FROM  ControlTypeThai ORDER BY controlTypeOrder ASC ")
	List<ControlTypeThai> findAllByOrder();
}
