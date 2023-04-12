package UseDiffeAndTrue;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/22 20:34
 * 功能：两种数出现了奇数次，另N种数出现了偶数次求这两个奇数是什么
 * 假设两个奇数分别为a,b
 */
public class DiffAndTrue2 {
    public static void main(String[] args) {
        int arr = 0;
        int[] ints = new int[]{1,1,1,1,1,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5};
        for (int i = 0; i < ints.length; i++) {
            arr ^= ints[i];         //arr = a ^ b;  其中arr(32位)至少有一位不为零
        }
        int rightOne = arr & (~arr + 1);        //取出最右侧为一的位

        int arr1 = 0;
        for (int i = 0; i < ints.length; i++) {
            if ((ints[i] & rightOne) == 0) {
                arr1 ^= rightOne;       //此时arr1为a或者b
            }
        }
        System.out.println(arr1);       //假设arr1为a 且 arr = a ^ b
        System.out.println(arr ^ arr1);     //所以 b = arr1 ^ arr = a ^ a ^ b
    }
}
