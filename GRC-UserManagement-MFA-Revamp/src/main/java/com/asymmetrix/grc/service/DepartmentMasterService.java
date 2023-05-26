package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.DepartmentMasterDTO;
import com.asymmetrix.grc.dto.DeptMasterDTO;
import com.asymmetrix.grc.entity.DepartmentMaster;

public interface DepartmentMasterService {

	List<DepartmentMaster> getAllDepartment(); 

	DepartmentMaster getDepartmentById(long orgMasterId);	

	DepartmentMaster createDepartment(DepartmentMasterDTO departmentDto);

	DepartmentMaster updateDepartment(DepartmentMasterDTO departmentDto);

	boolean deleteDepartment(DepartmentMasterDTO departmentDto);

	List<DepartmentMaster> createDepartmentList(List<DepartmentMasterDTO> departmentMasterList, String uname);

	List<DeptMasterDTO> getAllDepartmentDD();

	boolean activeDepartment(DepartmentMasterDTO departmentMaster);

	boolean inActiveDepartment(DepartmentMasterDTO departmentMaster);
	
}
