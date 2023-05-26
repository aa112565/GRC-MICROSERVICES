package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriLocationDD;

@Repository
public interface KriLocationRepo extends JpaRepository<KriLocationDD, String> {
	@Query("FROM  KriLocationDD ORDER BY locationOrder ASC ")
	List<KriLocationDD> findAllByOrder();
}
