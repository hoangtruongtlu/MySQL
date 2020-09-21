package Answer_day4.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
	Scanner sc = new Scanner(System.in);
	CanBo cb = new CanBo();
	ArrayList<CanBo> cb_list = new ArrayList<>();

//	Them moi can bo
	public void insertCanBo() {
		System.out.println("Nhập số lượng cán bộ muốn thêm");
		int count = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < count; i++) {
			System.out.println("1 - NhanVien, 2 - CongNhan, 3 - KySu");
			int positionNumber = Integer.parseInt(sc.nextLine());
			String position;
			if (positionNumber == 1) {
				position = String.valueOf(EnumPosition.NhanVien);
			} else if (positionNumber == 2) {
				position = String.valueOf(EnumPosition.CongNhan);
			} else if (positionNumber == 3) {
				position = String.valueOf(EnumPosition.KySu);
			}
			  else {
				System.out.println("Vui lòng nhập từ 1 đến 3");
				return;
			}
			CanBo cb = new CanBo(name, age, gender, address);
			cb_list.add(cb);
		}	
	}
}
