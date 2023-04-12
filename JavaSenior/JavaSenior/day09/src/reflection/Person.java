package reflection;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/8 22:02
 */
public class Person  {
    private String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }
    private Person(String name){
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //私有方法
    private String nation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
    public void show(){
        System.out.println("我是一个people！");
    }
    public static void betuful(){
        System.out.println("这是一个静态方法！");
    }
}
