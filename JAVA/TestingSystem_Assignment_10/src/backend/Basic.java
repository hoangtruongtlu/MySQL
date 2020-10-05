package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Basic {
	private Connection myCon;
	private Statement statement;
	private ResultSet result;
	private Properties properties;
	private int effectedRow;

	public Basic() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream("src/backend/ConfigDatabase.properties"));
	}

	public void getConnection() throws FileNotFoundException, IOException, SQLException {
		String dbURL = properties.getProperty("dbURL");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		myCon = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connect success!");
	}

	public void getPositon() throws SQLException {
		String select = ("Select positionID,positionName from position");
		statement = myCon.createStatement();
		result = statement.executeQuery(select);
		while (result.next()) {
			System.out.println(result.getInt("positionID") + " " + result.getNString("positionName"));
		}
	}

	public void insertPosition(String name) throws SQLException {
		String insert = "Insert into position (positionName) values('" + name + "')";
		statement = myCon.createStatement();
		effectedRow = statement.executeUpdate(insert);
	}

	public void updatePosition(int positionID, String positionName) throws SQLException {
		String update = "Update position SET positionName = '" + positionName + "' WHERE positionID = " + positionID;
		statement = myCon.createStatement();
		effectedRow = statement.executeUpdate(update);
	}

	public void deletePosition(int positionID) throws SQLException {
		String delete = "Delete from position where positionID =" + positionID;
		statement = myCon.createStatement();
		effectedRow = statement.executeUpdate(delete);
	}
}
