package Answer_day4.Ex5.QLCB;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {

	public QLCB() {
	}

	Scanner sc = new Scanner(System.in);
	CanBo cb = new CanBo();
	ArrayList<CanBo> cb_list = new ArrayList<>();

//	Them moi can bo
	public void insertCanBo() {
		System.out.println("Nhập số lượng cán bộ muốn thêm: ");
		int count = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < count; i++) {
			System.out.println("1 - NhanVien, 2 - CongNhan, 3 - KySu");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				cb = new NhanVien();
				break;
			case 2:
				cb = new CongNhan();
				break;
			case 3:
				cb = new KySu();
				break;
			default:
				System.out.println("Nhập từ 1 đến 3");
				break;
			}
			cb.inputInfo();
			cb_list.add(cb);
		}
		for (CanBo canbo : cb_list) {
			canbo.showInfo();
		}
	}

//	Tim kiem theo ho ten
	public void findName() {
		System.out.println("Mời bạn nhập vào tên: ");
		String username = sc.nextLine();
		sc.nextLine();
		for (CanBo canbo : cb_list) {
			if (username.equals(canbo.getName())) {
				canbo.showInfo();
			}
			canbo.showInfo();
		}
	}

//	Hien thi thong tin

	public void show() {
		System.out.println("So luong can bo " + cb_list.size());
		for (CanBo canbo : cb_list) {
			canbo.showInfo();
		}
	}

	public void deleteCanBo() {
		System.out.println("Nhap ten can bo muon xoa: ");
		String name = sc.nextLine();
		sc.nextLine();
		cb_list.removeIf(cb-> name.equals(cb.getName()));
	}
}
