package test;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/25 20:32
 */
public class Test8 {
    @Test
    public void test1() throws IOException {
        ObjectOutputStream oos = null;
        try {
            //实例化Properties
            Properties properties = new Properties();
            properties.load(new FileReader("src\\dog.properties"));
            String name = properties.getProperty("name");
            int age = Integer.parseInt(properties.getProperty("age"));
            String color = properties.getProperty("color");
            Dog dog = new Dog(name,age,color);



            oos = new ObjectOutputStream(new FileOutputStream(new File("Dog.txt")));
            oos.writeObject(dog);
            oos.flush();
            oos.writeObject(new String("立刻!"));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
//            bis = new BufferedInputStream(new ObjectInputStream(new FileInputStream(new File("dog.txt"))));
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("dog.txt"))));

            Dog dog = (Dog) ois.readObject();
            String s1 = (String) ois.readObject();
            System.out.println("name = " + dog.getName() + ",age = " + dog.getAge() + ",color = " + dog.getColor());
            System.out.println(s1);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

class Dog implements Serializable {
    private static final long serialVersionUID = -684979445675710L;
    private String name;
    private int age;

    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

