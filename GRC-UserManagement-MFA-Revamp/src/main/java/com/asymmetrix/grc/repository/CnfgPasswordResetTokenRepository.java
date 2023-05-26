package com.asymmetrix.grc.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.CnfgPasswordResetToken;

@Repository
public interface CnfgPasswordResetTokenRepository extends JpaRepository<CnfgPasswordResetToken, String> {

  @Transactional
  @Modifying
  @Query("delete from CnfgPasswordResetToken cnfgPasswordResetToken where cnfgPasswordResetToken.cnfgUser.userId = :userId")
  void deleteByUserId(@Param("userId") String userId);
  
  @Query("SELECT c FROM CnfgPasswordResetToken c WHERE c.cnfgUser.userId = :userId")
  public CnfgPasswordResetToken findByUserId(@Param("userId") String userId);

}
