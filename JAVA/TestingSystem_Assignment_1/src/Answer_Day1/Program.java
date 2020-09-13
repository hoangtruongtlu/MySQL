package Answer_Day1;
import java.time.*;

public class Program {

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
		group1.createdate = LocalDate.now();
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Junior";
		group2.createdate = LocalDate.now();
		
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
		account1.createdate = LocalDate.now();
		account1.groups = new Group[] {group1, group2};
		
		Account account2 = new Account();
		account2.id = 2;
		account2.email = "trunghieu@gmail.com";
		account2.username = "trunghieu99";
		account2.fullname = "Nguyễn Trung Hiếu";
		account2.position = position2;
		account2.department = department2;
		account2.createdate = LocalDate.now();
		account2.groups = new Group[] {group1, group2};
		
//		Print Department
		System.out.println("Department 1: ");
		System.out.println("ID: " + department1.id);
		System.out.println("Name: " + department1.name + "\n");
		
		System.out.println("Department 2: ");
		System.out.println("ID: " + department2.id);
		System.out.println("Name: " + department2.name + "\n");
		
//		Print Group
//		System.out.println("Group 1: ");
//		System.out.println("ID: " + group1.id);
//		System.out.println("Name: " + group1.name);
//		System.out.println("Create Date: " + group1.createdate);
//		
//		System.out.println("Group 2: ");
//		System.out.println("ID: " + group2.id);
//		System.out.println("Name: " + group2.name);
//		System.out.println("Create Date: " + group2.createdate);
		
//		Print Positon
//		System.out.println("Positon 1: ");
//		System.out.println("ID: " + position1.id);
//		System.out.println("Name: " + position1.name);
//		
//		System.out.println("Positon 2: ");
//		System.out.println("ID: " + position2.id);
//		System.out.println("Name: " + position2.name);
		
//		Print Account
		System.out.println("Account 1:");
		System.out.println("ID: " + account1.id);
		System.out.println("Email: " + account1.email);
		System.out.println("User Name: " + account1.username);
		System.out.println("Full Name: " + account1.fullname);
		System.out.println("Department Name: " + account1.department.name);
		System.out.println("Posiion Name: " + account1.position.name);
		System.out.println("Create Date: " + account1.createdate);
		System.out.println("Group: " + account1.groups[1].name);
	}		
}
