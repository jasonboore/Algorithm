package Test_Self_04;

public class Code_03_Islands {
	public static int countIslands(int[][] m) {
		if(m == null || m[0] == null) {
			return 0;
		}
		int row = m.length;
		int column = m[0].length;
		int res = 0;
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < column; j++) {
				if(m[i][j] == 1) {
					res++;
					inject(m, i, j ,row, column);
				}
			}
		return res;
	}

	private static void inject(int[][] m, int i, int j, int row, int column) {
		if(i < 0 || i >= row || j < 0 || j >= column || m[i][j] != 1) {
			return;
		}
		m[i][j] = 2;
		inject(m, i + 1, j, row, column);
		inject(m, i - 1, j, row, column);
		inject(m, i, j - 1, row, column);
		inject(m, i, j + 1, row, column);
	}
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));

	}
}
