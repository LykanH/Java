package Test;

import java.util.Arrays;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/13 20:02
 */
public class BubbleTest {
    public static void main(String[] args) {
        int[] a = new int[]{14, 23, 2, 3, 1, 25, 45, 12, 13};
        bubble(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubble(int a[]) {
//        int temp;
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = 0; j < a.length - i - 1; j++) {
//                if (a[j] > a[j + 1]) {
//                    temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                }
//            }
//        }
        //完成
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                }
            }
        }
    }
}
