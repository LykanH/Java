package collectionsettest;

import org.junit.Test;

import java.util.*;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/10 19:56
 * <p>
 * <p>
 * 1.Set接口的框架：
 * ----Collection接口：单列集合，用来存储一个一个的对象
 *      ----set接口：存储无序的、不可重复的数据（类似于高中讲的集合）
 *          ----HashSet：作为Set接口的主要实现类；线程不安全的，可用于存放null值
 *              ----linkHashSet：作为HashSet的子类，遍历其内部数据时，可以按照添加时候的顺序进行遍历
 *          ----TreeSet：可以按照添加对象的指定属性，进行排序(类似于对类按照类中的某些属性进行排序)；
 * <p>
 * 2.Set中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 * <p>
 * Set：存储无序的，不可重复的数据
 * 以HashSet为例说明：
 * 1.无序性：不等于随机性，存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
 * 2.不可重复性：保证添加的元素按照equals判断时不能返回true，即相同的元素只能添加一个
 *
 *
 *     *****
 *     我们向HashSet中添加元素a时，需要调用元素a中所在类的hsahCode方法计算元素a的hash值
 *     此hash值通过某种算法计算出元素a在HashSet底层数组中存放的位置（即：索引位置），判断
 *     该位置上是否已经有元素
 *           如果此位置上没有其他元素，则元素a添加成功！ ----情况1
 *           如果此位置上有其他元素b(或以链表形式存在多个元素)，则比较a和b的hash值
 *                  如果hash值不相同，则元素a添加成功 ----情况2
 *                  如果hash值相同，则调用元素a的equals方法进行比较；
 *                         euals()返回true，则a插入失败，
 *                         euals()返回false，则a插入成功，----情况3
 */
public class SetTest {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add("aaa");
        set.add("bcd");
        set.add(123);
        set.add(123);
        set.add(true);
        set.add(new Animal("cat", 12));
        set.add(new Animal("cat", 12));      //如果没有重写该类中的equals方法则将会有两个相同的
        // Animal类，因为其地址值不同。

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    //LinkedHashSet 的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录数据的前一个数据和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet的效率要高于HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add("aaa");
        set.add("bcd");
        set.add(123);
        set.add(123);
        set.add(true);
        set.add(new Animal("cat", 12));
        set.add(new Animal("cat", 12));

        //调用set集合中的iterator方法，返回set的迭代器，使用迭代器来遍历数组
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
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
