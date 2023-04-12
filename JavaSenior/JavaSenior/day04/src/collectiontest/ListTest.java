package collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/9 22:13
 * <p>
 * /----Collection接口:单列集合，用来存储一个一个的对象
 *      ----List接口:存储有序的、可重复的数据。-->“动态”数组，替换原有的数组
 *          ---ArrayList:作为List接口的主要实现类，线程不安全的，效率高;  底层使用Object[ ] elementData存储
 *          ----LinkedList:对于频繁的插入、删除操作，使用此类效率比ArrayList高;底层使用双向链表存储
 *          ----Vector:作为List接口的古老实现类;线程安全的，效率低;    底层使用object[] eLementData存储
 * <p>
 * 面试题: ArrayList、LinkedList. Vector三者的异同?
 * 同:三个类都是实现了List接口，存储数据的特点相同:存储有序的、可重复的数据不同:
 * 不同：在上边说明！
 */
public class ListTest {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("aaa");
        list.add(new String("Tom"));
        list.add(new Animal("snake", 12));
        list.add(false);

        System.out.println(list);

        //1.    add(int index , Object obj);在集合指定角标上插入指定的内容obj。
        list.add(2, true);
        System.out.println("角标为2的位置插入true：\n" + list);

        Collection collection = Arrays.asList("aaa", 245);
        //2.    addAll(int index,Collection coll);从index位置将coll中的所有元素添加进来
        list.addAll(5,collection);
        System.out.println("集合中插入另外一个集合：" + list);

        //3.    get(int index);获取指定位置上的元素，返回类型为Object类型
        System.out.println("二号位置上内容：" + list.get(2));

        //4.    indexOf(Object obj);返回obj在集合中第一次出现的位置；返回值为int型,未找到返回-1
        int indexOf = list.indexOf("Tom");
        System.out.println(indexOf);
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("aaa");
        list.add(new String("Tom"));
        list.add(new Animal("snake", 12));
        list.add("aaa");
        list.add(false);

        //5.    lastIndexOf(Object obj);返回最后一个出现obj的位置;
        int lastIndexOf = list.lastIndexOf("aaa");
        System.out.println(lastIndexOf);

        //6.    remove(int index);移除指定位置上的元素，返回值为该位置上的元素，类型为Object；
        Object remove = list.remove(4);
        System.out.println(remove);

        //7.    set(int index,Object obj);设置指定位置上的元素为obj
        list.set(4, "ypb");
        System.out.println(list);

        //8.    subList(int fromIndex,int lastIndex);返回从fromIndex到lastIndex之间(左闭右开)的子集合；
        List list1 = list.subList(1, 3);
        System.out.println(list1);

    }
}
