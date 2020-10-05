import java.util.Comparator;

public class SortByMark implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getMark() > o2.getMark()) {
			return 1;
		}
		else if (o1.getMark()<o2.getMark()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
