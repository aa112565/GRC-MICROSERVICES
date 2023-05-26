package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriIdPreferenceDD;


@Repository
public interface KriIdModuleRepo extends JpaRepository<KriIdPreferenceDD, String> {
	@Query("FROM  KriIdPreferenceDD ORDER BY moduleOrder ASC ")
	List<KriIdPreferenceDD> findAllByOrder();
}
