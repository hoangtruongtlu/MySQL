package Answer_Day5;

import java.util.Scanner;

import Answer_Day5.New.MyNews;
import Answer_Day5.New.New;

public class Main {

	public static void main(String[] args) {
		
		MyNews mynews = new MyNews();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1: Chức năng Insert news");
			System.out.println("2: CHức năng View list news");
			System.out.println("3: CHức năng Average rate");
			System.out.println("4: Exit");
			System.out.println("Mời bạn chọn chức năng muốn sử dụng: ");

			sc = new Scanner(System.in);
			if (sc.hasNext("4")) {
				System.out.println("Bạn vừa nhập 4 để thoát chương trình");
				return;
			}
			
			int a = sc.nextInt();

			switch (a) {
			case 1:
				System.out.println("Chức năng Insert news");
				mynews.insertNews();
				break;
			case 2:
				System.out.println("CHức năng View list news");
				mynews.viewListNews();
				break;
			case 3:
				System.out.println("CHức năng Average rate");
				mynews.averageRate();
				break;
			default:
				System.out.println("Mời bạn nhập lại: ");
				break;
			}
			sc.close();
		}
	}
}
