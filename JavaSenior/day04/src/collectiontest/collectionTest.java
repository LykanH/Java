package collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一、集合框架的概述
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,数据库中）
 * 2.1数组在存储多个数据方面的特点：
 *         > 一旦初始化以后 其长度就确定了
 *         > 数组一旦定义好，其元素的类型也就确定了。我们也就就只能操作指定类型的数据
 *         比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 提单初始化以后，其长度就不能被修改
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 *      > 获取数组中实际元素个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点，有序，可重复，对于无须不可重复的需求，不能满足
 *
 * 二、集合框架
 *     ----Collection接口：单列集合，用来存储一个一个的对象
 *          ----List接口：存储有序的，可重复的数据     ”List又称为   动态数组“
 *              ----ArrayList、LinkedList、Vector
 *          ----Set接口：存储无序的，不可重复的数据
 *
 *     ----Map接口：双列集合，用来存储一对（key-value）一对的数据
 *
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/26 19:41
 * 集合的实例化和简单使用
 */
public class collectionTest {
//    public static void main(String[] args) {
//    }
    @Test
    public void test1(){
//        System.out.println(123);
//        Date d1 = new Date();
//        System.out.println(d1);
        Collection coll = new ArrayList();

        //1.    add(Object obj)
        //add(Object o):将元素添加到集合中去
        coll.add("123");
        coll.add("acv");
        coll.add("sad");
        coll.add(222);
        coll.add(new Date());
        //2.    size()获取集合元素的个数
        System.out.println(coll.size());

        Collection coll1 = new ArrayList();
        coll1.add("ccc");
        coll1.add("bbb");
        //4.    将coll1中所有元素添加到coll集合中去
        coll.addAll(coll1);

        System.out.println(coll.size());

        //5.    输出集合中各个元素
        System.out.println(coll.toString());

    }
}
