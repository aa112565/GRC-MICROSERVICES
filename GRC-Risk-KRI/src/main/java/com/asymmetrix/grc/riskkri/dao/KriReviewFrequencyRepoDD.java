package com.asymmetrix.grc.riskkri.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.riskkri.entity.KriReviewFrequencyDD;

@Repository
public interface KriReviewFrequencyRepoDD extends JpaRepository<KriReviewFrequencyDD, String> {
	@Query("FROM  KriReviewFrequencyDD ORDER BY frequencyOrder ASC ")
	List<KriReviewFrequencyDD> findAllByOrder();
}
