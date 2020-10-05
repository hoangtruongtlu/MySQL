package backend;

import java.util.ArrayList;

public class Student {
	private static int id = 0;
	private String name;

	public Student(String name) {
		super();
		this.name = name;
		id++;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Student.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
