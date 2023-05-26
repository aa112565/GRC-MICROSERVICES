package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetIndustryDD;

@Repository
public interface AssetIndustryRepo extends JpaRepository<AssetIndustryDD, String> {

}
