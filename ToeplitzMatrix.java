package arrays;

public class ToeplitzMatrix {
	/*
	 * Q: A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
	 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
	 * 
	 * 1. matrix will be a 2D array of integers.
	 * 2. matrix will have a number of rows and columns in range [1, 20].
	 * 3. matrix[i][j] will be integers in range [0, 99].
	 * */
	
	/*
	 * Algorithm: check if each value is identical.
	 * 
	 * Complexity Analysis:
	 * T: O(m*n)
	 * S: O(1)
	 * */
	public static boolean isToeplitzMatrix(int[][] matrix) {
		int M = matrix.length, N = matrix[0].length;
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N;  ++j) {
				int curRow = i, curCol = j;
				while (curRow+1 < M && curCol+1 < N) {
					if (matrix[curRow][curCol] != matrix[curRow+1][curCol+1]) {
						return false;
					}
					curRow++;
					curCol++;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2}, {2,2}};
		System.out.println(isToeplitzMatrix(matrix));
	}
}
