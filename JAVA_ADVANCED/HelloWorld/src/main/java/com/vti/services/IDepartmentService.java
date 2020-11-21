package com.vti.services;

import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {
	public List<Department> getAllDepartments();
	public Department getDepartmentById(short id);
	public void createDeparment(Department department);
	public void updateDepartmentNameById(short id, String name);
	public void deleteDepartment(short id);
}
