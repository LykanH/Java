package AbstractTest;

public class EmpManTest {
	public static void main(String[] args) {
		Manager man1 = new Manager(192,"zahngsan",18,2000);
		System.out.println(man1.people()); 
		man1.work();
	}
}
