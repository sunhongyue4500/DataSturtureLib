package priorityQueue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] persons = new Person[]{
				new Person("sun"),
				new Person("hong"),
				new Person("yi"),
				new Person("wang"),
				new Person("zan"),
				new Person("an"),
		};
		MaxPQ<Person> pq = new MaxPQ<>(persons);
		System.out.println(pq.max());
		System.out.println(pq.size());
		System.out.println(pq.delMax());
		System.out.println(pq.max());
		System.out.println(pq.size());
	}

}
