package backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;

import com.mysql.cj.xdevapi.PreparableStatement;

import entity.Department;
import utils.JDBCUtils;

public class DepartmentRepository implements IDepartmentRepository {
	private JDBCUtils jdbcUtils;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbcUtils = new JDBCUtils();
	}

	@Override
	public List<Department> showDepartmentList() throws SQLException {
		List<Department> departments = new ArrayList<Department>();
		Connection con = jdbcUtils.connect();
		String sql = "select * from department";
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			Department department = new Department(id, name);
			departments.add(department);
		}
		jdbcUtils.disconnect();
		return departments;
	}

	@Override
	public boolean insertDepartment(String name) throws SQLException {
		Connection connection = jdbcUtils.connect();
		PreparedStatement preparableStatement = connection
				.prepareStatement("insert into department(departmentName) values (?)");
		preparableStatement.setString(1, name);
		int row = preparableStatement.executeUpdate();
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteDepartment(int id) throws SQLException {
		Connection connection = jdbcUtils.connect();
		PreparedStatement preparableStatement = connection
				.prepareStatement("delete from department where departmentID =?");
		Scanner sc = new Scanner(System.in);
		id = sc.nextInt();
		sc.nextLine();
		preparableStatement.setInt(1, id);
		int row = preparableStatement.executeUpdate();
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateDepartment(int id, String name) throws SQLException {
		Connection connection = jdbcUtils.connect();
		PreparedStatement preparableStatement = connection
				.prepareStatement("update department set departmentName =? where departmentID = ?");
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		id = sc.nextInt();
		sc.nextLine();
		preparableStatement.setString(1, name);
		preparableStatement.setInt(2, id);
		int row = preparableStatement.executeUpdate();
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
}
