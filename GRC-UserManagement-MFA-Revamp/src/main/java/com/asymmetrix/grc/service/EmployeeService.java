package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.EmployeeDTO;

public interface EmployeeService {

  List<EmployeeDTO> getAllEmployees();
  public List<EmployeeDTO> getEmployeesOfDepartment(String departmentCode);
  public List<EmployeeDTO> getBoardOfDirectors();

}
