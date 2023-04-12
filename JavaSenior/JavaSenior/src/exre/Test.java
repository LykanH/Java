package exre;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/20 21:51
 * 测试代码使用 随时删除代码
 *
 * //多态的测试与理解：多态的实现（即向上转型：父类的引用指向子类的对象。）被向上转型之后的实例化对象
 * 调用方法时：1.如果该方法被子类重写，则调用子类重写后的方法。
 *            2.不能调用子类中特有的方法。
 *            3.父类中特有的方法可以被该对象调用。
 *
 *            多态对象向下转型之后可以调用自身特有的方法，同时也可以调用父类中特有的方法！
 */
public class Test {
    static String b;
    public static void main(String[] args) {
        Animal a1 = new Cat();
        a1.eat();
        a1.speak();

        System.out.println("************");
        Cat c1 = (Cat)a1;   //多态对象向下转型之后可以调用自身特有的方法，同时也可以调用父类中特有的方法！
        c1.speak();
        c1.run();
        c1.eat();

        System.out.println("******************");
        Animal a2 = new Dog();
        a2.eat();
    }
}

class Animal{
    public void eat(){
        System.out.println("Animal eat!");
    }
    public void speak(){
        System.out.println("Animal speak!");
    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("Cat eat!");
    }
    public void run(){
        System.out.println("Cat run!");
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("Dog eat!");
    }
    public void run(){
        System.out.println("Dog run!");
    }
}

