package Answer_day4.Ex4;

public class Account {
	private int id;
	private String name;
	private int balance;
	
	public Account(int id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	
	public void credit(int amount) {
	}
	
	public void debit(int amount) {
	}
	
	public void tranferTo(Account account,int amount) {
		
	}
}
