package search;

public class er {
	
	public static void main(String[] args) {
		int[] ints = new int[] {-1,0,3,5,9,12};
		er e1 = new er();
		System.out.println(er.search(ints, 9));
	}
	
	public static int search(int[] nums, int target) {
		// 二分法
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
