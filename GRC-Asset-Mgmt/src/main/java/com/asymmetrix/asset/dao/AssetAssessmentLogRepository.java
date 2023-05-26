package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetAssessmentLog;

//import com.asymmetrix.bia.entity.BcmBiaLog;

@Repository
public interface AssetAssessmentLogRepository extends JpaRepository<AssetAssessmentLog, Long> {

}
