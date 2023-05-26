package com.grc.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.email.entity.CnfgUser;

@Repository
public interface CnfgUserRepository extends JpaRepository<CnfgUser, Integer> {

	List<CnfgUser> findByBranchCodeAndUserLevel(String branchId, String employeeLevel);
	CnfgUser findByUserId(String userId);
	List<CnfgUser> findByUserIdIn(List<String> userId);

}
