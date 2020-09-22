package Answer_day4.Ex5;

import java.text.ParseException;
import java.util.Scanner;

public class TaiLieu {
	protected String code;
	protected String name;
	protected int number;
	public TaiLieu(String code, String name, int number) {
		super();
		this.code = code;
		this.name = name;
		this.number = number;
	}
	
	public TaiLieu() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void input() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã tài liệu: ");
		setCode(sc.nextLine());
		System.out.println("Nhập tên nhà xuất bản: ");
		setName(sc.nextLine());
		System.out.println("Nhập số bản phát hành: ");
		setNumber(sc.nextInt());
	}
	
	public void showInfo() {
		System.out.println("Mã tài liệu: " + getCode());
		System.out.println("Tên nhà xuất bản: " + getName());
		System.out.println("Số bản phát hành: " + getNumber());
	}
}

