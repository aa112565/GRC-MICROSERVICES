package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asymmetrix.grc.entity.UserPreferences;

public interface UserPrefernecesRepository extends JpaRepository<UserPreferences, String> {

  UserPreferences findByUserIdAndPage(String userId, String page);

}
