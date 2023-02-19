package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/27 21:27
 * //创建一个不重复的随机数组，长度为20位
 */
public class Test2 {
    @Test
    public void test1() {
        long startTime = System.currentTimeMillis();
        Object[] ints = new Object[20];
//        int[] ints = new int[20];

        LinkedHashSet linkedHashSet = new LinkedHashSet();

        while (linkedHashSet.size() < 20) {
            linkedHashSet.add((int) (Math.random() * 20 + 1));
        }
        ints = linkedHashSet.toArray();
        System.out.println(Arrays.toString(ints));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    @Test
    public void test2() {
        //网上方法获取不重复随机数
        long startTime = System.currentTimeMillis(); //开始测试时间
        Random random = new Random();
        int a[] = new int[20];//随机数组
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(15,40);
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {//如果重复，退回去重新生成随机数
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("网上思路代码运行时间： " + (endTime - startTime) + "ms");
    }
}
