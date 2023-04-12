package collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/9 21:03
 *
 * jdk5.0新增了foreach循环，用来遍历集合和数组；
 *
 * foreach内部其实还是用的迭代器
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("aaa");
        coll.add(new String("Tom"));
        coll.add(new Animal("snake", 12));
        coll.add(false);

        //遍历coll集合中的元素
        //for(集合中元素的类型 形参（通过迭代器将元素赋给形参） : 需要遍历的集合)
        for (Object obj : coll){
            System.out.println(obj);
        }

        int[] ints = new int[]{1,2,3,4,5,6};
        for (int i : ints){
            System.out.println(i);
        }
    }


    //面试题：体会foreach 不能更改原数组内部的元素内容。

    @Test
    public void test2(){
        String[] strings = new String[]{"aa","aa","aa"};

        //可以更改元素组中的元素内容
//        for (int i = 0; i < strings.length; i++) {
//            strings[i] = "bb";
//        }

        //不会更改原数组中的内容，因为s是一个形参，foreach中改变的只是形参所对应的值，而原来的
        //数组中的内容并不会改变。
        for (String s : strings){
            s = "bb";
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            
        }
    }
}
