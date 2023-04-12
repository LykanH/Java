package comparetest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/26 18:39
 * 与自然排序类似的：定制排序
 *
 *      定制排序
 */
public class MakeSort {
    public static void main(String[] args) {
        String[] strings = new String[]{"aa","k","1","mm","BB","zz","bb"};
        Arrays.sort(strings, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);//compareTo默认为从小到大排序，定制排序可以实现从大到小排序
                }
                throw new RuntimeException("类型错误，请重新输入");
            }

        });
        System.out.println(Arrays.toString(strings));
    }
}
