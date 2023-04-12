package collectiontest;

import org.junit.Test;

import java.util.*;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/27 23:47
 */
public class CollectionTest1 {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("aaa");
        coll.add(new String("Tom"));
        coll.add(new Animal("snake", 12));
        coll.add(false);

        boolean b1 = coll.contains(123);
        System.out.println(b1);

        //contains(Object obj);     判断集合中是否包含obj
        System.out.println("********" + coll.contains("Tom"));       //调用的是string中重写的equals方法。

        //调用的是类中的equals方法  如果类中没有重写equals方法，则调用的是Object中的equals方法（返回的是地址值）
        System.out.println(coll.contains(new Animal("snake", 12)));

        //Arrays.asList(可变形参)返回的是一个List，list是Collection的子接口，相当于使用了多态
        Collection coll1 = Arrays.asList(123, "aaa", "a");

        //判断两个集合中元素数量和元素内容是否一样，若完全一样返回true,否则返回false
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("aaa");
        coll.add(new String("Tom"));
        coll.add(new Animal("snake", 12));
        coll.add(false);

        System.out.println(coll.toString());

        //3.    remove(Object obj);  从集合中移除obj元素
        //去除集合中的某个元素，并返回一个Boolean值，即成功返回true，失败返回false
        System.out.println(coll.remove("aaa"));
        coll.remove(new Animal("snake", 12));
        System.out.println("remove后:" + coll.toString());

        //4.    removeAll(Collection coll);    差集： 移除两个集合共有的元素
        Collection coll1 = Arrays.asList(123, "aba", false);
//        coll.removeAll(coll1);
        System.out.println(coll.toString());

        //5.    retainAll(Collection coll);     交集：和差集相反，保留相同的元素，并将结果返回给调用方法的集合
        coll.retainAll(coll1);
        System.out.println("交集：" + coll.toString());

        //6.    equals(Collection coll);    想要返回true，需要当前集合和实参集合的元素内容和顺序都相同。
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add("aaa");
        coll2.add(new String("Tom"));
        coll2.add(new Animal("snake", 12));
        coll2.add(false);
        System.out.println(coll.equals(coll2));

        //7.    hashCode();返回当前对象的哈希值(任何对象都可调用)
        System.out.println(coll.hashCode());

        //8.    集合转化为数组：toArray();
        Object[] objects = coll.toArray();
        System.out.println("集合转换为数组后：" + Arrays.toString(objects));

        //拓展：数组转化为集合：调用Arrays类静态方法asList();
        List<Object> objects1 = Arrays.asList(new Object[]{"aa", "bb", "cc"});
        System.out.println("数组转化为集合：" + objects1);

        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);   //  int基本数据类型调用toString输出的是地址值，想要输出内容可以将其转化为Integer

        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integers);

    }
}

class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Animal{" +
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
}