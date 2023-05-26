package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.NatureOfKriDD;

@Repository
public interface NatureOfKriRepository extends JpaRepository<NatureOfKriDD, String> {
	@Query("FROM  NatureOfKriDD ORDER BY kriNatureOrder ASC ")
	List<NatureOfKriDD> findAllByOrder();
}
