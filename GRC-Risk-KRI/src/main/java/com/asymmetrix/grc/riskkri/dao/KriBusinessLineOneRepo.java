package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriBusinessLineOneDD;

@Repository
public interface KriBusinessLineOneRepo extends JpaRepository<KriBusinessLineOneDD, String> {
	@Query("FROM  KriBusinessLineOneDD ORDER BY businessLineOneOrder ASC ")
	List<KriBusinessLineOneDD> findAllByOrder();
}
