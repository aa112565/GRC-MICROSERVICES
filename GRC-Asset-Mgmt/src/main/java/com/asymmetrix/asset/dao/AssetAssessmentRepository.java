package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.asset.entity.CMAssetAssessment;

@Repository
public interface AssetAssessmentRepository extends JpaRepository<CMAssetAssessment, Long> {

	@Query("FROM  CMAssetAssessment WHERE deleteFlag = 'N' ORDER BY createdDate ASC ")
	List<CMAssetAssessment> findAllAssessment();

	@Query("FROM  CMAssetAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY createdDate ASC ")
	List<CMAssetAssessment> findAllByActiveflag();

	@Query("FROM  CMAssetAssessment WHERE assetDetails = :assetDetails AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	CMAssetAssessment findByAssetId(@Param("assetDetails") String assetDetails);

	@Query("FROM  CMAssetAssessment WHERE status = :status AND deleteFlag = 'N' AND activeFlag = 'Y' ")
	List<CMAssetAssessment> findAllByAssessmentStatus(@Param("status") String status);

	@Query("SELECT COUNT(*) FROM  CMAssetAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND status = 'Initiated' ")
	int findCountByInitated();

	@Query("SELECT COUNT(*) FROM  CMAssetAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND status = 'Inprogress' ")
	int findCountByInprogress();

	@Query("SELECT COUNT(*) FROM  CMAssetAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' AND status = 'Completed' ")
	int findCountByCompleted();

	@Query("SELECT COUNT(*) FROM  CMAssetAssessment WHERE deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findTotalCount();

}
