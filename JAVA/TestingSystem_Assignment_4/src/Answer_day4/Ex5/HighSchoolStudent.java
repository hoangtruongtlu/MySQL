package Answer_day4.Ex5;

public class HighSchoolStudent extends Student {
	private String clazz;
	private String desiredUniversity;
	
	public HighSchoolStudent(int id,String name,String clazz,String desiredUniversity) {
		super(id, name);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}
}
