package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/23 16:53
 * 三数之和
 */
public class Test6 {
    public static void main(String[] args) {
        int[] pro = new int[]{-4,-1,-1,0,1,2};
        Arrays.sort(pro);
        ArrayList<int[]> arrayList = new Test6().TreableNum(pro);
        System.out.println(arrayList.size());
        for (int[] ints : arrayList) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public ArrayList<int[]> TreableNum(int[] ints) {
        ArrayList<int[]> ansList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (i > 0 && ints[i] == ints[i - 1]) continue;
            int left = i + 1,right = ints.length - 1;
            while(left < right){
                int sum = ints[i] + ints[left] + ints[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    int[] ans = new int[3];//不能放在外边！
                    ans[0] = ints[i];
                    ans[1] = ints[left];
                    ans[2] = ints[right];
                    ansList.add(ans);
                    for (left++;left < right&&ints[left]==ints[left-1];left++);
                    for (right--;left < right&&ints[right]==ints[right+1];right--);
                }
            }
        }
        return ansList;
    }
}
