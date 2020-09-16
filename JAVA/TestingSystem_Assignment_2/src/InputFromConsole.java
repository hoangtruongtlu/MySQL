import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputFromConsole {

	public static void main(String[] args) throws ParseException{
		Scanner scanner = new Scanner(System.in);	
//		Ques1
		System.out.println("Mời bạn nhập vào 3 số dương:");
		for (int i= 0;i<3;i++) {
			int a = scanner.nextInt();
			System.out.println(a);
		}
		
//		Ques2
		System.out.println("Mời bạn nhập vào 2 số thực:");
		for (int i= 0;i<2;i++) {
			float b = scanner.nextFloat();
			System.out.println(b);
		}
		
//		Ques3
		System.out.println("Mời bạn nhâp vào họ");
		String s1 = scanner.next();
		System.out.println("Mời bạn nhâp vào tên");
		String s2 = scanner.next();
		
//		Ques4
		System.out.println("Mời bạn nhâp vào ngày sinh");
		String input = scanner.next();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date dateOfBirth = dateFormat.parse(input);
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("\n");
		
//		Ques7
		System.out.println("Mời bạn nhập vào 1 số chẵn");
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("Input: " + number);
		} else {
			System.out.println("Số bạn nhập không phải số chẵn");
		}
	}
}
