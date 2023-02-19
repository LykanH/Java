package comparetest;

import java.util.Arrays;

/**
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/26 16:49
 * 一、说明：Java中的对象，正常情况下，只能进行比较：== 或 ！= （用来比较引用地址是否一致）
 *      。不能使用>、<,但是在开发环境中，我们需要对多个对象进行排序。言外之意，就需要比较对象
 *      的大小。如何实现？使用两个接口的任意一个：Comparable 或 Comparator
 *
 *    Comparable接口的应用实例：
 *    1.像String、包装类等实现了Comparable接口，重写了ComparTo(obj)的方法，给出了
 *    2.像String、包装类重写comparaTo()方法以后，进行了从小到大的排列
 *    3.重写comparTo(obj)的规则：
 *          如果当前对象this大于形参对象obj，则返回正整数
 *          如果当前对象this小于形参对象obj，则返回负整数
 *          如果当前对象this等于形参对象obj，则返回0
 *    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口,重写ComparTo()的方法
 *          在CompareTO中指明如何排序
 *
 * 将一个类进行自然排序
 *      自然排序
 *      从小到大排序
 */
public class CompareTest {
    public static void main(String[] args) {
        //String 实现了Comparable 接口
        String[] strings = new String[]{"aa","k","1","mm","BB","zz","bb"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        Goods[] goods = new Goods[4];
        goods[0] = new Goods("one",53);
        goods[1] = new Goods("two",28);
        goods[2] = new Goods("three",78);
        goods[3] = new Goods("four",14);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}

class Goods implements Comparable{
    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方式1：
            if (this.price != goods.price) {
                return this.price > goods.price ? 1 : -1;
            }else {
                return 0;
            }
            //方式2：
//            return Integer.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据不一致");
    }
}