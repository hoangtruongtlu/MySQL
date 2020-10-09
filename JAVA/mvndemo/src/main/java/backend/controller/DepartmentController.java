package backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.service.DepartmentService;
import backend.service.IDepartmentService;
import entity.Department;

public class DepartmentController {
	private IDepartmentService iDepartmentService;

	public DepartmentController() throws FileNotFoundException, IOException {
		iDepartmentService = new DepartmentService();
	}

	public List<Department> showDepartmentList() throws SQLException {
		return iDepartmentService.showDepartmentList();
	}

	public boolean insertDepartment(String name) throws SQLException {
		return iDepartmentService.insertDepartment(name);
	}

	public boolean deleteDepartment(int id) throws SQLException {
		return iDepartmentService.deleteDepartment(id);
	}

	public boolean updateDepartment(int id, String name) throws SQLException {
		return iDepartmentService.updateDepartment(id,name);
	}
}
