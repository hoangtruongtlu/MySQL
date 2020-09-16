import java.text.SimpleDateFormat;
import java.util.Date;
public class SystemOutPrintf {

	public static void main(String[] args) {
//		Ques1
		int a = 5;
		System.out.printf("%d%n", a);
		
//		Ques2
		int b = 100000000;
		System.out.printf("%,d%n", b);
		
//		Ques3
		float c = 5.567098f;
		System.out.printf("%.4f%n", c);
		
//		Ques4
		String s = "Nguyễn Văn A";
		System.out.printf("%s%s%s%n","Tên tôi là \"",s,"\" và tôi đang độc thân");
		
//		Ques5
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
//		Ques6
		
	}
}
