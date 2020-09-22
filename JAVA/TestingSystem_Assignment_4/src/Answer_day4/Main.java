package Answer_day4;

import java.text.ParseException;

import Answer_day4.Ex4.Date;
import Answer_day4.Ex4.Student;
import Answer_day4.Ex5.CanBo;
import Answer_day4.Ex5.HighSchoolStudent;
import Answer_day4.Ex5.QLCB;
import Answer_day4.Ex5.QuanLySach;

public class Main {

	public static void main(String[] args) throws ParseException {
//		Student s1 = new Student("Truong", "Ha Noi");
//		s1.setMark(3.5f);
//		s1.sumMark(7f);
//		System.out.println(s1.getMark());
//		s1.nameMark();
//			
//		Circle c1 = new Circle(1.5);
//		System.out.println(c1.toString());
			
//		Date d1 = new Date(30, 10, 2000);
//		System.out.println(d1.toString());
//		System.out.println(d1.isLeapYear());
			
//		HighSchoolStudent a = new HighSchoolStudent(1,"Nam","Chuyên Văn","Đại học công nghệ");
//		CanBo cb = new CanBo();
//		cb.inputInfo();
//		QLCB ql1 = new QLCB();
//		ql1.insertCanBo();
//		ql1.findName();
//		ql1.show();
//		ql1.deleteCanBo();
//		ql1.show();
//		
		QuanLySach ql2 = new QuanLySach();
		ql2.insertDocument();
		ql2.deleteTaiLieu();
	}
}
