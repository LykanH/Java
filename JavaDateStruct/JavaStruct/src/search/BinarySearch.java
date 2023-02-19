package search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] ints = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		int binary = new BinarySearch().binary(ints, 0, ints.length - 1, 2);
		System.out.println("所找元素下标为：" + binary);
	}

	public int binary(int[] ints, int l, int r,int tar) {
		// 二分查找递归实现
		if (l > r) {
			return -1;
		}

		int mid = l + ((r - l) >> 1);
		if (tar > ints[mid]) {
			return binary(ints, mid + 1, r, tar);
		}if(tar < ints[mid]) {
			return binary(ints, l, mid - 1, tar);
		}else {
			return mid; 
		}
		
	}

}
