package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.MstOrgWeightage;

@Repository
public interface OrgWeightageRepository extends JpaRepository<MstOrgWeightage, Long> {
	
	
}
