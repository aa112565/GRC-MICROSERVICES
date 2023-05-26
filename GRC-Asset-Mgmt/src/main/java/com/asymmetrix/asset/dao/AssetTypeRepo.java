package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetTypeDD;

@Repository
public interface AssetTypeRepo extends JpaRepository<AssetTypeDD, String> {

}
