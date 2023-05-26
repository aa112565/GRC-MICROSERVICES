package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetClassificationDD;
//import com.asymmetrix.bia.entity.BiaSourceDD;

@Repository
public interface AssetClassificationRepo extends JpaRepository<AssetClassificationDD, String> {

}
