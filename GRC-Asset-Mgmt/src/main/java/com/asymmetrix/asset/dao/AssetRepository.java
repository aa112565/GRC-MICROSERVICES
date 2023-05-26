package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.CMAsset;
//import com.asymmetrix.bia.entity.BcmBia;

@Repository
public interface AssetRepository extends JpaRepository<CMAsset, Long> {

	@Query("FROM  CMAsset WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<CMAsset> findAllAsset();

	@Query("FROM  CMAsset WHERE deleteFlag = 'N' AND activeFlag = 'Y' ORDER BY modifiedDate DESC ")
	List<CMAsset> findAllByActiveflag();

	@Query("SELECT COUNT(*) FROM  CMAsset WHERE deleteFlag = 'N' AND activeFlag = 'Y' ")
	int findCountByActiveflag();

}
