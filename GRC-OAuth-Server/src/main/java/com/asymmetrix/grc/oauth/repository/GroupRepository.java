package com.asymmetrix.grc.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.oauth.entity.CnfgUserGroup;


@Repository
public interface GroupRepository extends JpaRepository<CnfgUserGroup, String>{
	
}
