package com.asymmetrix.grc.risk.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.risk.entity.RiskAppetiteLog;


@Repository
public interface RiskAppetiteLogRepository extends JpaRepository<RiskAppetiteLog, String> {

	
}
