package quicksort;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/18 0:09
 * v3.0
 * 快速排序的实现！
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = new int[]{9, 3, 5, 4, 8, 7, 6};
        quickSort(ints, 0, (ints.length - 1));
    }

    public static void quickSort(int[] ints, int head, int length) {
        if (head < length) {
            int p = partition(ints, head, length);
            quickSort(ints, head, p+1);
            quickSort(ints, p + 3, length);
        }
    }

    private static int partition(int[] ints, int head, int length) {
//        int rail = ints[length - 1];
//        int i = -1, j = length + 1;
        int leftBound = head - 1, i = leftBound + 1;
//        int rightNum = ints[head + length - 1];

        while (i < length) {
            if (ints[i] <= ints[head + length]) {
                sort(ints, leftBound + 1, i);
                i++;
                leftBound++;
            } else {
                i++;
            }
        }
        sort(ints, leftBound + 1, length);

        return leftBound;
    }


    public static void sort(int[] ints, int i, int j) {
        int empt;
        empt = ints[i];
        ints[i] = ints[j];
        ints[j] = empt;
    }
}
