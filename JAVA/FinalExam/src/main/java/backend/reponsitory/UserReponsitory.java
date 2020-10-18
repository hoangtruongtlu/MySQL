package backend.reponsitory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.JdbcUtils;
import entity.Manager;
import entity.Project;

public class UserReponsitory implements IUserReponsitory {
	private JdbcUtils jdbcUtils;

	public UserReponsitory() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public boolean isManagerExists(String email, String pass) throws SQLException {
		Connection connection = jdbcUtils.connect();
		String sql = "select * from manager where email = ? and pass = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,pass);
		ResultSet result = preparedStatement.executeQuery();
		boolean check = false;
		if (result.next())
			check = true;
		
		jdbcUtils.disconnect();
		return check;
	}

	public boolean isEmployeeExists(String email, String pass) throws SQLException {
		Connection connection = jdbcUtils.connect();
		String sql = "select * from employee where email = ? and pass = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,pass);
		ResultSet result = preparedStatement.executeQuery();
		boolean check = false;
		if (result.next())
			check = true;
		
		jdbcUtils.disconnect();
		return check;
	}

	public boolean isProjectExists(int projectID) throws SQLException {
		Connection connection = jdbcUtils.connect();
		String sql = "select * from project where projectID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, projectID);
		ResultSet result = preparedStatement.executeQuery();
		boolean check = false;
		if (result.next()) {
			check = true;
		}
		jdbcUtils.disconnect();
		return check;
	}

	public List<Project> showUserInProject(int projectID) throws SQLException {
		List<Project> projects = new ArrayList<Project>();
		Connection connection = jdbcUtils.connect();
		String sql = "select * from project where projectID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, projectID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Project project = new Project(resultSet.getInt("projectID"), resultSet.getInt("teamSize"),
					resultSet.getInt("managerID"), resultSet.getInt("employeeID"));

			projects.add(project);

		}
		jdbcUtils.disconnect();
		return projects;
	}

	public List<Manager> showManagerInProject() throws SQLException {
		List<Manager> managers = new ArrayList<Manager>();
		Connection connection = jdbcUtils.connect();
		String sql = "select manager.* from project\r\n"
				+ "		join manager on project.ManagerID = manager.ManagerID;";
		Statement statements = connection.createStatement();
		ResultSet resultSet = statements.executeQuery(sql);
		while (resultSet.next()) {
			Manager manager = new Manager(resultSet.getInt("ManagerID"), resultSet.getString("FullName"),
					resultSet.getString("Email"), resultSet.getString("Pass"), resultSet.getInt("ExpInYear"));

			managers.add(manager);

		}
		jdbcUtils.disconnect();

		return managers;
	}
}
