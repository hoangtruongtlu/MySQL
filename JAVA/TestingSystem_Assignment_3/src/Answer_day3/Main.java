package Answer_day3;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Ex1-Ques2
		Random random = new Random();
		int a = random.nextInt(99999);
		DecimalFormat df = new DecimalFormat("00000");
		System.out.println("Số Random là : " + df.format(a));

//		Ex1-Ques3
		System.out.println("Hai số cuối là: " + a%100);
		
//		Ex4-Ques3
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Mời bạn nhập tên: ");
		String str = scanner.next();
		String s1 = str.substring(0, 1).toUpperCase();
		System.out.println(s1+str.substring(1));
		
//		Ex4-Ques4
		System.out.println("Mời bạn nhập tên: ");
		str = scanner.next();
		for (int i = 0;i<str.length();i++) {
		System.out.println("Ký tự thứ " + i+ ": " + str.charAt(i) );
		}
		
//		Ex4-Ques15
		str = " I am developer ";
		String s = "";
		for (int i = str.length()-1;i>=0;i--) {
			s=s+str.charAt(i);
		}
		System.out.println(s);
		
//		Ex5-Ques6
//		String temp;
//		Department[] departments = new Department[5];
//		for (int i=0;i<departments.length;i++) {
//			for(int j=i+1;j<departments.length;j++) {
//				if(departments[i].name.compareTo(departments[j].name)>0) {
//					departments[i].name = "Accounting";
//					departments[i].name = "Boss of director";
//					departments[i].name = "Marketing";
//					departments[i].name = "Sale";
//					departments[i].name = "Waiting room";
//					temp = departments[i].name;
//					departments[i].name = departments[j].name;
//					departments[j].name = temp;
//				}
//			}		
//		}
	}
}
