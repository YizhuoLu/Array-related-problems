package arrays;

import java.util.ArrayList;
import java.util.List;

public class ReshapeTheMatrix {
	/*
	 * Q: In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into 
	 * a new one with different size but keep its original data. You're given a matrix represented by a 
	 * two-dimensional array, and two positive integers r and c representing the row number and column 
	 * number of the wanted reshaped matrix, respectively. The reshaped matrix need to be filled with 
	 * all the elements of the original matrix in the same row-traversing order as they were.
	 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; 
	 * Otherwise, output the original matrix.
	 * 
	 * 1. The height and width of the given matrix is in range [1, 100].
	 * 2. The given r and c are all positive.
	 * */
	
	/*
	 * Algorithm: 
	 *  First I tell if matrix.rows * matrix.columns == r * c, if not, just return the original matrix.
	 *  else: I will first use a list to load all items in the original matrix row by row. Then I will
	 *  add it  to the new matrix line by line.
	 *  
	 * Complexity Analysis:
	 * T: O(m*n + r*c) m is the length of original matrix, n is the length of the original matrix's column.
	 * S: O(m*n)
	 * */
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int M = nums.length, N = nums[0].length;
		if(M * N != r*c) {
			return nums;
		}
		int[][] ans = new int[r][c];
		List<Integer> helper = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				helper.add(nums[i][j]);
			}
		}
		int idx = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				nums[i][j] = helper.get(idx++);
			}
		}
		return ans;
	}
	
	/*
	 * Algorithm 2: use divide and modulus without using extra space.
	 *  In order to save extra list space, we can set a initial value: count = 0 and ans[count/c][count%c] =
	 *  nums[i][j].
	 * 
	 * Complexity Analysis:
	 * T: O(m*n)
	 * S: O(m*n) since the resultant matrix is a must.
	 * */
	public int[][] matrixReshapeII(int[][] nums, int r, int c) {
		int[][] ans = new int[r][c];
		if (nums.length == 0 || r * c != nums.length * nums[0].length) {
			return nums;
		}
		int count = 0;
		for (int i= 0; i< nums.length; ++i) {
			for (int j = 0; j < nums[0].length; ++j) {
				ans[count/c][count%c] = nums[i][j];
				count++;
			}
		}
		return ans;
	}
}
