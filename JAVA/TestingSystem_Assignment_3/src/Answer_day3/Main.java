package Answer_day3;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Ex1-Ques2
		Random random = new Random();
		int a = random.nextInt(99999);
//		DecimalFormat df = new DecimalFormat("00000");
//		System.out.println("Số Random là : " + df.format(a));
		addZero(random.nextInt(99999));

//		Ex1-Ques3
		System.out.println("Hai số cuối là: " + a%100);
		
//		Ex2
		Account[] acc = new Account[5];
		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account();
			acc[i].email = "Email " + i;
			acc[i].userName = "User name " + i;
			acc[i].fullName = "Full name " + i;
			acc[i].createDate = LocalDate.now();
		}

		for (int i = 0; i < acc.length; i++) {
			System.out.println("Email: " + acc[i].email);
			System.out.println("UserName: " + acc[i].userName);
			System.out.println("FullName: " + acc[i].email);
			System.out.println("CreateDate: " + acc[i].createDate);
			System.out.println();
			System.out.println();
		}
		
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
		reverByWord("  I  am  developer  ");
		
//		Ex5-Ques6
		String[] departments = new String[] { "Accounting", "Boss of director", "Marketing", "Sale","Waiting room" };
		Arrays.sort(departments);
		for (int i = 0; i < departments.length; i++) {
			System.out.println("department " + i + " : " + departments[i]);
	    }
		
	}
		private static void addZero(int number) {
		int hang = 10000;
		while (hang >=1) {
			System.out.print(number/hang);
			number %=hang;
			hang/=10;
			}
		System.out.println();
		}
		
		private static void reverByWord(String str) {
			String [] splits = str.split(" ");
			String[] arr = new String[splits.length];
			int aindex = 0;
			for (int i=splits.length-1;i>=0;i--) {
				if(!"".equals(splits[i])) {
					arr[aindex] = splits[i];
					aindex+=1;
				}
			}
			for (int i =0;i<arr.length;i++) {
				if(arr[i]!=null) {
					if(arr[i+1]!=null) {
						System.out.print(arr[i]+ " ");
					}
					else {
						System.out.println(arr[i]);
					}
				}
			}
		}
}
