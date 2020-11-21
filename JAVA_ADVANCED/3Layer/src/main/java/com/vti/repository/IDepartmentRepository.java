package com.vti.repository;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.vti.entity.Department;

public interface IDepartmentRepository {

	public List<Department> getAllDepartments(int page, int size, String sortType, String sortField, String search,
			short from,short to);
	
	public List<Department> getAllDepartments();

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(Department department);

	public void updateDepartment(short id, String newName);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);

}
