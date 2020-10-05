package front_end;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import backend.Basic;

public class Program1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		
		Basic a = new Basic();
		//Ques1
		a.getConnection();
		
		//Ques2
		a.getPositon();
		
		//Ques3
		System.out.println("Nhập tên: ");
		String name = sc.nextLine();
		a.insertPosition(name);
		
		//Ques4
		System.out.println("Nhập positionID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập positionName: ");
		name = sc.nextLine();
		a.updatePosition(id,name);
		a.getPositon();
		
//		Ques5
		System.out.println("Nhập ID: ");
		id = sc.nextInt();
		sc.nextLine();
		a.deletePosition(id);
		
	}

}
