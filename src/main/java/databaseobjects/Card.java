package databaseobjects;

public class Card {

	private String name;
	private String className;
	private int count;

	public Card(String name, String className) {
		this.name = name;
		this.className = className;
		this.count = 0;
	}

	public Card(String name, String className, int count) {
		this.name = name;
		this.className = className;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}
