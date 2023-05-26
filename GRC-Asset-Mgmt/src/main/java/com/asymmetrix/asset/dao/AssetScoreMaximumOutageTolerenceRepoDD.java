package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asymmetrix.asset.entity.AssetScoreMaximumOutageToleranceDD;

public interface AssetScoreMaximumOutageTolerenceRepoDD
		extends JpaRepository<AssetScoreMaximumOutageToleranceDD, String> {

}
