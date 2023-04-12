package test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/12 17:13
 */
public class Test3 {
    @Test
    public void test1(){
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//
////        Object[] obj = arrayList.toArray();
//        Object[] objects = arrayList.toArray();
//        System.out.println(Arrays.toString(objects));
////        int a = (Integer)objects[1];
////        int b = (Integer)objects[2];
////        System.out.println(a-b);
//        System.out.println(objects.length);
//        System.out.println(objects[0]);
//        int[] nums = new int[]{8,1,3,2};
//        int[] nums1 = new int[nums.length];
//        nums1 = nums;
//        Arrays.sort(nums1);
//        System.out.println(nums1);
//        System.out.println(nums);


    }


    @Test
    public void test2(){
        int[] ints = new int[]{-18,12,3,0};
        System.out.println(Arrays.toString(twoSum(ints, -6)));

    }
    public int[] twoSum(int[] nums, int target) {
        //双指针
        int[] ints = new int[2];
        int[] nums1 = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1);
        for(int i = 0,j = nums1.length - 1;i < j;){
            if((nums1[i] + nums1[j]) > target){
                j--;
            }
            else if((nums1[i] + nums1[j]) < target) {
                i++;
            }
            else if((nums1[i] + nums1[j]) == target){
                ints[0] = nums1[i];
                ints[1] = nums1[j];
                break;
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(ints[0] == nums[i]) ints[0] = i;
            else if(ints[1] == nums[i]) ints[1] = i;
        }
        return ints;
    }
}
