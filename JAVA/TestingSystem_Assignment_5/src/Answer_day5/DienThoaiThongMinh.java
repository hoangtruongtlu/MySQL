package Answer_day5;

import java.util.Scanner;

public class DienThoaiThongMinh extends DTDD implements VuKhi {
	
	@Override
	public void nghe() {
		System.out.println("Alo. Ai đó?");
	}
	
	@Override
	public void goi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số điện thoại để gọi: ");
		String phonenumber = sc.nextLine();
	}
	
	@Override
	public void guiTinNhan() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số điện thoại người nhận");
		String phonenumber = sc.nextLine();
		System.out.println("Nhập nội dung muốn gửi");
		String mess = sc.nextLine();
		System.out.println("Đã gửi!");
	}
	
	@Override
	public void nhanTinNhan() {
		System.out.println("Tên người gửi");
		System.out.println("Nội dung tin nhắn!");
	}
	
	public void suDung3G() {
		System.out.println("Turn On 3G");
	}
	
	public void chupHinh() {
		System.out.println("Tạch Tạch");
	}

	@Override
	public void TanCongKeXau() {
		System.out.println("Tấn công nó bằng điện thoại");	
	}
}
