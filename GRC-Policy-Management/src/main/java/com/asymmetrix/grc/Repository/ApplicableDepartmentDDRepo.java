package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.ApplicableDepartment;

@Repository
public interface ApplicableDepartmentDDRepo extends JpaRepository<ApplicableDepartment, String> {

}
