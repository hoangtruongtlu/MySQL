package Answer_day4.Ex5;

public class TapChi extends TaiLieu {
	private int soPhatHanh;
	private int thangPhatHanh;
	
	public TapChi(String code, String name, int number,int numberRelease,int monthRelease) {
		super(code, name, number);
		this.soPhatHanh = numberRelease;
		this.thangPhatHanh = monthRelease;
	}
}
