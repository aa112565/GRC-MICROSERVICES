package com.asymmetrix.grc.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.entity.CnfgUser;

@Repository
public interface UserRepository extends JpaRepository<CnfgUser, String> {


  @Override
  @Query("Select new CnfgUser(usr.userId, usr.userName, usr.userNameFirst, usr.userNameLast, usr.email, usr.organizationCode, usr.organizationName, usr.departmentCode, usr.department, usr.departmentType, usr.accountActive,  usr.accountDeleted, usr.primaryBranchCode, usr.branchCode, usr.branchName, usr.phoneNumber, usr.grade, usr.createdDate, usr.modifiedDate, usr.lastLogin, usr.managerId, usr.userLevel, grp.landingPage, usr.cnfgUserGroup) FROM CnfgUser usr left join usr.cnfgUserGroup grp WHERE UPPER(usr.accountDeleted) = 'N'")
  public List<CnfgUser> findAll();
  
/*
  @Override
  @Query("Select new CnfgUser(usr.userId, usr.userName, usr.email, usr.department, usr.departmentType, usr.accountActive,  usr.accountDeleted, usr.primaryBranchCode, usr.branchCode, usr.branchName, usr.phoneNumber, usr.grade, usr.createdDate, usr.modifiedDate, usr.lastLogin, usr.managerId, usr.userLevel, grp.landingPage, usr.cnfgUserGroup) FROM CnfgUser usr left join usr.cnfgUserGroup grp WHERE UPPER(usr.accountDeleted) = 'N'")
  public List<CnfgUser> findAll();
 
  
  @Override
  @Query("Select new CnfgUser(userId, userName, email, department, departmentType, accountActive,  accountDeleted, primaryBranchCode, branchCode, branchName, phoneNumber, grade, createdDate, modifiedDate, lastLogin, managerId, userLevel, cnfgUserGroup) from CnfgUser cnfgUser where UPPER(cnfgUser.accountDeleted) = 'N' AND cnfgUser.userId = :userId ")
  public Optional<CnfgUser> findById(@Param("userId") String userId);
*/
  
  @Override
  @Query("Select new CnfgUser(userId, userName, userNameFirst, userNameLast, email, organizationCode, organizationName, departmentCode, department, departmentType, accountActive,  accountDeleted, primaryBranchCode, branchCode, branchName, phoneNumber, grade, createdDate, modifiedDate, lastLogin, location, region, zone, managerId, userLevel, cnfgUserGroup) from CnfgUser cnfgUser where UPPER(cnfgUser.accountDeleted) = 'N' AND cnfgUser.userId = :userId ")
  public Optional<CnfgUser> findById(@Param("userId") String userId);

  @Transactional
  @Modifying
  @Query("Update CnfgUser cnfgUser SET cnfgUser.password = :encryptPassword where cnfgUser.userId = :userId ")
  public void updatePasswordById(@Param("encryptPassword") String encryptPassword,
      @Param("userId") String userId);

  @Transactional
  @Modifying
  @Query("Update CnfgUser cnfgUser SET cnfgUser.password = :newEncryptPassword where cnfgUser.userId = :userId and cnfgUser.password = :oldEncryptPassword")
  public int updatePasswordByUserIdAndOldPassword(
      @Param("newEncryptPassword") String newEncryptedPassword, @Param("userId") String userId,
      @Param("oldEncryptPassword") String oldEncryptedPassword);

  public List<CnfgUser> findByManagerIdIn(Set<String> managerIds);

  public CnfgUser findByUserName(String userName);

  public List<CnfgUser> findByUserLevelAndBranchCodeIn(String userLevel, Set<String> branchCodes);

  public List<CnfgUser> findByUserIdIn(Set<String> userIds);

  @Query(value = "SELECT u.grade FROM CnfgUser u WHERE u.grade IN :grades")
  public Set<String> findByGradeIn(Set<String> grades);
  
  @Query("Select new com.asymmetrix.grc.dto.CnfgUserDTO(usr.userId, usr.userName, usr.userNameFirst, usr.userNameLast, usr.email, usr.phoneNumber) FROM CnfgUser usr WHERE UPPER(usr.accountDeleted) = 'N'")
  public List<CnfgUserDTO> getAllUserDetails();
  
  @Modifying
  @Query("UPDATE CnfgUser c set c.accountActive = 'N' WHERE c.userId = :userId")
  void setUserAsInActive(@Param("userId") final String userId);
  
  @Query(value = "SELECT u.email FROM CnfgUserEmail u WHERE u.userId = :userId")
  public String findEmailById(String userId);


}
