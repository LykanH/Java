package Test;

/**
 *
 * 删除数组中的重复元素
 *      给你一个 升序排列 的数组 nums ，请你 原地
 *      删除重复出现的元素，使每个元素 只出现一次 ，
 *      返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 15:36
 */
public class Test1 {
    public static void main(String[] args) {
        int n = 0;
        int[] nums = new int[]{1,1,2,2,3,4};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1;j < nums.length;j++){
                if (nums[j] == nums[i]){
                    for(int m = j;m < nums.length - 1;m++){
                        nums[m] = nums[m+1];
                    }
                    nums[nums.length - 1 - n] = 0;
                }
            }
        }
        for (int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }
        System.out.println("数组长度为：" + nums.length);
    }
}