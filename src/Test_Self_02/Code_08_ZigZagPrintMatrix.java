package Test_Self_02;
/**
 * 给定一个矩阵，将这个矩阵按照“之”字形打印
 * @author jasonborn
 *
 */
public class Code_08_ZigZagPrintMatrix {
	public static void printMatrixZigZag(int[][] matrix) {
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean upORdown = false;
		while(aR != endR + 1) {
			printLevel(matrix, aR, aC, bR, bC, upORdown);
			aR = aC == endC ? aR + 1 : aR;
			aC = aC == endC ? aC : aC + 1;
			bC = bR == endR ? bC + 1 : bC;
			bR = bR == endR ? bR : bR + 1;
			upORdown = !upORdown;
		}
		System.out.println();
	}
	public static void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean upORdown) {
		if(upORdown) {
			while(aR != bR + 1) {
				System.out.print(matrix[aR++][aC--] + " ");
			}
		}else {
			while(bR != aR - 1) {
				System.out.print(matrix[bR--][bC++] + " ");
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } , {13, 14, 15, 16}};
		printMatrixZigZag(matrix);

	}
}
