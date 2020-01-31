package Sample6;

public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			//func(n, n, "left", "mid", "right");
			//moveLeftToRight(n);
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
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
		System.out.println("move" + N + "from right to left");
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
		System.out.println("move" + N + " from mid to left");
		moveRightToLeft(N - 1);
	}

	public static void moveRightToMid(int N) {
		if(N == 1) {
			System.out.println("move 1 from right to mid");
			return;
		}
		moveRightToLeft(N - 1);
		System.out.println("move" + N + " from right to mid");
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
