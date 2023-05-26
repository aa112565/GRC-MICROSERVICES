package com.asymmetrix.grc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.dto.DeptMasterDTO;
import com.asymmetrix.grc.entity.DepartmentMaster;



@Repository
public interface DepartmentMasterRepository extends JpaRepository<DepartmentMaster, Long> {
	
	@Query("FROM  DepartmentMaster WHERE deleteFlag = 'N' ORDER BY modifiedDate DESC ")
	List<DepartmentMaster> findAllDepartment();
	
	@Query("Select new com.asymmetrix.grc.dto.DeptMasterDTO(dept.departmentId, dept.departmentName) FROM DepartmentMaster dept WHERE dept.activeFlag = 'Y' AND dept.deleteFlag = 'N'")
	List<DeptMasterDTO> findAllDepartmentDD();

}
