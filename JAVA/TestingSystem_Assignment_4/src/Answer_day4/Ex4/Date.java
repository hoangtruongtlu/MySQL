package Answer_day4.Ex4;

public class Date {
	private int day;
	private int month;
	private int year;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	public boolean isLeapYear() {
		 return ((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400 == 0);
	}
}
