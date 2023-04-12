package quicksort;

import java.util.Arrays;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/18 19:36
 */
public class QuickSort3 {
    public static void main(String[] args) {
        int[] ints = new int[]{9, 3, 5, 4, 8, 7, 6};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    public static void quickSort(int[] ints, int L, int R) {
        if (L < R) {
            swap(ints, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(ints, L, R);
            quickSort(ints, L, p[0] - 1);
            quickSort(ints, p[1] + 1, R);

        }
    }

    public static int[] partition(int[] ints, int L, int R) {
        int less = L - 1;//小于区you边界
        int more = R;//大于区左边界
        while (L < more) {
            if (ints[L] < ints[R]) {
                swap(ints, ++less, L++);
            } else if (ints[L] > ints[R]) {
                swap(ints, --more, L);
            } else {
                L++;
            }
        }
        swap(ints, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] ints, int i, int j) {
        int empt;
        empt = ints[i];
        ints[i] = ints[j];
        ints[j] = empt;
    }
}
