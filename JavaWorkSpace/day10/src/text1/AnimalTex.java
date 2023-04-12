package text1;

public class AnimalTex {
	public static void main(String[] args) {

		AnimalTex ani1 = new AnimalTex();
		ani1.fun(new dog());  		//Animal ani1 = new dog
		ani1.fun(new cat());

	}

	public void fun(Animal animal) { 
		animal.eat();
		animal.shout();
	}
}

class Animal {
	public void eat() {
		System.out.println("动物进食");

	}

	public void shout() {
		System.out.println("动物叫");
		System.out.println();
	}

}

class dog extends Animal {
	public void eat() {
		System.out.println("狗吃骨头");
	}

	public void shout() {
		System.out.println("汪汪汪");
		System.out.println();
	}
}

class cat extends Animal {
	public void eat() {
		System.out.println("猫吃鱼");
	}

	public void shout() {
		System.out.println("喵喵喵");
		System.out.println();
	}
}