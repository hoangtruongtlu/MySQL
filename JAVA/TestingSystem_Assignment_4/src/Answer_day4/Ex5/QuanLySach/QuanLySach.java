package Answer_day4.Ex5.QuanLySach;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class QuanLySach {
	public QuanLySach() {
		
	}
	
	Scanner sc = new Scanner(System.in);
	TaiLieu tailieu = new TaiLieu();
	ArrayList<TaiLieu> tailieu_list = new ArrayList<>();
	
//	Them moi tai lieu
	public void insertDocument() throws ParseException {
		System.out.println("Nhập số lượng tài liệu muốn thêm: ");
		int count = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < count; i++) {
			System.out.println("Chọn loại tài liệu: 1 - Báo, 2 - Sách, 3 - Tạp chí");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				tailieu = new Bao();
				break;
			case 2:
				tailieu = new Sach();
				break;
			case 3:
				tailieu = new TapChi();
				break;
			default:
				System.out.println("Nhập từ 1 đến 3");
				break;
			}
			tailieu.input();
			tailieu_list.add(tailieu);
		}
		for (TaiLieu tailieu : tailieu_list) {
			tailieu.showInfo();
		}
	}
	
//	Xóa tài liệu theo mã tài liệu
	public void deleteTaiLieu() {
		System.out.println("Nhập mã tài liệu: ");
		String code = sc.nextLine();
		sc.nextLine();
		tailieu_list.removeIf(tailieu-> code.equals(tailieu.getCode()));
	}
	
//	Hiện thị thông tin về tài liệu
	public void show() {
		System.out.println("Số lượng tài liệu hiện có: " + tailieu_list.size());
		for(TaiLieu tailieu  : tailieu_list) {
			tailieu.showInfo();
		}
	}
	
//	Tìm kiếm tài liệu theo loại
	public void findDocument() {
		System.out.println("Nhập mã tài liệu muốn tìm: ");
		String code = sc.nextLine();
		sc.nextLine();
		for (TaiLieu tailieu : tailieu_list) {
			if (code.equals(tailieu.getName())) {
				tailieu.showInfo();
			}
			tailieu.showInfo();
		}
	}
}
