package Answer_day4.Ex5;

public abstract class Student extends Person{
	protected int id;
	
	public Student(int id,String name) {
		super(name);
		this.id = id;
	}
}
