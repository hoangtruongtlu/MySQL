package Answer_day4.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class CanBo {
	protected String name;
	protected int age;
	protected Gender gender;
	protected String address;
	
	public CanBo(String name, int age, Gender gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public CanBo() {
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Gender getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(int gender) {
		if (gender==0) {
			this.gender = Gender.valueOf("MALE");
		}
		else if (gender == 1) {
			this.gender = Gender.valueOf("FEMALE");
		}
		else {
			this.gender = Gender.valueOf("UNKNOW");
		}
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên cán bộ: ");
		setName(sc.nextLine());
		System.out.println("Nhập tuổi cán bộ: ");
		setAge(sc.nextInt());
		System.out.println("Nhập giới tính: ");
		setGender(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhập địa chỉ: ");
		setAddress(sc.nextLine());
		
	}
	
	public void showInfo() {
		System.out.println("Tên:" + getName() + "\nTuổi:" + getAge() + "\nGiới tính:" + getGender());
	}
}
