package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.CMAssetQuestionnaireCategoryAssessmentLog;

@Repository
public interface AssetQuestionnaireCategoryAssessmentLogRepository
		extends JpaRepository<CMAssetQuestionnaireCategoryAssessmentLog, String> {

}
