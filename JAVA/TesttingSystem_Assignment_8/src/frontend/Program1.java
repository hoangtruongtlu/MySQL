package frontend;

import java.util.ArrayList;

import backend.Student;

public class Program1 {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Trường"));
		students.add(new Student("Trường"));
		students.add(new Student("Trường"));
		students.add(new Student("Hiếu"));
		students.add(new Student("Sơn"));
		
//		System.out.println("Tổng số phần tử của mảng: " + students.size());
//		System.out.println(students.get(3).getName());
		students.add(students.size(), new Student("Tú"));
		System.out.println(students.get((students.size()-1)).getName());
//		for (Student student : students) {
//			System.out.println(student.getName());
//		}
	}
}
