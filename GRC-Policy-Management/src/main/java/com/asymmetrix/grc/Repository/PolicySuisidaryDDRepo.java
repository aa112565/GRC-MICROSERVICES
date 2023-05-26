package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.PolicySuisidary;

@Repository
public interface PolicySuisidaryDDRepo extends JpaRepository<PolicySuisidary, String> {

}
