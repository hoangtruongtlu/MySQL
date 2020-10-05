
public class Person<T> implements Comparable<Person> {
	private String name;
	private int mark;
	private T id;

	public Person() {
		super();
	}

	public Person(String name, int mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	
	public Person(String name, int mark, T id) {
		super();
		this.name = name;
		this.mark = mark;
		this.id = id;
	}

	
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public int compareTo(Person per) {
		if (this.name.compareTo(per.getName()) > 0) {
			return 1;
		} else if (this.name.compareTo(per.getName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public <T> void printOut(T[] list) {
		for (T t : list) {
			System.out.println(t);
		}
	}

}
