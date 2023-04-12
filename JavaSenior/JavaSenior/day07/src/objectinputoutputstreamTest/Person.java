package objectinputoutputstreamTest;

import java.io.Serializable;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/7 20:56
 */
public class Person implements Serializable {
    //Person需要满足如下的要求方可序列化
    //1.需要实现接口 Serializable
    //2.为当前类提供一个序列号serialVersionUID（全局常量）
    //3.除了当前Person类实现Serializable接口之外，还必须保证其内部所有属性也必须可序列化
    //4.（默认情况下，基本数据类型可序列化）
    //5.ObjectInputStream和ObjectOutputStream不能序列化static(本身不归某个对象所有)和transient修饰的成员变量

    //如果不加序列号,它的值是Java运行时环境根据类的内部细节自动生成的。
    //若类的实例变量做了修改，serialVersionUID可能发生变化，即没法还原原来的实例化对象
    public static final long serialVersionUID = 386463652L;

    private String name;
    private int age;
    private int weight;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
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
}
