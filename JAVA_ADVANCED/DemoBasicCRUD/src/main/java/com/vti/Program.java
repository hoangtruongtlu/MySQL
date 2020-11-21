package com.vti;

import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class Program {

	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

		System.out.println("***********GET ALL DepartmentS***********");

		List<Department> Departments = repository.getAllDepartments();

		for (Department Department : Departments) {
			System.out.println(Department);
		}

		System.out.println("\n\n***********GET Department BY ID***********");

		Department DepartmentById = repository.getDepartmentByID((short) 2);
		System.out.println(DepartmentById);

		System.out.println("\n\n***********GET Department BY NAME***********");

		Department DepartmentByName = repository.getDepartmentByName("VTI Sale 02");
		System.out.println(DepartmentByName);

		System.out.println("\n\n***********CREATE Department***********");

		Department DepartmentCreate = new Department();
		DepartmentCreate.setDepartmentName("waiting");
		repository.createDepartment(DepartmentCreate);

		System.out.println("\n\n***********UPDATE Department 1***********");

		repository.updateDepartment((short) 3, "Security");

		System.out.println("\n\n***********UPDATE Department 2***********");

		Department DepartmentUpdate = new Department();
		DepartmentUpdate.setDepartmentID((short) 2);
		DepartmentUpdate.setDepartmentName("Security2");
		repository.updateDepartment(DepartmentUpdate);

		System.out.println("\n\n***********DELETE Department***********");
		repository.deleteDepartment((short) 2);

		System.out.println("***********CHECK Department EXISTS BY ID***********");
		System.out.println(repository.isDepartmentExistsByID((short) 2));

		System.out.println("***********CHECK Department EXISTS BY NAME***********");
		System.out.println(repository.isDepartmentExistsByName("Security"));

	}

}