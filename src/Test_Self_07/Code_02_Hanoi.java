package Test_Self_07;
/**
 * 汉诺塔问题 
 * 打印n层汉诺塔从最左边移动到最右边的全部过程
 * @author jasonborn
 *
 */
public class Code_02_Hanoi {
	public static void hanoi(int n) {
		if (n > 0) {
			process(n, "左", "右", "中");
			//moveLeftToRight(n);
		}
	}
	private static void process(int N, String from, String to, String help) {
		// TODO 自动生成的方法存根
		if(N == 1) {
			System.out.println("move 1 from " + from + " to " + to);
			return;
		}
			process(N - 1, from, help, to);
			System.out.println("move " + N + " from " + from + " to "+ to);
			process(N - 1, help, to, from);
		
	}
	public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
			return;
		}
		moveLeftToMid(N - 1);
		System.out.println("move " + N + " from left to right");
		moveMidToRight(N - 1);
	}

	public static void moveRightToLeft(int N) {
		if(N == 1) {
			System.out.println("move 1 from right to left");
			return;
		}
		moveRightToMid(N - 1);
		System.out.println("move " + N + "from right to left");
		moveMidToRight(N - 1);
	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
			return;
		}
		moveLeftToRight(N - 1);
		System.out.println("move " + N + " from left to mid");
		moveRightToMid(N - 1);
	}

	public static void moveMidToLeft(int N) {
		if(N == 1) {
			System.out.println("move 1 from mid to left");
			return;
		}
		moveMidToRight(N - 1);
		System.out.println("move " + N + " from mid to left");
		moveRightToLeft(N - 1);
	}

	public static void moveRightToMid(int N) {
		if(N == 1) {
			System.out.println("move 1 from right to mid");
			return;
		}
		moveRightToLeft(N - 1);
		System.out.println("move " + N + " from right to mid");
		moveLeftToMid(N - 1);
	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
			return;
		}
		moveMidToLeft(N - 1);
		System.out.println("move " + N + " from mid to right");
		moveLeftToRight(N - 1);
	}

	public static void main(String[] args) {
		int n = 4;
		hanoi(n);
	}
}
