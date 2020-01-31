package Test_Self_01;

import java.util.Arrays;
/**
 * �ҵ�һ������������������ֵ
 * @author jasonborn
 *
 */
public class Code_11_MaxGap {
	public static int maxGap(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < len; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		if(max == min) {
			return 0;
		}
		
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		
		int[] mins = new int[len + 1];
		int bid = 0;
		
		for(int i = 0; i < len; i++) {
			bid = bucket(arr[i],len, min, max);
			maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
			mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
			hasNum[bid] = true;
		}
		
		int res = 0;
		int lastMax = maxs[0];
		for(int i = 1; i <= len; i++) {
			if(hasNum[i]) {
				res = Math.max(mins[i] - lastMax, res);
				lastMax = maxs[i];
				
			}
		}
		
		return res;
	}
	
	public static int bucket(int num, int len, int min, int max) {
		return (int)(num - min) * len / (max - min);
	}
	
	public static int comparator(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int gap = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			gap = Math.max(nums[i] - nums[i - 1], gap);
		}
		return gap;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (maxGap(arr1) != comparator(arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
