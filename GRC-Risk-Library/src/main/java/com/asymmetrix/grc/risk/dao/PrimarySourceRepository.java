/**
 * 
 */
package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.PrimaryReasonSourceDD;



@Repository
public interface PrimarySourceRepository extends JpaRepository<PrimaryReasonSourceDD, String> {
	
	@Query("FROM  PrimaryReasonSourceDD ORDER BY primarySourceOrder ASC ")
	List<PrimaryReasonSourceDD> findAllByOrder();
}
