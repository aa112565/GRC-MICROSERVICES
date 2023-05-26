package com.asymmetrix.grc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.exception.GRCException;
import com.asymmetrix.grc.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrgDepartmentsDDDTO;
import com.asymmetrix.grc.dto.OrganizationDepartmentsDTO;
import com.asymmetrix.grc.entity.OrganizationDepartments;
import com.asymmetrix.grc.entity.OrganizationDepartmentsLog;
import com.asymmetrix.grc.repository.OrganizationDepartmentsLogRepository;
import com.asymmetrix.grc.repository.OrganizationDepartmentsRepository;
import com.asymmetrix.grc.service.OrganizationDepartmentService;

@Service
public class OrganizationnDepartmentServiceImpl implements OrganizationDepartmentService {

	@Autowired
	private OrganizationDepartmentsRepository orgSubsDeptRepo;

	@Autowired
	OrganizationDepartmentsLogRepository orgSubsDeptLogRepo;

	@Override
	public List<OrganizationDepartments> getAllOrgSubsidiaryDepartments() {
		List<OrganizationDepartments> orgSubsDept = orgSubsDeptRepo.findAllOrgSubsidiaryDepartments();
		if (orgSubsDept.size() <= 0) {
			throw new GRCException(GRCErrorConstants.ENTITY_ORG_SUBS_DEPT_NOT_FOUND);
		}
		return orgSubsDept;
		// return this.orgSubsDeptRepo.findAllOrgSubsidiaryDepartments();
	}

	@Override
	public List<OrganizationDepartments> getAllByOrganizationIdAndSubsidiaryId(
			OrganizationDepartmentsDTO orgSubsDeptDto) {
		List<OrganizationDepartments> orgSubsDept = orgSubsDeptRepo.findAllByOrganizationIdAndSubsidiaryId(
				orgSubsDeptDto.getOrganizationId(), orgSubsDeptDto.getSubsidiaryId());
		if (orgSubsDept.size() <= 0) {
			throw new GRCException(GRCErrorConstants.ENTITY_ORG_SUBS_DEPT_NOT_FOUND);
		}
		return orgSubsDept;

		// return
		// this.orgSubsDeptRepo.findByOrganizationIdAndSubsidiaryId(orgSubsDeptDto.getOrganizationId(),
		// orgSubsDeptDto.getSubsidiaryId());
	}

	@Override
	public List<OrgDepartmentsDDDTO> getOrgSubsidiaryDepartmentsDropdown(OrganizationDepartmentsDTO orgSubsDeptDto) {
		List<OrgDepartmentsDDDTO> orgSubsDept = orgSubsDeptRepo.findByOrganizationIdAndSubsidiaryId(
				orgSubsDeptDto.getOrganizationId(), orgSubsDeptDto.getSubsidiaryId());
		if (orgSubsDept.size() <= 0) {
			throw new GRCException(GRCErrorConstants.ENTITY_ORG_SUBS_DEPT_NOT_FOUND);
		}
		return orgSubsDept;
		// return
		// orgSubsDeptRepo.findByOrganizationIdAndSubsidiaryId(orgSubsDeptDto.getOrganizationId(),
		// orgSubsDeptDto.getSubsidiaryId());
	}

	@Override
	public OrganizationDepartments getOrgSubsidiaryDepartmentsById(long orgSubsDeptId) {
		return orgSubsDeptRepo.findById(orgSubsDeptId)
				// .orElseThrow(() -> new
				// ResourceNotFoundException("Organization-Subsidiary-Departments not found with
				// Id----> " + orgSubsDeptId));
				.orElseThrow(() -> new GRCException(GRCErrorConstants.ENTITY_NOT_FOUND + orgSubsDeptId));
	}

	public List<OrganizationDepartments> saveAll(List<OrganizationDepartments> orgSubsDeptList) {
		return this.orgSubsDeptRepo.saveAll(orgSubsDeptList);
	}

	@Override
	public OrganizationDepartments createOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto) {
		OrganizationDepartments orgSubsDept = MapperUtils.mapToTargetClass(orgSubsDeptDto,
				OrganizationDepartments.class);
		orgSubsDept.setActiveFlag("Y");
		orgSubsDept.setDeleteFlag("N");
		return this.orgSubsDeptRepo.save(orgSubsDept);

	}

	@Override
	public List<OrganizationDepartments> createOrgSubsidiaryDepartmentsList(
			List<OrganizationDepartmentsDTO> orgSubsDeptList, String uname) {
		List<OrganizationDepartments> savedOrgSubsDeptList = new ArrayList<>();
		for (OrganizationDepartmentsDTO subsidiaryDeptDto : orgSubsDeptList) {
			OrganizationDepartments orgSubsDept = MapperUtils.mapToTargetClass(subsidiaryDeptDto,
					OrganizationDepartments.class);
			orgSubsDept.setActiveFlag("Y");
			orgSubsDept.setDeleteFlag("N");
			orgSubsDept.setCreatedBy(uname);
			OrganizationDepartments subsidiary = orgSubsDeptRepo.save(orgSubsDept);
			savedOrgSubsDeptList.add(subsidiary);
		}
		return savedOrgSubsDeptList;
	}

	public OrganizationDepartmentsLog updateOrgSubsidiaryDepartmentsLog(long orgSubsDeptId) {
		OrganizationDepartments existingOrgSubsDept = getOrgSubsidiaryDepartmentsById(orgSubsDeptId);
		OrganizationDepartmentsLog orgSubsDeptLog = MapperUtils.mapToTargetClass(existingOrgSubsDept,
				OrganizationDepartmentsLog.class);
		return this.orgSubsDeptLogRepo.save(orgSubsDeptLog);
	}

	@Override
	@Transactional
	public OrganizationDepartments updateOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto) {
		@SuppressWarnings("unused")
		OrganizationDepartmentsLog log = updateOrgSubsidiaryDepartmentsLog(orgSubsDeptDto.getOrgDepartmentId());
		OrganizationDepartments orgSubsDept = MapperUtils.mapToTargetClass(orgSubsDeptDto,
				OrganizationDepartments.class);
		orgSubsDept.setActiveFlag("Y");
		orgSubsDept.setDeleteFlag("N");
		return this.orgSubsDeptRepo.save(orgSubsDept);
	}

	@Override
	public boolean deleteOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto) {
		OrganizationDepartments orgSubsDept = getOrgSubsidiaryDepartmentsById(orgSubsDeptDto.getOrgDepartmentId());
		orgSubsDept.setActiveFlag("N");
		orgSubsDept.setDeleteFlag("D");
		orgSubsDept.setRemarks(orgSubsDeptDto.getRemarks());
		// return this.orgSubsDeptRepo.save(orgSubsDept);
		return (ObjectUtils.isEmpty(orgSubsDeptRepo.save(orgSubsDept))) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean activeOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto) {
		OrganizationDepartments orgSubsDept = getOrgSubsidiaryDepartmentsById(orgSubsDeptDto.getOrgDepartmentId());
		orgSubsDept.setActiveFlag("Y");
		orgSubsDept.setRemarks(orgSubsDeptDto.getRemarks());
		return (ObjectUtils.isEmpty(orgSubsDeptRepo.save(orgSubsDept))) ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public boolean inActiveOrgSubsidiaryDepartments(OrganizationDepartmentsDTO orgSubsDeptDto) {
		OrganizationDepartments orgSubsDept = getOrgSubsidiaryDepartmentsById(orgSubsDeptDto.getOrgDepartmentId());
		orgSubsDept.setActiveFlag("N");
		orgSubsDept.setRemarks(orgSubsDeptDto.getRemarks());
		return (ObjectUtils.isEmpty(orgSubsDeptRepo.save(orgSubsDept))) ? Boolean.FALSE : Boolean.TRUE;
	}

}
