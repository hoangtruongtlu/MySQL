import java.time.LocalDate;

public class Exam {
	int id;
	String code;
	String title;
	CategoryQuestion[] categoryquestion;
    int duration;
    Account account;
    LocalDate createDate;
    Question[] questions;
}
