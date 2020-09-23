package Answer_Day5.New;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
	int[] rates = new int[3];
	Scanner sc = new Scanner(System.in);
	ArrayList<New> news_list = new ArrayList<New>();
	
	public void insertNews() {
		New news = new New();
		System.out.println("Nhập title: ");
		String title = sc.nextLine();
		news.setTitle(title);
	
		System.out.println("Nhập publishDate: ");
		String publishDate = sc.nextLine();
		news.setPublishDate(publishDate);;
		
		System.out.println("Nhập content: ");
		String content = sc.nextLine();
		news.setContent(content);;
		
		System.out.println("Nhập author: ");
		String author = sc.nextLine();
		news.setAuthor(author);
		
		System.out.println("Nhập 3 đánh giá của bạn: ");
		for (int i = 0; i < rates.length; i++) {
			System.out.println("danh gia thu "+ (i+1) + ": ");
			rates[i] = sc.nextInt();
		}	
	}
	
	public void viewListNews() {
		System.out.println("Danh sách News: ");
		for (New news : news_list) {
			news.Display();
		}
	}
	
	public void averageRate() {
		New news = new New();
		news.Calculate();
		news.Display();
	}
}
