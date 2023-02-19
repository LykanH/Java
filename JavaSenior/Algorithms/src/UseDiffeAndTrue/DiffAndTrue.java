package UseDiffeAndTrue;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/20 22:10
 * 功能：一种数出现了奇数次，另N种数出现了偶数次求这个奇数是什么
 */
public class DiffAndTrue {
    public static void main(String[] args) {
        int a = 0;
        int[] ints = new int[]{4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 3, 3, 3, 3};
        for (int i = 0; i < ints.length; i++) {
            a ^= ints[i];
        }
        System.out.println(a);
    }
}
