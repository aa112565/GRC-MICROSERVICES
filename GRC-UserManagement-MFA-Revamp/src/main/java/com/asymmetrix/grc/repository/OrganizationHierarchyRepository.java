package com.asymmetrix.grc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.OrganizationHierarchy;

@Repository
public interface OrganizationHierarchyRepository extends JpaRepository<OrganizationHierarchy, Long> {
	
	List<OrganizationHierarchy> findByVersionAndLevelAndActive(String version, int level, String active);
	
	@Transactional
	@Modifying
	@Query("update OrganizationHierarchy r set r.active = 'N' where r.version = :version and r.level = :level")
	public Integer updateOrganizationHierarchyToInactive(@Param("version") String version, @Param("level") int level);
	
	@Query("select distinct(a.parentID) from OrganizationHierarchy a where a.version = :version and a.level = :level and a.active = :active")
	List<String> findParentMappingOfVersionAndLevelAndActive(@Param("version") String version, @Param("level") int level, @Param("active") String active);
	
	List<OrganizationHierarchy> findByVersionAndActive(String version, String active);
	
	OrganizationHierarchy findByVersionAndParentIDAndActive(String parentID, String version, String active);
		
	@Query(value = "SELECT max(level) FROM OrganizationHierarchy a where a.version=:version and a.active = :active")
	public Integer getMaxLevelCompleted(String version, String active);
}
