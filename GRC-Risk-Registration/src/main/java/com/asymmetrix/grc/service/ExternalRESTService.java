package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.DepartmentDTO;
import com.asymmetrix.grc.dto.EmployeeDTO;

public interface ExternalRESTService {
	
	 public void getRiskByIds(String url, List<String> riskIds);
	 public List<CnfgUserDTO> getAllUserDetailsFromUserMgmt();
	 public List<DepartmentDTO> getAllDepartmentsFromUserMgmt();
	 public List<EmployeeDTO> getAllEmployeesFromUserMgmt();

}
