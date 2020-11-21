package com.vti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	@Override
	public List<Department> getAllDepartments() {

		return repository.getAllDepartments();
	}

	@Override
	public Department getDepartmentById(short id) {

		return repository.getDepartmentByID(id);
	}

	@Override
	public void createDeparment(Department department) {
		repository.createDepartment(department);

	}

	@Override
	public void updateDepartmentNameById(short id, String name) {
		repository.updateDepartment(id, name);

	}

	@Override
	public void deleteDepartment(short id) {
		repository.deleteDepartment(id);
	}

}
