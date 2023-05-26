package com.asymmetrix.grc.risk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.risk.entity.RiskAppetite;


@Repository
public interface RiskAppetiteRepository extends JpaRepository<RiskAppetite, Long> {

	@Query("SELECT COUNT(*) FROM  RiskAppetite WHERE appetiteId = :appetiteId ")
	int findByConut(@Param("appetiteId") long appetiteId);

	@Query("FROM  RiskAppetite WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<RiskAppetite> findAllAppetite();

	RiskAppetite findFirstByOrderByCreatedDateDescAppetiteIdDesc();
}
