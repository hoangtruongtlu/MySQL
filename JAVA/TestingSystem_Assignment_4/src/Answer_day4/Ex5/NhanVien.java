package Answer_day4.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class NhanVien extends CanBo{
	private String job;
	
	public NhanVien(String name, int age, Gender gender, String address, String job) {
		super(name, age, gender, address);
		this.job = job;
	}
	
	public NhanVien() {
		
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	public void inputInfo() {
		super.inputInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Công việc: ");
		setJob(sc.nextLine());
	}
	public void showInfo() {
			super.showInfo();
			System.out.println("Công việc:" + getJob());
	}
}
