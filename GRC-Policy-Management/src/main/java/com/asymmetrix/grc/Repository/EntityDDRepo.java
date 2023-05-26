package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.EntityDD;

@Repository
public interface EntityDDRepo extends JpaRepository<EntityDD, String> {

}
