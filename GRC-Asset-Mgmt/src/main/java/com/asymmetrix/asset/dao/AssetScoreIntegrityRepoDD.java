package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asymmetrix.asset.entity.AssetScoreIntegrityDD;

public interface AssetScoreIntegrityRepoDD extends JpaRepository<AssetScoreIntegrityDD, String> {

}
