package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetScoreCurrencyDD;

@Repository
public interface AssetScoreCurrencyRepoDD extends JpaRepository<AssetScoreCurrencyDD, String> {

}
