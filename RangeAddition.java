package arrays;

public class RangeAddition {
	/*
	 * Q: Assume you have an array of length n initialized with all 0's and are given k update operations.
	 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each 
	 * element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
	 * Return the modified array after all k operations were executed.
	 * */
	
	/*
	 * Algorithm 1: traverse the updates and for each row, I do the updte to result array. 
	 * 
	 * Complexity Analysis:
	 * T: O(k*n) k is the length of the updates, n is length (first argument)
	 * S: O(n) result.
	 * */
	
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];
		for (int i = 0; i < updates.length; ++i) {
			for (int j = updates[i][0]; j <= updates[i][1]; ++j) {
				res[j] += updates[i][2];
			}
		}
		return res;
	}
	
	/*
	 * Algorithm 2: 
	 *   for each update, we can first add the inc at the start index, and then we put -inc at the endIndex + 1.
	 *   afterwards we can finish updating by 1: add the previous one to current one in the range. 2. get rid
	 *   of the last index since we have endIndex + 1 for which before I new a length + 1 res array.
	 *   The reason for this is because that each update is independent so I can do it in separate two operations.
	 * 
	 * Complexity Analysis:
	 * T: O(k + n)
	 * S: O(n)
	 * */
	public int[] getModifiedArrayII(int length, int[][] updates) {
		int[] res = new int[length + 1];
		for (int[] update : updates) {
			res[update[0]] += update[2];
			res[update[1] + 1] -= update[2];
		}
		
		for (int i  = 1; i <= length; ++i) {
			res[i] += res[i-1];
		}
		int[] ans = new int[length];
		for (int i = 0; i < length; ++i) {
			ans[i] = res[i];
		}
		return ans;
	}
}
