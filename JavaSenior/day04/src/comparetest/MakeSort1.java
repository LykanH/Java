package comparetest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/26 18:47
 *
 * 将一个类进行定制排序
 */
public class MakeSort1 {
    public static void main(String[] args) {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("one",53);
        goods[1] = new Goods("two",28);
        goods[2] = new Goods("three",78);
        goods[3] = new Goods("three",700);
        goods[4] = new Goods("four",14);

        Arrays.sort(goods, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())){
                        return Integer.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("类型输入错误，请重新输入");
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
