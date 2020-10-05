import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>(5);
//		list.add(1);
//		list.add(2);
//		list.add(5);
//		list.add(5);
//		list.add(3);
//		list.add(9);
//		list.add(6);
//		System.out.println(list.size());
//		
//		Collections.sort(list);											//Sắp xếp
//		System.out.println(list);
//		System.out.println(list.get(2));

//		ArrayList<Person> list = new ArrayList<Person>();
//		list.add(new Person("A",8));
//		list.add(new Person("B",7));
//		list.add(new Person("C",6));
//		list.add(new Person("D",7));
//		Collections.sort(list,new SortByMark().thenComparing(new SortByName()));			//Sắp xếp theo điểm rồi sắp xếp tiếp theo tên
//
//		for (Person person : list) {
//			System.out.println(person.getName());
//		}

		Person<String> per1 = new Person<String>("A", 7, "a1");
		
		Integer[] list1 = {1,2,3};
		String[] list2 = {"a","b","c"};
		per1.printOut(list1);
	}
}
