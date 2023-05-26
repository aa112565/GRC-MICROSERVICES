package com.grc.email.common.aspect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grc.email.common.aspect.entity.AuditLog;

@Repository
public interface AuditLogDao extends JpaRepository<AuditLog, Long> {


}
