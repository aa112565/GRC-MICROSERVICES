package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.DepartmentDTO;
import com.asymmetrix.grc.repository.MstDepartmentRepository;
import com.asymmetrix.grc.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	MstDepartmentRepository departmentRepo;

	public List<DepartmentDTO> getAllDepartments() {
		return MapperUtils.mapToTargetClass(departmentRepo.findAll(), DepartmentDTO.class);
	}

}
