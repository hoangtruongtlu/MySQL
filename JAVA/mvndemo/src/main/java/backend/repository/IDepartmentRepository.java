package backend.repository;

import java.sql.SQLException;
import java.util.List;

import entity.Department;

public interface IDepartmentRepository {

	List<Department> showDepartmentList() throws SQLException;

	boolean insertDepartment(String name) throws SQLException;

	boolean deleteDepartment(int id) throws SQLException;

	boolean updateDepartment(int id, String name) throws SQLException;
	
}
