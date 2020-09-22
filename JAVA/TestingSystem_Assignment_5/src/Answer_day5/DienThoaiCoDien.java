package Answer_day5;

import java.util.Scanner;

public class DienThoaiCoDien extends DTDD implements VuKhi {
	
	@Override
	public void nghe() {
		System.out.println("Alo. Ai đó?");
	}
	
	@Override
	public void goi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input PhoneNumber: ");
		String phonenumber = sc.nextLine();
	}
	
	@Override
	public void guiTinNhan() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Messages");
		String mess = sc.nextLine();
		System.out.println("Choose PhoneNumber In Contacts");
		System.out.println("Send");
	}
	
	@Override
	public void nhanTinNhan() {
		System.out.println("Ting Ting");
	}
	
	public void ngheRadio() {
		System.out.println("Chào buổi sáng ......");
	}
	

	@Override
	public void TanCongKeXau() {
		System.out.println("Giết nó");	
	}
}
