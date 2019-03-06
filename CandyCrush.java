package arrays;

public class CandyCrush {
	/*
	 * Q: This question is about implementing a basic elimination algorithm for Candy Crush.
	 * Given a 2D integer array board representing the grid of candy, different positive 
	 * integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents 
	 * that the cell at position (i, j) is empty. The given board represents the state of the game following 
	 * the player's move. Now, you need to restore the board to a stable state by crushing candies 
	 * according to the following rules:
	 * 1. If three or more candies of the same type are adjacent vertically or horizontally, "crush" 
	 * them all at the same time - these positions become empty.
	 * 2. After crushing all candies simultaneously, if an empty space on the board has candies on top 
	 * of itself, then these candies will drop until they hit a candy or bottom at the same time. 
	 * (No new candies will drop outside the top boundary.)
	 * 3. After the above steps, there may exist more candies that can be crushed. If so, you need to 
	 * repeat the above steps.
	 * 4. If there does not exist more candies that can be crushed (ie. the board is stable), then return 
	 * the current board.
	 * You need to perform the above rules until the board becomes stable, then return the current board.
	 * 
	 * 1. The length of board will be in the range [3, 50].
	 * 2. The length of board[i] will be in the range [3, 50].
	 * 3. Each board[i][j] will initially start as an integer in the range [1, 2000].
	 * */
	
	/*
	 * Algorithm: 
	 *  General idea is to traverse the matrix again and again to find candies that should be crushed.
	 *  in order to handle a case there are vertical and horizontal overlap candies, I mark them as negative.
	 *  In the search part, I always search from left to right, from top to bottom and mark consecutive
	 *  candies as their negative format. 
	 *  In the gravity part, I check column by column, if I find there are positive, it will go down, afterwards,
	 *  I will add 0 to all the upper position using 0.
	 *  
	 * Complexity Analysis:
	 * T: O((M*N)^2) M is the row, N is the column, we need to scan the whole matrix, may only crush 3 candies 
	 * each time.
	 * S: O(1) since I do it in place.
	 * */
	
	public int[][] candyCrush(int[][] board) {
		int M = board.length, N = board[0].length;
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < M; ++i) {
				for (int j = 0; j < N; ++j) {
					if (board[i][j] == 0)
						continue;
					int val = Math.abs(board[i][j]);
					// check current row
					if (j < N - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
						flag = true;
						int cur = j;
						while (cur < N && Math.abs(board[i][cur]) == val) {
							board[i][cur++] = -val;
						}
					}
					// check current column
					if (i < M - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
						flag = true;
						int cur = i;
						while (cur < M && Math.abs(board[cur][j]) == val) {
							board[cur++][j] = -val;
						}
					}
				}
			}
			// gravity part
			if (flag) {
				for (int i = 0; i < N; ++i) {
					int bottom = M - 1;
					for (int j = M - 1; j >= 0; --j) {
						if (board[j][i] > 0) {
							board[bottom--][i] = board[j][i];
						}
					}
					// change the top to 0
					for (int k = bottom; k >= 0; --k) {
						board[k][i] = 0;
					}
				}
			}
		}
		return board;
	}
}
