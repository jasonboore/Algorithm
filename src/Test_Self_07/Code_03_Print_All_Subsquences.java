package Test_Self_07;
/**
 * 打印一个字符串的全部子序列，包括空字符串
 * @author jasonborn
 *
 */
public class Code_03_Print_All_Subsquences {
	public static void printSubsquences(char[] chs, int i, String str) {
		if(i == chs.length) {
			System.out.println(str);
			return;
		}
		printSubsquences(chs, i + 1, str + chs[i]);
		printSubsquences(chs, i + 1, str);
	}
	public static void main(String[] args) {
		String test = "abcd";
		char[] chs = test.toCharArray();
		printSubsquences(chs, 0, "");
	}
}
