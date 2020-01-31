package Test_Self_07;
/**
 * 求n!的结果
 * @author jasonborn
 *
 */
public class Code_01_Factorial {
	public static long getFactorial1(int n) {
		if(n == 1) {
			return 1L;
		}
		return (long)n * getFactorial1(n - 1);				
	}
	public static long getFactorial2(int n) {
		long res = 1L;
		for(int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	public static void main(String[] args) {
		int n = 12;
		System.out.println(getFactorial1(n));
		System.out.println(getFactorial2(n));
	}

}
