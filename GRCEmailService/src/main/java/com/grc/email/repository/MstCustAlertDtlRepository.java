package com.grc.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.email.entity.MstCustAlertDtl;

@Repository
public interface MstCustAlertDtlRepository extends JpaRepository<MstCustAlertDtl, Long>{
	List<MstCustAlertDtl> findByAssignedUserId(String userid);
	List<MstCustAlertDtl> findByStatusAndActionAndStageOrderByBranchId(String status, String action, String stage);
	List<MstCustAlertDtl> findByPageAndStage(String page, String stage);
	List<MstCustAlertDtl> findByPageAndClosureStatus(String page, Character closureStatus);
	List<MstCustAlertDtl> findByPageAndStageAndStatus(String page, String stage, String status);
	List<MstCustAlertDtl> findByPageAndStageAndClosureStatus(String page, String stage, Character closureStatus);
	List<MstCustAlertDtl> findByPageAndStageAndStatusAndAction(String page, String stage, String status, String action);
}
