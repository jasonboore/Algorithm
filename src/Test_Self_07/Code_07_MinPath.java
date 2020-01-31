package Test_Self_07;

public class Code_07_MinPath {
	public static int minPath1(int[][] matrix) {
		return process(0, 0, matrix);
	}

	private static int process(int i, int j, int[][] matrix) {
		// TODO 自动生成的方法存根
		int result = matrix[i][j];
		if(i == matrix.length - 1 && j == matrix[0].length - 1) {
			return result;
		}
		if(j == matrix[0].length - 1) {
			return result + process(i + 1, j, matrix);
		}
		if(i == matrix.length - 1 ) {
			return result + process(i, j+ 1, matrix);
		}
		return result + Math.min(process(i + 1, j, matrix), process(i, j + 1, matrix));
	}
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
	}
}
