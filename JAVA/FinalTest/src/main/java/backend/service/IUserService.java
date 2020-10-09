package backend.service;

import java.sql.SQLException;
import java.util.List;

import entity.Manager;
import entity.Project;

public interface IUserService {
	List<Manager> showManagerInProject() throws SQLException;

	List<Project> showUserInProject(int projectID) throws SQLException;

	boolean isProjectExists(int projectID) throws SQLException;

	boolean isManagerExists(String email, String pass) throws SQLException;

	boolean isEmployeeExists(String email, String pass) throws SQLException;
}
