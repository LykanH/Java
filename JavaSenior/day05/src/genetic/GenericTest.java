package genetic;

import org.junit.Test;

import java.util.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/1 20:56
 * <p>
 * 泛型的使用
 * 1.jdk 5.0新增特性
 *
 * 2.在集合中使用泛型
 * 总结：
 *      ① 集合接口或集合接口在jdk5.0时都修改为带泛型的结构
 *      ② 在实例化集合时，可以知名具体的泛型类型
 *      ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（方法、属性、构造器）使用到类的泛型的位置，都指定为 实例化时泛型类型
 *      ④ 泛型的类型必须是个类  不能为基本数据类型，若使用基本数据类型必须使用其包装类
 *
 */
public class GenericTest {
    @Test
    public void test3(){
        //Map中使用泛型（需要两个泛型，key-value）
        Map<String,Integer> map = new HashMap<String, Integer>();

        map.put("Tom",78);
        map.put("Lisa",73);
        map.put("Amy",89);
        map.put("DM",78);

        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator =  entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.printf("%s--->%d\n",next.getKey(),next.getValue());
        }


    }
    @Test
    public void test2() {
        ArrayList<Integer> score = new ArrayList<Integer>();//使用泛型确定数组中存入的值为什么类型，
                                                            // 但必须是包装类，不能是基本数据类型
        score.add(49);
        score.add(75);
        score.add(83);
        score.add(67);
//        score.add("tom");//编译报错

        for (Integer score1: score){
            int sc = score1;
            System.out.println(sc);
        }
    }


    @Test
    public void test1() {
        ArrayList score = new ArrayList();

        //score中存放的值为分数
        score.add(49);
        score.add(75);
        score.add(83);
        score.add(67);
        //假设填写错误，编译不会报错
        score.add("tom");

        for (Object obj : score) {
            int score1 = (Integer) obj;     //当遍历到字符串时即报错ClassCastException,为了避免运行时错误加入了泛型
            System.out.println(score1);
        }

    }
}
