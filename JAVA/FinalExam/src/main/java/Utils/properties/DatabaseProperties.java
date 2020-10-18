package utils.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {
	private static final String RESOURCE_URL = "C:\\Users\\Administrator\\Desktop\\VTI_Rocket07\\VTI_Rocket07_HoangTruong\\JAVA\\FinalExam\\src\\main\\java\\resouces\\";
	private Properties properties;
	
	public DatabaseProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(RESOURCE_URL + "ConfigDatabase.properties"));
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
