package backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.reponsitory.IUserReponsitory;
import backend.reponsitory.UserReponsitory;
import entity.Manager;
import entity.Project;
import utils.ScannerUtils;

public class UserService implements IUserService {
	private IUserReponsitory reponsitory;

	public UserService() throws FileNotFoundException, IOException {
		reponsitory = new UserReponsitory();
	}

	private boolean chuanHoaEmail(String email) {
		String emailPattern = "\\w+@\\w+[.]\\w+([.]\\w+)?";
		return email.matches(emailPattern);
	}

	private boolean checkPassword(String pass) {
		boolean check = false;
		boolean check2 = false;

		for (int i = 0; i < pass.length(); i++) {
			if (Character.isUpperCase(pass.charAt(i)))
				check = true;
		}

		if (pass.length() > 5 && pass.length() < 13 && check == true) {
			check2 = true;
		}

		return check2;
	}

	public boolean isProjectExists(int projectID) throws SQLException {
		return reponsitory.isProjectExists(projectID);
	}

	public List<Project> showUserInProject(int projectID) throws SQLException {
		return reponsitory.showUserInProject(projectID);
	}

	public boolean isManagerExists(String email, String pass) throws SQLException {
		boolean check = false;

		while (!check) {
			if (chuanHoaEmail(email)) {
				check = true;
			} else {
				System.out.println("Email nhập chưa đúng định dạng. Mời bạn nhập lại!");
				email = ScannerUtils.inputString("Mời bạn nhập!");
			}
		}
		check = false;
		while (!check) {
			if (checkPassword(pass)) {
				check = true;
			} else {
				System.out.println("Pass nhập từ 6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa. Nhap lai!");
				pass = ScannerUtils.inputString("Vui long nhap!");
			}
		}

		return reponsitory.isManagerExists(email, pass);
	}

	public boolean isEmployeeExists(String email, String pass) throws SQLException {
		boolean check = false;

		while (!check) {
			if (chuanHoaEmail(email)) {
				check = true;
			} else {
				System.out.println("Email nhập chưa đúng định dạng. Mời bạn nhập lại!!");
				email = ScannerUtils.inputString("Mời bạn nhập!");
			}
		}
		check = false;
		while (!check) {
			if (checkPassword(pass)) {
				check = true;
			} else {
				System.out.println("Pass nhập từ 6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa. Nhap lai!");
				pass = ScannerUtils.inputString("Vui lòng nhập!");
			}
		}

		return reponsitory.isEmployeeExists(email, pass);
	}

	public List<Manager> showManagerInProject() throws SQLException {
		return reponsitory.showManagerInProject();
	}

}
