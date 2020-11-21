package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.services.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentById(@PathVariable(name = "id") short id) {
		return departmentService.getDepartmentById(id);
	}

	@PostMapping
	public void createDepartment(@RequestBody Department department) {
		departmentService.createDeparment(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartmentNameById(@PathVariable(name = "id") short id,
			@RequestParam(value = "name") String name) {
		departmentService.updateDepartmentNameById(id, name);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(value = "id") short id) {
		departmentService.deleteDepartment(id);
	}
}
