package Answer_day4.Ex5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Sach extends TaiLieu {
	private String nameWriter;
	private int numberOfPage;
	
	public Sach(String code, String name, int number,String nameWriter,int numberPage) {
		super(code, name, number);
		this.nameWriter = nameWriter;
		this.numberOfPage = numberPage;
	}
	
	public Sach() {	
	}

	public String getNameWriter() {
		return nameWriter;
	}

	public void setNameWriter(String nameWriter) {
		this.nameWriter = nameWriter;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	
	public void input() throws ParseException {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên tác giả: ");	
		setNameWriter(sc.nextLine());
		System.out.println("Nhập số trang: ");
		setNumberOfPage(sc.nextInt());
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Tên tác giả: " + getNameWriter());
		System.out.println("Số trang: " + getNumberOfPage());
	}
}
