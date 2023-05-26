package com.grc.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.email.entity.CnfgStatusAction;

@Repository
public interface CnfgStatusActionRepository extends JpaRepository<CnfgStatusAction, Integer> {

	List<CnfgStatusAction> findByLevel(String level);
	CnfgStatusAction findByLevelAndStatusAndAction(String level, String status, String action);

}
