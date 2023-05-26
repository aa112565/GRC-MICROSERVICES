package com.asymmetrix.grc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asymmetrix.grc.entity.MstOrganization;

@Repository
public interface MstOrganizationRepository extends JpaRepository<MstOrganization, Long> {
	public List<MstOrganization> findByActiveOrderByCreatedDateDesc(String activeFlag);
	public MstOrganization findFirstByOrderByCreatedDateDescIdDesc();
	public MstOrganization findFirstByVersionAndActiveOrderByCreatedDateDescIdDesc(String version, String activeFlag);
	public MstOrganization findByVersion(String version); 
}
