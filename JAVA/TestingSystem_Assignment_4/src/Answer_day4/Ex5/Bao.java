package Answer_day4.Ex5;

public class Bao extends TaiLieu{
	private int ngayPhatHanh;
	
	public Bao(String code, String name, int number,int day) {
		super(code, name, number);
		this.ngayPhatHanh = day;
	}
}
