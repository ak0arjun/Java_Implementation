package solutions.arrays;

import solutions.TestCaseAbstract;

/**
 * Rotate a given matrix(n*n) by 90 degrees clockwise.
 */
public class RotateMatrix90 extends TestCaseAbstract {

	@Override
	public void run() {
		int[][] matrix1 = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateMatrix(matrix1);
	}
	
	
	private void rotateMatrix(int[][] matrix) {
		printMatrix(matrix);
		if (matrix.length <1 || matrix.length != matrix[0].length) {
			System.out.println("Only n*n matrix can be rotated, not supported: " + matrix.length + "*" + matrix[0].length);
		}
		for(int index=0;index<matrix.length/2;index++) {
			int row=index;
			int col = 0;
			int moveValue = matrix[row][col];
			int newRow = col;
			int newCol = matrix.length -1 - row;
			while (newRow !=index || newCol != 0) {
				int temp = matrix[newRow][newCol];
				System.out.println(newRow + "," + newCol + "," + moveValue);
				matrix[newRow][newCol] = moveValue;
				moveValue = temp;
				row = newRow;
				col= newCol;
				newRow = col;
				newCol = matrix.length -1 - row;
			} 
			System.out.println(newRow + "," + newCol + "," + moveValue);
			matrix[newRow][newCol] = moveValue;
		}
		printMatrix(matrix);
	}
	
	private void printMatrix(int[][] matrix) {
		System.out.println("Print Matrix starts");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println("Print Matrix ends");
	}

}
