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
		a.insertPosition();
		
		//Ques4
		a.updatePosition();
	
//		Ques5
		a.deletePosition();	
	}

}
