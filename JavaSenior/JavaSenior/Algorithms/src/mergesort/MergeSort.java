package mergesort;

import java.util.Arrays;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/24 20:40
 * 归并排序实现--->体现了分治法的使用
 * 两个process 一个merge
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = new int[]{9, 3, 5, 4, 8, 7, 9};
        int L = 0, R = ints.length - 1;
        process(ints, L, R);
        System.out.println(Arrays.toString(ints));
    }

    public static void process(int[] ints, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(ints, L, mid);
        process(ints, mid + 1, R);
        merge(ints, L, mid, R);
    }

    private static void merge(int[] ints, int l, int mid, int r) {
        int[] empt = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r){
            empt[i++] = ints[p1] <= ints[p2] ? ints[p1++] : ints[p2++];
        }
        while (p1 <= mid){
            empt[i++] = ints[p1++];
        }
        while (p2 <= r){
            empt[i++] = ints[p2++];
        }
        for (i = 0;i<empt.length;i++){
            ints[l + i] = empt[i];
        }
    }
}


//    public static void main(String[] args) {
//        int[] ints = new int[]{9, 3, 5, 4, 8, 7, 9};
//        int[] ints1 = new int[ints.length];
//        int mid = ints.length / 2, l = 0, r = ints.length - 1;
//        merge(ints, l, ints1, r );
//
//        System.out.println(Arrays.toString(ints));
////        for (int i = 0; i < ints.length; i++) {
////
////        }
//    }
//
//    private static void merge(int[] ints, int l, int[] ints1, int r) {
//        if (l < r) {
//            int mid = (l + r) / 2;
//            merge(ints, l, ints1, mid);
//            merge(ints, mid + 1, ints1, r);
//            sort(ints, l, mid, r, ints1);
//        }
//    }
//
//    private static void sort(int[] ints, int l, int mid, int r, int[] ints1) {
//        int i = 0, j = l, k = mid + 1;
//        while (j <= mid && k <= r) {
//            if (ints[j] < ints[k]) {
//                ints1[i++] = ints[j++];
//            } else {
//                ints1[i++] = ints[k++];
//            }
//        }
//
//        while (j < mid) {
//            ints1[i++] = ints[j++];
//        }
//
//        while (k < r) {
//            ints1[i++] = ints[k++];
//        }
//
//        for (int t = 0; t < r; t++) {
//            ints[t] = ints1[t];
////            System.out.println(l);
//        }
//    }