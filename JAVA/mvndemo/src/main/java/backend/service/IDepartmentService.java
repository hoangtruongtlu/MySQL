package backend.service;

import java.sql.SQLException;
import java.util.List;

import entity.Department;

public interface IDepartmentService {
	public List<Department> showDepartmentList() throws SQLException;

	public boolean insertDepartment(String name) throws SQLException;

	public boolean deleteDepartment(int id) throws SQLException;

	public boolean updateDepartment(int id, String name) throws SQLException;
}
