package Answer_day4.Ex5.QuanLySach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bao extends TaiLieu{
	private Date ngayPhatHanh;
	
	public Bao() {
	}
	
	public Bao(String code, String name, int number,Date day) {
		super(code, name, number);
		this.ngayPhatHanh = day;
	}

	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(Date ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public void input() throws ParseException {
		super.input();
		Scanner sc = new Scanner(System.in);
		String dateFormat = "dd/MM/yyyy";
		System.out.println("Nhập ngày phát hành: ");	
		setNgayPhatHanh(new SimpleDateFormat(dateFormat).parse(sc.nextLine()));
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Ngày phát hành: " + getNgayPhatHanh());
	}
}