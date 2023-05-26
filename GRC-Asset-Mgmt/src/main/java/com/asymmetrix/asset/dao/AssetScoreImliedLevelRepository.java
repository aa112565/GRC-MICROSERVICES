package com.asymmetrix.asset.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.asset.entity.AssetScoreImpliedLevel;

@Repository
public interface AssetScoreImliedLevelRepository extends JpaRepository<AssetScoreImpliedLevel, String> {

	@Query("FROM  AssetScoreImpliedLevel WHERE impliedScore = :impliedScore ")
	AssetScoreImpliedLevel findByImpliedScore(@Param("impliedScore") String impliedScore);

}
