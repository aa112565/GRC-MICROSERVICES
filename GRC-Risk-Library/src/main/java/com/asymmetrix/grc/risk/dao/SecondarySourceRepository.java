/**
 * 
 */
package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.risk.entity.SecondaryReasonSource;

@Repository
public interface SecondarySourceRepository extends JpaRepository<SecondaryReasonSource, String> {
	@Query("FROM  SecondaryReasonSource ORDER BY secondarySourceOrder ASC ")
	List<SecondaryReasonSource> findAllByOrder();
}
