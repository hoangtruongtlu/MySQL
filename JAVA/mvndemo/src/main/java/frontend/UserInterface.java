package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.controller.DepartmentController;
import entity.Department;

public class UserInterface {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
//		Question1
			showDepartmentList();
			insertDepartment("Rocket07");
			int id = 0;
			String name = null;
			deleteDepartment(id);
			updateDepartment(id,name);
			showDepartmentList();
	}

	private static void updateDepartment(int id, String name) throws SQLException, FileNotFoundException, IOException {
		DepartmentController dc = new DepartmentController();
		System.out.println(dc.updateDepartment(id,name));
		
	}

	private static void deleteDepartment(int id) throws FileNotFoundException, IOException, SQLException {
		DepartmentController dc = new DepartmentController();
		System.out.println(dc.deleteDepartment(id));
	}

	private static void insertDepartment(String name) throws FileNotFoundException, IOException, SQLException {
		DepartmentController dc = new DepartmentController();
		System.out.println(dc.insertDepartment(name));
	}

	private static void showDepartmentList() throws SQLException, FileNotFoundException, IOException {
		DepartmentController dc = new DepartmentController();
		List<Department> departmentList = dc.showDepartmentList();
		for (Department department : departmentList) {
			System.out.println(department.toString());
		}
	}

}
