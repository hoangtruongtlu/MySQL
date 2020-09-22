package Answer_day4.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class CongNhan extends CanBo {
	private int level;
	
	public CongNhan(String name, int age, Gender gender, String address,int level) {
		super(name, age, gender, address);
		this.level = level;
	}
	
	public CongNhan() {
		
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	public void inputInfo() {
		super.inputInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bậc: ");
		setLevel(sc.nextInt());
	}
	public void showInfo() {
			super.showInfo();
			System.out.println("Bậc:" + getLevel());
	}
}
