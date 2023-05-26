package com.asymmetrix.grc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.MstEmployee;

@Repository
public interface MstEmployeeRepository extends JpaRepository<MstEmployee, Long> {
	
	@Query("select emp from MstEmployee emp where emp.department.departmentID = :departmentCode")
	public List<MstEmployee> findEmployeesByDepartmentCode(@Param("departmentCode") String departmentCode);
	
	@Query("select emp from MstEmployee emp where emp.department is null")
	public List<MstEmployee> findBoardOfDirectors();
}
