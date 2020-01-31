package Test_Self_01;

import java.util.Arrays;

/**
 * 逆序对问题
 *在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有的逆序对
 * @author jasonborn
 *
 */
public class Code_06_ReverseAlignment {
	
	public static void reverseAlignment(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] arr,int l, int r) {
		if(l == r) {
			return;
		}
		int mid = (l + r) / 2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid + 1,r);
		merge(arr,l,mid,r);
	
	}
	public static void merge(int[] arr,int l,int mid,int r) {
		int[] temp = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = mid + 1;
		
		while(p1 <= mid && p2 <= r) {
			if(arr[p1] > arr[p2]) {
				for(int j = p1; j <= mid; j++)
					System.out.print("<" + arr[j] + "," + arr[p2] + ">");				
			}
			temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		
		while(p1 <= mid) {
			temp[i++] = arr[p1++];
		}
		
		while(p2 <= r) {
			temp[i++] = arr[p2++];
		}
		
		for(i = 0;i < temp.length;i++) {
			arr[l + i] = temp[i];
		}
	}

	public static void comparator(int[] arr) {
		Arrays.sort(arr);
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
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 10;
		int maxValue = 10;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			reverseAlignment(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		reverseAlignment(arr);
		printArray(arr);
//		int[] arr = {8,6,2,3,1,5,7,4};
//		reverseAlignment(arr);

	}
}