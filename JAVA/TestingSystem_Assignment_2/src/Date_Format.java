import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Date_Format {
	
	public static void main(String[] args) {
//		Create Department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";
		
		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

//		Create Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Fresher";
		group1.createdate = LocalDate.of(2020, 04, 01);
		 
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Junior";
		group2.createdate = LocalDate.of(2020, 04, 01);
		
//		Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Dev";

		Position position2 = new Position();
		position1.id = 2;
		position1.name = "Test";
		
//		Create Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "hoangtruong@gmail.com";
		account1.username = "hoangtruong97";
		account1.fullname = "Hoàng Văn Trường";
		account1.position = position1;
		account1.department = department1;
		account1.createdate = LocalDate.of(2020, 04, 01);
		account1.groups = new Group[] {group1};
		
		Account account2 = new Account();
		account2.id = 2;
		account2.email = "trunghieu@gmail.com";
		account2.username = "trunghieu99";
		account2.fullname = "Nguyễn Trung Hiếu";
		account2.position = position2;
		account2.department = department2;
		account2.createdate = LocalDate.of(2020, 04, 01);
		account2.groups = new Group[] {group1, group2};
		
//		Add Account to Group
		Account[] AccOfGroup1 = {account1,account2};
		group1.accounts = AccOfGroup1;
		
// 		Create CategoryQuestion
		CategoryQuestion category1 = new CategoryQuestion();
		category1.id = 1;
		category1.name = "JAVA";

		CategoryQuestion category2 = new CategoryQuestion();
		category2.id = 2;
		category2.name = "DB";

// 		Create TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = "Essay";

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = "Multi-choice";

// 		Create Question
		Question question1 = new Question();
		question1.categoryQuestion = category1;
		question1.content = "Java";
		question1.createDate = LocalDate.of(2020, 04, 01);
		question1.account = account1;
		question1.id = 1;
		question1.typeQuestion = type1;

		Question question2 = new Question();
		question2.categoryQuestion = category1;
		question2.content = "Java";
		question2.createDate = LocalDate.of(2020, 04, 01);
		question2.account = account1;
		question2.id = 2;
		question2.typeQuestion = type2;



		// Create exam
		Exam exam1 = new Exam();
		exam1.code = "JV01";
		exam1.createDate = LocalDate.of(2020, 04, 01);
		exam1.account = account1;
		exam1.duration = 120;
		exam1.id = 1;
		exam1.title = "Kien thuc co ban ve Java";

		Exam exam2 = new Exam();
		exam2.code = "DB01";
		exam2.createDate = LocalDate.of(2020, 04, 01);
		exam2.account = account2;
		exam2.duration = 90;
		exam2.id = 2;
		exam1.title = "Kien thuc co ban ve Database";

		// add question to exam
		Question[] questionOfExam1 = { question1, question2 };
		exam1.questions = questionOfExam1;

		Question[] questionOfExam2 = { question2 };
		exam1.questions = questionOfExam2;

		// Create Answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "JAVA la ngon ngu lap trinh pho bien nhat";
		answer1.isCorrect = true;
		answer1.question = question1;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "JAVA la ngon ngu lap trinh mat phi";
		answer2.isCorrect = false;
		answer2.question = question1;
		
//		Ques1
		Locale locale = new Locale("vn", "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(exam1.createDate.atStartOfDay(defaultZoneId).toInstant());
		String createDate1 = dateformat.format(date);
		System.out.println(exam1.code + ": " + createDate1);
		
//		Ques2
		String pattern2 = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		String createDate2 = simpleDateFormat2.format(date);
		System.out.println("Create Date: " + createDate2);
		System.out.println("\n");
		
//		Ques3
		String pattern3 = "yyyy";
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
		String createDate3 = simpleDateFormat2.format(date);
		System.out.println("Create Date: " + createDate3);
		System.out.println("\n");
	
//		Ques4
		String pattern4 = "yyyy-MM";
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(pattern4);
		String createDate4 = simpleDateFormat2.format(date);
		System.out.println("Create Date: " + createDate4);
		System.out.println("\n");
	
//		Ques5
		String pattern5 = "MM-dd";
		SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(pattern5);
		String createDate5 = simpleDateFormat2.format(date);
		System.out.println("Create Date: " + createDate5);
		System.out.println("\n");
	}
}
