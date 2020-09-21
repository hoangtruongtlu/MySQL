package Answer_day4.Ex5;

public class Sach extends TaiLieu {
	private String nameWriter;
	private int numberOfPage;
	
	public Sach(String code, String name, int number,String nameWriter,int numberPage) {
		super(code, name, number);
		this.nameWriter = nameWriter;
		this.numberOfPage = numberPage;
	}
}
