package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriCasueCategoryDD;

@Repository
public interface KriCasueCategoryRepo extends JpaRepository<KriCasueCategoryDD, String> {
	@Query("FROM  KriCasueCategoryDD ORDER BY causeCategoryOrder ASC ")
	List<KriCasueCategoryDD> findAllByOrder();
}
