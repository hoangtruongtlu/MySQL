package Answer_day4.Ex4;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float mark;
	public Student(String name, String hometown) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.mark = 0;
	}
	
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	
	public void sumMark(float bonus) {
		if (mark + bonus <= 10 && mark + bonus >= 0) {
			setMark(mark + bonus);
		}
	}
	
	public void nameMark() {
		if (getMark() <4.0) {
			System.out.println(this.name + ": Yếu");
		}
		else if (getMark()>4.0 && getMark()<6.0) {
			System.out.println(this.name + ": Trung Bình");
		}
		else if (getMark()>6.0 && getMark()<8.0) {
			System.out.println(this.name + ": Khá");
		}
		else if (getMark()>8.0) {
			System.out.println(this.name + ": Giỏi");
		}
	}
}
