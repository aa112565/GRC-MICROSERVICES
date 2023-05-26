package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.UserGroup;


@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Long> {

}
