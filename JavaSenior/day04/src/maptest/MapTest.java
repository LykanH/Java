package maptest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/27 22:21
 * <p>
 * /----Map:双列数据，存储key-value对的数据    ---类似与高中的函数y = f(x)
 * /----HashMap:作为Map的主要实现类;线程不安全的，效率高；可以存储null的key和value
 * /----LinkHashMap:保证在遍历map元素的时候，可以按照添加元素的顺序进行遍历
 * 原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 * 对于频繁的遍历操作，此类执行效率高于HashMap
 * /----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历；此时考虑key的自然排序和定制排序
 * 底层使用的是红黑树
 * /----Hashtable:作为古老的实现类；线程安全的；效率低；不能存储null的key和value
 * /----Properties:常用来处理配置文件，key和value都是String类型
 * <p>
 * 二、map结构的理解：
 * map中的key：无序的、不可重复的；使用Set存储所有的key,key所在的类需要写equals()和hashCode() (以HashMap为例)
 * map中的value：无序的，可重复的；使用Collection存储所有的value，value所在的类需要写equals()
 * 一个键值对：key-value构成一个Entry对象
 * 一个Entry对象：无序的、不可重复的，使用Set存储所有的entry
 */
public class MapTest {
    //元视图操作的方法
    @Test
    public void test3() {
        HashMap hashMap = new HashMap();
        hashMap.put("aaa", 56);
        hashMap.put("bbb", 26);
        hashMap.put("ccc", 17);
        hashMap.put("ddd", 12);

        //Set keySet():返回所有key构成的Set集合
        Set keySet = hashMap.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        //Collection values():返回所有value构成的Collection集合
        for (Object value : hashMap.values()) {
            System.out.println(value);
        }


        //Set entrySet():返回所有key-value对构成的Set集合
        //方式一：
        Set entrySet = hashMap.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
//            System.out.println(entry);//调用entry中的toString方法
        }
        System.out.println();
        //方式二：
        Set keySet1 = hashMap.keySet();
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key = iterator1.next();
            Object value = hashMap.get(key);
            System.out.println(key + "====" + value);
        }
    }

    //元素查询的操作
    @Test
    public void test2() {
        HashMap hashMap = new HashMap();
        HashMap hashMap1 = new HashMap();
        hashMap.put("aaa", 56);
        hashMap.put("bbb", 26);
        hashMap.put("ccc", 17);
        hashMap.put("ddd", 12);

        //Object get(Object key):获取指定key对应的value
        System.out.println(hashMap.get("bbb"));
        System.out.println();

        //boolean containsKey(Object key):是否包含对应的key
        //boolean containsValue(Object value):是否包含对应的value
        System.out.println(hashMap.containsKey("aaa"));
        System.out.println(hashMap.containsKey("abc"));
        System.out.println();
        System.out.println("是否包含value为88的值:" + hashMap.containsKey("88"));
        System.out.println();

        //boolean equals(Object obj):判断当前map和参数对象obj是否相同
        System.out.println(hashMap.equals(hashMap1));

    }

    //添加、删除、修改操作
    @Test
    public void test1() {
        HashMap hashMap = new HashMap();
//        LinkedHashMap hashMap = new LinkedHashMap();

        //Object put(Object key,Object value):将指定的key-value添加到当前map对象中，如果key存在则修改map中key对应的value值
        hashMap.put("aaa", 56);
        hashMap.put("bbb", 26);
        hashMap.put("ccc", 17);
        hashMap.put("ddd", 12);
        hashMap.put("ddd", 123);
        System.out.println(hashMap);
        System.out.println();

        //void putAll(Map m):将m中的所有key-value对存放到当前map中
        HashMap hashMap1 = new HashMap();
        hashMap1.put("abc", 123);
        hashMap1.put("fff", 89);
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);
        System.out.println();

        //object remove(Object key):移除指定key对应的key-value对，并返回value
        Object remove = hashMap.remove("abc");
        System.out.println(remove);
        System.out.println(hashMap);
        System.out.println();

        //void clear():清空当前map中的所有数据
        hashMap.clear();
        System.out.println(hashMap.size());//0      clear之后不会报空指针异常
        System.out.println(hashMap.isEmpty());//true
    }
}
