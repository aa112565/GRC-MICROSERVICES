package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;

import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.DepartmentMasterDTO;
import com.asymmetrix.grc.dto.DeptMasterDTO;
import com.asymmetrix.grc.entity.DepartmentMaster;
import com.asymmetrix.grc.entity.DepartmentMasterLog;
import com.asymmetrix.grc.repository.DepartmentMasterRepository;
import com.asymmetrix.grc.repository.DepartmentMasterRepositoryLog;
import com.asymmetrix.grc.service.DepartmentMasterService;


@Service
public class DepartmentMasterServiceImpl implements DepartmentMasterService {

	@Autowired
	private DepartmentMasterRepository departmentRepo;
	
	@Autowired
	private DepartmentMasterRepositoryLog departmentRepoLog;


	@Override
	public List<DepartmentMaster> getAllDepartment() {
		List<DepartmentMaster> departments = departmentRepo.findAllDepartment(); 
		if (departments.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_DEPT_NOT_FOUND);
		    }
		
		return departments;
	}
	

	@Override
	public List<DeptMasterDTO> getAllDepartmentDD() {
		List<DeptMasterDTO> departmentDD =  departmentRepo.findAllDepartmentDD();
		if (departmentDD.size() <= 0) {
		      throw new GRCException(GRCErrorConstants.ENTITY_DEPT_NOT_FOUND);
		    }
		
		return departmentDD;
	}


	@Override
	public DepartmentMaster getDepartmentById(long departmentId) {
		return departmentRepo.findById(departmentId)
			//	.orElseThrow(() -> new ResourceNotFoundException("Department not found with  Id----> " + departmentId));
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + departmentId));
	}

	

	public List<DepartmentMaster> saveAll(List<DepartmentMaster> departmentList) {
		return this.departmentRepo.saveAll(departmentList);
	}
	

	@Override
	public DepartmentMaster createDepartment(DepartmentMasterDTO departmentDto) {		
		DepartmentMaster department = MapperUtils.mapToTargetClass(departmentDto, DepartmentMaster.class);
		department.setActiveFlag("Y");
		department.setDeleteFlag("N");	
		return this.departmentRepo.save(department);
	
	}
	
	@Override
	public List<DepartmentMaster> createDepartmentList(List<DepartmentMasterDTO> departmentMasterList, String uname) {
		List<DepartmentMaster> savedDeptMasterList = new ArrayList<>();
		for(DepartmentMasterDTO departmentMaster:departmentMasterList) {
			DepartmentMaster department = MapperUtils.mapToTargetClass(departmentMaster, DepartmentMaster.class);
			department.setActiveFlag("Y");
			department.setDeleteFlag("N");		
			department.setCreatedBy(uname);
			DepartmentMaster saveDepartment =departmentRepo.save(department);
			savedDeptMasterList.add(saveDepartment);
		}
		return savedDeptMasterList;
	}

	
	public DepartmentMasterLog updateDepartmentLog(long departmentId) {
		DepartmentMaster existingDept = getDepartmentById(departmentId);
		DepartmentMasterLog departmentLog = MapperUtils.mapToTargetClass(existingDept, DepartmentMasterLog.class);
		return this.departmentRepoLog.save(departmentLog);
	}
	
	
	@Override
	@Transactional
	@Modifying
	public DepartmentMaster updateDepartment(DepartmentMasterDTO departmentDto) {
		@SuppressWarnings("unused")
		DepartmentMasterLog deptLog = updateDepartmentLog(departmentDto.getDepartmentId());
		DepartmentMaster department = MapperUtils.mapToTargetClass(departmentDto, DepartmentMaster.class);
		department.setActiveFlag("Y");
		department.setDeleteFlag("N");	
		return this.departmentRepo.save(department);
	}

	

	@Override
	public boolean deleteDepartment(DepartmentMasterDTO departmentDto) {
		DepartmentMaster existingDept = getDepartmentById(departmentDto.getDepartmentId());
		existingDept.setActiveFlag("N");
		existingDept.setDeleteFlag("D");
		existingDept.setRemarks(departmentDto.getRemarks());
	//	return this.departmentRepo.save(existingDept);
		 return (ObjectUtils.isEmpty(departmentRepo.save(existingDept))) ? Boolean.FALSE : Boolean.TRUE;
	}


	@Override
	public boolean activeDepartment(DepartmentMasterDTO departmentDto) {
		DepartmentMaster existingDept = getDepartmentById(departmentDto.getDepartmentId());
		existingDept.setActiveFlag("Y");
		existingDept.setRemarks(departmentDto.getRemarks());
		 return (ObjectUtils.isEmpty(departmentRepo.save(existingDept))) ? Boolean.FALSE : Boolean.TRUE;
	
	}


	@Override
	public boolean inActiveDepartment(DepartmentMasterDTO departmentDto) {
		DepartmentMaster existingDept = getDepartmentById(departmentDto.getDepartmentId());
		existingDept.setActiveFlag("N");
		existingDept.setRemarks(departmentDto.getRemarks());
		 return (ObjectUtils.isEmpty(departmentRepo.save(existingDept))) ? Boolean.FALSE : Boolean.TRUE;
	
	}

	
	
}
