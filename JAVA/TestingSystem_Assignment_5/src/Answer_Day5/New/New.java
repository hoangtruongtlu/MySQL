package Answer_Day5.New;

public class New implements INew {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;

	public New(int id, String title, String publishDate, String author, String content, float averageRate) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
	}

	public New() {	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	@Override
	public void Display() {
		System.out.println(getTitle() + "\n" + getPublishDate() + "\n" + getAuthor() + "\n" + getContent() + "\n"
				+ getAverageRate());
	}

	@Override
	public float Calculate() {
		int[] rates = new int[3];
		for (int i = 0; i < rates.length; i++) {
			averageRate = averageRate + i;
		}
		return averageRate = averageRate/3;
	
	}

}
