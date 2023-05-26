package com.asymmetrix.grc.repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.CnfgUserGroup;

@Repository
public interface GroupRepository extends JpaRepository<CnfgUserGroup, String> {

  CnfgUserGroup findByGroupName(String groupName);

  List<CnfgUserGroup> findByGroupNameIn(Set<String> groupNames);

}

