package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetCategoryDD;

@Repository
public interface AssetCategoryRepo extends JpaRepository<AssetCategoryDD, String> {

}
