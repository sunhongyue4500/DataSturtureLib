package priorityQueue;

public class Person implements Comparable<Person>{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

}
