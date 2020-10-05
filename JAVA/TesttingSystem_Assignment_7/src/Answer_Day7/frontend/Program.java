package Answer_Day7.frontend;

import java.io.IOException;
import java.util.ArrayList;

import Answer_Day7.backend.common.FileUtils;
import Answer_Day7.backend.entity.Student;

public class Program {

	public static void main(String[] args) throws IOException {
		Student s1 = new Student("1","Truong");
		Student s2 = new Student("2","Hieu");
		Student s3 = new Student("3","Son");
		
		Student[] stdList = {s1,s2,s3};
		String filePath = "F:\\studentlist.txt";
		FileUtils.writeStudentList(stdList, filePath);
		ArrayList<Student> stds = FileUtils.readStudentsIntoArray(filePath);
		for (Student student : stds) {
			System.out.println(student.toString());
		}	
	}

}
