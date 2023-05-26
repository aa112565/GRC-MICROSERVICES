package com.asymmetrix.grc.riskkri.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.RiskKriLog;

@Repository
public interface RiskKriLogRepository extends JpaRepository<RiskKriLog, Long> {

}
