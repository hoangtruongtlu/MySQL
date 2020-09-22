package Answer_day4.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class KySu extends CanBo {
	private String career;

	public KySu(String name, int age, Gender gender, String address, String career) {
		super(name, age, gender, address);
		this.career = career;
	}
	
	public KySu() {
		
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public void inputInfo() {
		super.inputInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ngành đào tạo: ");
		setCareer(sc.nextLine());
	}

	public void showInfo() {
			super.showInfo();
			System.out.println("Ngành đào tạo:" + getCareer());
	}
}
