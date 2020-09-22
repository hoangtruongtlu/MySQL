package Answer_day4.Ex5.QuanLySach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TapChi extends TaiLieu {
	private int soPhatHanh;
	private int thangPhatHanh;
	
	public TapChi(String code, String name, int number,int numberRelease,int monthRelease) {
		super(code, name, number);
		this.soPhatHanh = numberRelease;
		this.thangPhatHanh = monthRelease;
	}
	
	public TapChi() {
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public int getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(int thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}
	
	public void input() throws ParseException {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số phát hành: ");
		setSoPhatHanh(sc.nextInt());
		System.out.println("Nhập tháng phát hành: ");
		setThangPhatHanh(sc.nextInt());
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Số phát hành: " + getSoPhatHanh());
		System.out.println("Tháng phát hành: " + getThangPhatHanh());
	}
}
