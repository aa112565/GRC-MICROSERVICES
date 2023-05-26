package com.asymmetrix.grc.riskcontrol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskcontrol.entity.ControlLibraryLog;

@Repository
public interface ControlLibraryLogRepository extends JpaRepository<ControlLibraryLog, String> {

}
