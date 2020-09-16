import java.util.Random;
import java.time.LocalDate;

public class Random_Number {

	public static void main(String[] args) {
		Random random = new Random();
//		Ques1
		int x = random.nextInt();
		System.out.println(x);
		
//		Ques2
		float y = random.nextFloat();
		System.out.println(y);
		
//		Ques3
		String[] name = { "Truong", "Hieu", "Son" };
		System.out.println(name[1]);
		
//		Ques4
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
		
//		Ques5
		int now = (int) LocalDate.now().toEpochDay();
		randomInt = now - random.nextInt(365);
		randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
		
//		Ques6
		now = (int) LocalDate.now().toEpochDay();
		randomInt = now - random.nextInt(now);
		randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
		
//		Ques7
		int z = random.nextInt(900)+100;
		System.out.println(z);
	}

}
