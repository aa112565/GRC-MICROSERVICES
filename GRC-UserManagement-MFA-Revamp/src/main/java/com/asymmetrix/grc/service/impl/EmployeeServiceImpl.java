package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.EmployeeDTO;
import com.asymmetrix.grc.repository.MstEmployeeRepository;
import com.asymmetrix.grc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
	MstEmployeeRepository employeeRepo;

	public List<EmployeeDTO> getAllEmployees() {
		return MapperUtils.mapToTargetClass(employeeRepo.findAll(), EmployeeDTO.class);
	}
	
	public List<EmployeeDTO> getEmployeesOfDepartment(String departmentCode) {
		//return MapperUtils.mapToTargetClass(employeeRepo.findEmployeesByDepartmentCode(departmentCode), EmployeeDTO.class);
		return MapperUtils.mapToTargetClass(employeeRepo.findAll(), EmployeeDTO.class);
	}
	
	public List<EmployeeDTO> getBoardOfDirectors(){
		return MapperUtils.mapToTargetClass(employeeRepo.findBoardOfDirectors(), EmployeeDTO.class);
	}

}
