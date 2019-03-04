package arrays;

public class AvailableCapturesForRook {
	/*
	 * Q: On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white 
	 * bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. 
	 * Uppercase characters represent white pieces, and lowercase characters represent black pieces.
	 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north,
	 *  east, west, and south), then moves in that direction until it chooses to stop, reaches the 
	 *  edge of the board, or captures an opposite colored pawn by moving to the same square it 
	 *  occupies.  Also, rooks cannot move into the same square as other friendly bishops.
	 *  Return the number of pawns the rook can capture in one move.
	 *  
	 * 1. board.length == board[i].length == 8
	 * 2. board[i][j] is either 'R', '.', 'B', or 'p'
	 * 3. There is exactly one cell with board[i][j] == 'R'
	 * */
	
	/*
	 * Algorithm: 
	 *  Firstly we traverse to find 'R', Then we go four directions to see how many pawns we can capture.
	 *  we will terminate at one direction if we have reached boundary or we see 'B'. Return count finally.
	 *  
	 * Complexity Analysis:
	 * T: O(64) -- since there are at most 64 grids.
	 * S: O(1)
	 * */
	private static final int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
	public int numRookCaptures(char[][] board) {
		int M = board.length;
		int count = 0;
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < M; ++j) {
				if (board[i][j] == 'R') {
					for (int[] dir : dirs) {
                        int x = i, y = j;
						while (x  + dir[0] >= 0 && x + dir[0] < M  && y + dir[1] >= 0 && y + dir[1] < M
								&& board[x+dir[0]][y+dir[1]] != 'B') {
							x += dir[0];
							y += dir[1];
							if (board[x][y] == 'p')  {
								count++;
								break;
							}
						}
					}
					return count;
				}
			}
		}
		return count;
	}
}
