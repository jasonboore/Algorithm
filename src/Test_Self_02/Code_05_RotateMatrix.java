package Test_Self_02;

/**
 * ��һ�������εľ�����ת90��
 * @author jasonborn
 *
 */
public class Code_05_RotateMatrix {
	public static void rotate(int[][] matrix) {
		int aR = 0;
		int aC = 0;
		int bR = matrix.length - 1;
		int bC = matrix[0].length - 1;
		while (aR < bR) {
			rotateEdge(matrix, aR++, aC++, bR--, bC--);
		}
	}
	public static void rotateEdge(int[][] matrix, int aR, int aC, int bR, int bC) {
		int time = bC - aC;
		int temp;
		for(int i = 0; i < time; i++) {
			temp = matrix[aR][aC + i];
			matrix[aR][aC + i] = matrix[bR - i][aC];
			matrix[bR - i][aC] = matrix[bR][bC - i];
			matrix[bR][bC - i] = matrix[aR + i][bC];
			matrix[aR + i][bC] = temp;
		}
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}
}
