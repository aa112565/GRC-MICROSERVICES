package com.asymmetrix.grc.controller;



import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.service.DepartmentService;

@RestController
@RequestMapping({ "/department" })
public class DepartmentController {

	@Resource
	DepartmentService departmentService;

	@GetMapping("/all")
	public ResponseEntity<GRCResponse<?>> getAllDepartments() {
		return GRCResponseEntity.success(departmentService.getAllDepartments());
	}

}
