package com.asymmetrix.grc.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.CnfgOTP;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CnfgOTPRepository extends JpaRepository<CnfgOTP, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE CnfgOTP c set c.failedAttempt = c.failedAttempt + 1 WHERE c.cnfgUser.userId = :userId")
	void incrementFailedAttemptByUserIdAndOtp(@Param("userId") final String userId);

	@Query("SELECT c FROM CnfgOTP c WHERE c.otp = :otp and c.cnfgUser.userId = :userId")
	Optional<CnfgOTP> findByOtpAndUserId(@Param("otp") final int otp, @Param("userId") final String userId);

	@Query("SELECT c FROM CnfgOTP c WHERE c.cnfgUser.userId = :userId")
	Optional<CnfgOTP> findByUserId(@Param("userId") final String userId);

	@Modifying
	@Query("DELETE CnfgOTP c WHERE c.otp = :otp and c.cnfgUser.userId = :userId")
	void deleteByOtpAndUserId(@Param("otp") final int otp, @Param("userId") final String userId);

	@Transactional
	@Modifying
	@Query("DELETE CnfgOTP c WHERE c.cnfgUser.userId = :userId")
	void deleteByUserId(@Param("userId") final String userId);
}