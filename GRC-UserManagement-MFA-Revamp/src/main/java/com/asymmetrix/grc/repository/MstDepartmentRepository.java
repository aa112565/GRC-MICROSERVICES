package com.asymmetrix.grc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.MstDepartment;

@Repository
public interface MstDepartmentRepository extends JpaRepository<MstDepartment, Long> {
	
	

}
