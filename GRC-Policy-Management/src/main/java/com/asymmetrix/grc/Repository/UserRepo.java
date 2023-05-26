package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
