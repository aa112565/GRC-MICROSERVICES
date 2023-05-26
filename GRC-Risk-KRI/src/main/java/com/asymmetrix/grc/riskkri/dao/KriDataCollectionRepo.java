package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriDataCollectionDD;

@Repository
public interface KriDataCollectionRepo extends JpaRepository<KriDataCollectionDD, String> {
	@Query("FROM  KriDataCollectionDD ORDER BY dataCollectionOrder ASC ")
	List<KriDataCollectionDD> findAllByOrder();
}
