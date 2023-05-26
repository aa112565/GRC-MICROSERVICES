package com.grc.threat.risk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.grc.threat.risk.entity.ThreatLibraryLog;

@Repository
public interface ThreatLibraryLogRepository extends JpaRepository<ThreatLibraryLog, String> {

}
