package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.IssuingDepartment;

@Repository
public interface IssuingDepartmentRepo extends JpaRepository<IssuingDepartment, String> {

}
