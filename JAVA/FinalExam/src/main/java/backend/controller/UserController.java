package backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.service.IUserService;
import backend.service.UserService;
import entity.Manager;
import entity.Project;

public class UserController implements IUserService {
	private IUserService service;

	public UserController() throws FileNotFoundException, IOException {
		service = new UserService();
	}

	public boolean isProjectExists(int projectID) throws SQLException {
		return service.isProjectExists(projectID);
	}

	public List<Project> showUserInProject(int idProject) throws SQLException {
		return service.showUserInProject(idProject);
	}

	public boolean isManagerExists(String email, String pass) throws SQLException {
		return service.isManagerExists(email, pass);
	}

	public boolean isEmployeeExists(String email, String pass) throws SQLException {
		return service.isEmployeeExists(email, pass);
	}

	public List<Manager> showManagerInProject() throws SQLException {
		return service.showManagerInProject();
	};
}
