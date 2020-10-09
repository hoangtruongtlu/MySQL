package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;

import utils.properties.DatabaseProperties;

/**
 * This class is JDBCUtils. 
 * 
 * @Description: .
 * @author: HTruong
 * @create_date: Oct 9, 2020
 * @version: 1.0
 * @modifer: HTruong
 * @modifer_date: Oct 9, 2020
 */
public class JDBCUtils {
	private Connection connection;
	private DatabaseProperties databaseProperties;

	public JDBCUtils() throws FileNotFoundException, IOException {
		databaseProperties = new DatabaseProperties();
	}

	public Connection connect() throws SQLException {
		String url = databaseProperties.getProperty("dbURL");
		String user = databaseProperties.getProperty("user");
		String password = databaseProperties.getProperty("password");
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public void disconnect() throws SQLException {
		connection.close();
	}
}
