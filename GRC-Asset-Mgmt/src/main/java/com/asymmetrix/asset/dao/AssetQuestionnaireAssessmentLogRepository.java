package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetQuestionnaireAssessmentLog;

@Repository
public interface AssetQuestionnaireAssessmentLogRepository
		extends JpaRepository<AssetQuestionnaireAssessmentLog, Long> {

}
