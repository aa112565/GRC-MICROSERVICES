package com.asymmetrix.asset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.asymmetrix.asset.entity.GlNumberDD;

public interface GlNumberRepo extends JpaRepository<GlNumberDD, String> {

	@Query("FROM  GlNumberDD ORDER BY gLNumberDesc ASC ")
	List<GlNumberDD> findAllByOrder();
}
