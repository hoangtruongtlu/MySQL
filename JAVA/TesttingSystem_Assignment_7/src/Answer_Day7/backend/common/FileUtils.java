package Answer_Day7.backend.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;

import Answer_Day7.backend.entity.Student;

public class FileUtils {
	private static Writer txtWrite = null;
	private static Reader txtRead = null;
	private static BufferedReader bufRead = null;
	private static int c = 0;

	public static void writerStudent(Student students, int stt, String filePath) throws IOException {
		txtWrite = new FileWriter(new File(filePath),true);
		txtWrite.write("Student " + stt + " :" + students.toString() + "\n");
		txtWrite.close();
	}

	public static void writeStudentList(Student[] students, String filePath) throws IOException {
		for (int i = 0; i < students.length; i++) {
			writerStudent(students[i], i + 1, filePath);
		}
	}

	public static void readStudnet(String filePath) throws IOException {
		txtRead = new FileReader(new File(filePath));
		while ((c = txtRead.read()) != -1) {
				System.out.println((char) c);
			}
			txtRead.close();
		}

		public static ArrayList<Student> readStudentsIntoArray(String filePath) throws IOException {
			ArrayList<Student> stdList = new ArrayList<Student>();
			txtRead = new FileReader(new File(filePath));
			bufRead = new BufferedReader(txtRead);
			String line = null;
			while((line = bufRead.readLine())!=null) {
				Student currentStudent = convertStringToStudent(line);
				stdList.add(currentStudent);
			}
			return stdList;
		}

		private static Student convertStringToStudent(String line) {
			String id = null;
			String name = null;
			//Phân tích cú pháp text để lấy được id và name
			//SubString(beginIndex, endIndex)
			int beginIndexOfID = line.indexOf(":")+1;
			int endIndexOfID = line.indexOf("-");
			int beginIndexOfName = endIndexOfID + 1;
			id = line.substring(beginIndexOfID, endIndexOfID);
			name = line.substring(beginIndexOfName);
			return new Student(id, name);
		}
}
