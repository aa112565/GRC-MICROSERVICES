package com.asymmetrix.grc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.LikelihoodRiskRating;

@Repository
public interface LikelihoodRiskRatingRepository extends JpaRepository<LikelihoodRiskRating, Long> {

	List<LikelihoodRiskRating> findByLikeLihoodRatingScoreValLessThanEqual(String score);

	LikelihoodRiskRating findByLikeLihoodRating(String trim);
		
	@Query("FROM LikelihoodRiskRating as l ORDER BY l.likeLihoodRatingScoreVal ASC")
	List<LikelihoodRiskRating> findLikeLihoodRatingAsc();
}
