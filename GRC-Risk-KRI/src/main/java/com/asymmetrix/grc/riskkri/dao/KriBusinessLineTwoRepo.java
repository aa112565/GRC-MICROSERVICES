package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriBusinessLineTwoDD;

@Repository
public interface KriBusinessLineTwoRepo extends JpaRepository<KriBusinessLineTwoDD, String> {
	@Query("FROM  KriBusinessLineTwoDD ORDER BY businessLineTwoOrder ASC ")
	List<KriBusinessLineTwoDD> findAllByOrder();
}
