package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Utils.ScannerUtils;
import backend.controller.UserController;
import entity.Manager;
import entity.Project;

public class Program {
	private static UserController userController;

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		userController = new UserController();
		int chon;
		do {
			System.out.println("\n---------------------------------------------------------");
			System.out.println("|              	   Menu                   		|");
			System.out.println("---------------------------------------------------------");
			System.out.println("|         1. Đăng nhập                    		|");
			System.out.println("|         2. Danh sách Employee và Manager		|");
			System.out.println("|         3. Danh sách Manager trong project    	|");
			System.out.println("|         0. Thoát chương trình           		|");
			System.out.println("---------------------------------------------------------");
			System.out.println("|        Nhập lựa chọn của bạn            		|");
			System.out.println("---------------------------------------------------------");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch (chon) {
			case 1:
				dangNhap();
				break;
			case 2:
				showUserInProject();
				break;
			case 3:
				showManagerInProject();
			case 0:
				System.out.println("Thoát chương trình thành công!");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while (chon != 0);
	}

	private static void showManagerInProject() throws SQLException {
		System.out.println("Danh sách các manager của các project: ");
		List<Manager> managers = userController.showManagerInProject();
		for (Manager manager : managers) {
			System.out.println(manager);
		}
	}

	private static void showUserInProject() throws SQLException {
		System.out.println("Nhập ID Project: ");
		int idProject = ScannerUtils.inputInt("Mời bạn nhập!");
		if (userController.isProjectExists(idProject)) {
			System.out.println("Danh sách là: ");
			List<Project> projects = userController.showUserInProject(idProject);
			for (Project project : projects) {
				System.out.println(project);
			}
		} else {
			System.out.println("Mời bạn nhập lại ID!");
		}
	}

	private static void dangNhap() throws SQLException {
		System.out.println("Nhập Email: ");
		String email = ScannerUtils.inputString("Mời bạn nhập!");
		System.out.println("Nhập Password: ");
		String pass = ScannerUtils.inputString("Mời bạn nhập!");
		if (userController.isManagerExists(email, pass)) {
			System.out.println("Đăng nhập thành công!");
		} else if (userController.isEmployeeExists(email, pass)) {
			System.out.println("Đăng nhập thành công!");
		} else {
			System.out.println("Email hoặc Password chưa chính xác. Mời bạn nhập lại!");
		}
	}
}
