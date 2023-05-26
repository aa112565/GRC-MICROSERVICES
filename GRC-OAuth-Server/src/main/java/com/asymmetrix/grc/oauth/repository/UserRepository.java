package com.asymmetrix.grc.oauth.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.oauth.entity.CnfgUser;

@Repository
public interface UserRepository extends JpaRepository<CnfgUser, String> {

	@Transactional
	@Modifying
	@Query("UPDATE CnfgUser c set c.failedAttempt = c.failedAttempt + 1 WHERE c.userId = :userId")
	public void incrementFailedAttempt(@Param("userId") String userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE CnfgUser c set c.lastLogin = :lastLogin WHERE c.userId = :userId")
	public void updateLastLogin(@Param("lastLogin") Date lastLogin, @Param("userId") String userId);

	@Query("SELECT c.userId  from CnfgUser c WHERE c.managerId = :managerId")
	public List<String> getAllUserByManagerId(@Param("managerId") String managerId); 
	
}
