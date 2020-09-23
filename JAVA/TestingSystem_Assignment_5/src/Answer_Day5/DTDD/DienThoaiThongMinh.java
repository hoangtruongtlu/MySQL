package Answer_Day5.DTDD;


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
		System.out.println("Đang gọi" + phonenumber);
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
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (a==0) {
			System.out.println("Đang sử dụng 3G");
		}
		else {
			System.out.println("Đang tắt 3G");
		}
	}
	
	public void chupHinh() {
		System.out.println("Tạch Tạch");
	}

	@Override
	public void TanCongKeXau() {
		System.out.println("Tấn công bằng điện thoại thông minh");	
	}
	
}
