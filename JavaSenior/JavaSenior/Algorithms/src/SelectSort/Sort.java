package SelectSort;

import java.util.Arrays;

/**
 *
 * 简单排序练习：选择排序
 * @author muchen
 * @create 2022 - 09 - 2022/9/16 10:56
 */
public class Sort {
    public static void main(String[] args) {

        //System.currentTimeMillis()  返回当前时间距离1970年1月1日的毫秒数
        long time1 = System.currentTimeMillis();
        int[] a = new int[200];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * a.length + 1);
        }
        System.out.println("数组初始顺序为：" + Arrays.toString(a));

        //开始排序

        for (int i = 0; i < a.length; i++) {
            int minnum = i;             //设数组第i个位置上所对应的数最小
            for (int j = i + 1;j < a.length;j++){
                minnum = a[minnum] < a[j] ? minnum : j;
            }
            swap(a,i,minnum);
        }
        System.out.println(Arrays.toString(a));
//        long time2 = System.currentTimeMillis();
        System.out.println("程序执行时间是：" + (System.currentTimeMillis() - time1));

    }

    public static void swap(int[] a, int i, int minnum){
        int empt;
        empt = a[i];
        a[i] = a[minnum];
        a[minnum] = empt;
    }
}
