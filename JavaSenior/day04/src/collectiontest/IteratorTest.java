package collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/9 19:53
 *
 * 使用Iterator接口遍历集合元素
 *
 * 集合元素的遍历操作：使用迭代器Iterator接口
 * 1.内部的方法：hasnext() 和 next();
 * 2.集合对象每次调用iterator()都得到一个全新的迭代器对象，默认游标在集合的第一个元素之前
 * 3.接口内部定义了remove(),可以在遍历的时候删除指定元素
 *
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("aaa");
        coll.add(new String("Tom"));
        coll.add(new Animal("snake", 12));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式三：******常用******
        //iterator.hasnext();用来判断集合中下一个是否还有元素
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二：不常用
//        for (int i = 0;i < coll.size();i++){
//            System.out.println(iterator.next());
//        }

        //方式一：  几个元素就几条语句，超出则报错！（不用）
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("aaa");
        coll.add(new String("Tom"));
        coll.add(new Animal("snake", 12));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object b1 = iterator.next();
            if (b1.equals("aaa")){
                iterator.remove();
            }
        }

        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
