package backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.repository.DepartmentRepository;
import backend.repository.IDepartmentRepository;
import entity.Department;

public class DepartmentService implements IDepartmentService {
	private IDepartmentRepository iDepartRepository;
	@Override
	public List<Department> showDepartmentList() throws SQLException {		
		return iDepartRepository.showDepartmentList();
	}
	
	public DepartmentService() throws FileNotFoundException, IOException {
		iDepartRepository = new DepartmentRepository();
	}

	@Override
	public boolean insertDepartment(String name) throws SQLException {
		
		return iDepartRepository.insertDepartment(name);
	}

	@Override
	public boolean deleteDepartment(int id) throws SQLException {
		return iDepartRepository.deleteDepartment(id);
	}

	@Override
	public boolean updateDepartment(int id, String name) throws SQLException {
		return iDepartRepository.updateDepartment(id,name);
	}
}
