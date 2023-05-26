package com.asymmetrix.grc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.RiskRegister;

@Repository
public interface RiskRegisterRepository extends JpaRepository<RiskRegister, String> {

	RiskRegister findByWsIdAndDeptId(String wsId, String deptId);
	
	RiskRegister findByRiskRegId(String riskRegId);
	
	@Query("FROM  RiskRegister WHERE wsId = :wsId AND deptId = :deptId ")
	RiskRegister findByWsIdAndDeptIdByBranch(@Param("wsId") String wsId, @Param("deptId") String deptId);

//	@Query("FROM  RiskRegister WHERE branchName = :branchName ")
//	List<RiskRegister> findAllByBranchName(@Param("branchName") String branchName );

	@Query("FROM  RiskRegister ORDER BY createdDate DESC ")
	List<RiskRegister> findAllByModifiedDate();
}
