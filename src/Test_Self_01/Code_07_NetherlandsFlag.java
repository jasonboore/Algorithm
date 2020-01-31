package Test_Self_01;
/**
 * 荷兰国旗问题
 * 给定一个num
 * 数组左边小于num，中间等于num，右边大于num
 * @author jasonborn
 *
 */
public class Code_07_NetherlandsFlag {
	public static int[] partition(int[] arr, int L,int R, int p) {
		int less = L - 1;
		int more = R + 1;
		while(L < more) {
			if(arr[L] < p) {
				swap(arr,++less,L++);
			}else if(arr[L] > p) {
				swap(arr,--more,L);
			}else {
				L++;
			}
		}
		return new int[] {less + 1 , more - 1};
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
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

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 5);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
