/**
 * 
 */
package com.asymmetrix.grc.riskcontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskcontrol.entity.ControlType;


@Repository
public interface ControlTypeRepository extends JpaRepository<ControlType, String> {
	@Query("FROM  ControlType ORDER BY controlTypeOrder ASC ")
	List<ControlType> findAllByOrder();
}
