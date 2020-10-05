package Answer_Day7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Answer_Day7.backend.entity.Student;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int c;
		File file = new File("F:\\StudentInformation.txt");
		FileWriter fW = null;
		FileInputStream fis = null;
		Student students = new Student();
		try {
			fis = new FileInputStream("F:\\StudentInformation.txt");
			fW = new FileWriter(file);
			for (int i = 1; i < 4; i++) {
				fW.write("Student " + i + ":\n");
				System.out.print("Nhập id thứ " + i + ": ");
				students.setId(scanner.nextLine());
				scanner.nextLine();
				fW.write("	ID: " + students.getId() + "\n");
				System.out.print("Nhập họ tên: ");
				students.setName(scanner.nextLine());
				fW.write("	Họ và tên: " + students.getName() + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			while ((c = fis.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
