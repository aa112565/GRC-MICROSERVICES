package com.grc.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grc.email.entity.AlertAudit;

public interface AlertAuditRepository extends JpaRepository<AlertAudit, Long>{
	List<AlertAudit> findByAlertSrNo(Long alertSrno);
}
