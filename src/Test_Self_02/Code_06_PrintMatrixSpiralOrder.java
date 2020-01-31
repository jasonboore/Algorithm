package Test_Self_02;
/**
 * 旋转打印一个数组
 * @author jasonborn
 *
 */
public class Code_06_PrintMatrixSpiralOrder {
	public static void spiralOrderPrint(int[][] matrix) {
		int aR = 0;
		int aC = 0;
		int bR = matrix.length - 1;
		int bC = matrix[0].length - 1;
		while(aR <= bR && aC <= bC) {
			printEdge(matrix, aR++, aC++, bR--, bC--);
		}
	}
	
	public static void printEdge(int[][] matrix, int aR, int aC, int bR, int bC) {
		if(aR == bR) {
			for(int i = aC; i <= bC; i++) {
				System.out.print(matrix[aR][i] + " ");
			} 
		}else if(aC == bC) {
			for(int i = aR; i <= bR; i++) {
				System.out.print(matrix[i][aC] + " ");
			} 
		}else {
			int curC = aC;
			int curR = aR;
			while(curC != bC) {
				System.out.print(matrix[aR][curC++] + " ");
			}
			while(curR != bR) {
				System.out.print(matrix[curR++][bC] + " ");
			}
			while(bC != aC) {
				System.out.print(matrix[bR][bC--] + " ");
			}
			while(bR != aR) {
				System.out.print(matrix[bR--][aC] + " ");
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}
}
