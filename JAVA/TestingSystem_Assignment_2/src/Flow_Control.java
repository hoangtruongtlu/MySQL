import java.time.LocalDate;

public class Flow_Control {

	public static void main(String[] args) {
//		Create Department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";
		
		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

//		Create Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Fresher";
		group1.createdate = LocalDate.of(2020, 04, 01);
		 
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Junior";
		group2.createdate = LocalDate.of(2020, 04, 01);
		
//		Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Dev";

		Position position2 = new Position();
		position1.id = 2;
		position1.name = "Test";
		
//		Create Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "hoangtruong@gmail.com";
		account1.username = "hoangtruong97";
		account1.fullname = "Hoàng Văn Trường";
		account1.position = position1;
		account1.department = department1;
		account1.createdate = LocalDate.of(2020, 04, 01);
		account1.groups = new Group[] {group1};
		
		Account account2 = new Account();
		account2.id = 2;
		account2.email = "trunghieu@gmail.com";
		account2.username = "trunghieu99";
		account2.fullname = "Nguyễn Trung Hiếu";
		account2.position = position2;
		account2.department = department2;
		account2.createdate = LocalDate.of(2020, 04, 01);
		account2.groups = new Group[] {group1, group2};
		
//		Add Account to Group
		Account[] AccOfGroup1 = {account1,account2};
		group1.accounts = AccOfGroup1;
		
//		Ques1
		if (account2.department == null ) {
			System.out.println("Nhân viên này chưa có phòng ban");
		}
		else
			System.out.println("Phòng ban của nhân viên này là " + account2.department.name);
		
//		Ques2
		if (account2.groups == null || account2.groups.length == 0) {
			System.out.println("Nhân viên này chưa có group");
		}
		else if(account2.groups.length == 1) {
			System.out.println("Group của nhân viên này là " + account2.groups[0].name);
		}
		else if(account2.groups.length == 2) {
			System.out.println("Group của nhân viên này là " + account2.groups[0].name + ", " + account2.groups[1].name);
		}
		else if(account2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		}
		else 
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		
//		Ques3
		System.out.println(account2.department.name == null ? "Nhân viên chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + account2.department.name);
		
//		Ques4
		System.out.println(account1.position.name == "Dev" ? "Đây là Developer"
				: "Người này không phải là  Developer");
		
//		Ques5
		int x = group1.accounts.length;
		switch (x) {
			case 1:
				System.out.println("Nhóm có một thành viên");
					break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
					break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
					break;
			default:
				System.out.println("Nhóm có nhiều thành viên");
			}
		
//		Ques6
		int y = account2.groups.length;
		switch (y) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
				break;
		case 1:
			System.out.println("Group của nhân viên này là " + account2.groups[0].name);
				break;
		case 2:
			System.out.println("Group của nhân viên này là " + account2.groups[0].name + ", " + account2.groups[1].name);
				break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả group");
		}
		
//		Ques7
		String z = account1.position.name;
		switch (z) {
		case "Dev":
			System.out.println("Đây là Developer");
				break;
		default:
			System.out.println("Đây không phải là Developer");
		}
		
//		Ques8
		Account[] accounts = {account1, account2};
		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullname);
			System.out.println("Name Department: " + account.department.name);
		}
		
//		Ques9
		Department[] departments = {department1,department2};
		for (Department department : departments) {
			System.out.println("ID: " + department.id);
			System.out.println("Name: " + department.name);
		}
		
//		Ques10
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i+1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
		}
		
//		Ques11
		for (int i = 0; i < departments.length; i++) {
			System.out.println("Thông tin department thứ " + (i+1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}
		
//		Ques12
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i+1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}
		
//		Ques13
		for (int i = 0; i < accounts.length; i++) {
			if (i!=1) {
				System.out.println("Thông tin account thứ " + (i+1) + " là :");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Fullname: " + accounts[i].fullname);
				System.out.println("Department: " + accounts[i].department.name);
			}
		}
		
//		Ques14
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i+1) + " là :");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Fullname: " + accounts[i].fullname);
				System.out.println("Department: " + accounts[i].department.name);
			}
		}
		
//		Ques15
		for (int i = 2; i <= 20; i += 2) {
			System.out.println(i);
		}
		
//		Ques16-10
		int i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin account thứ " + (i+1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		}
		
//		Ques16-11
		i = 0;
		while (i < departments.length) {
			System.out.println("Thông tin department thứ " + (i+1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}
		
//		Ques16-12
		i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i+1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}
		
//		Ques16-13
		i = 0;
		while (i < accounts.length) {

			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i+1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		}
		
//		Ques16-14
		i = 0;
		while (i < accounts.length) {

			if (i >= 4) {
				i++;
				break;
			}
			System.out.println("Thông tin account thứ " + (i+1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		}
		
//		Ques16-15
		i = 0;
		while (i<=20) {
			System.out.println(i);
			i += 2;
		}
	}
}	
		
