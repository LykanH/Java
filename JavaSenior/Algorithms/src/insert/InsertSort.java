package insert;

import java.util.Arrays;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/24 20:42
 * 插入排序实现
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = new int[]{9, 3, 5, 4, 8, 7, 9};
        if (ints.length < 2 && ints == null) {
            return;
        }
        for (int i = 1; i < ints.length; i++) {
            for (int j = i - 1; j > -1 && ints[j] > ints[j + 1]; j--) {
                swap(ints, j, j + 1);
            }
        }
        System.out.println(Arrays.toString(ints));

    }

    private static void swap(int[] ints, int i, int j) {
        ints[i] = ints[i] ^ ints[j];
        ints[j] = ints[i] ^ ints[j];
        ints[i] = ints[i] ^ ints[j];
    }
}
