package arrays;

public class MonotonicArray {
	/*
	 * Q: An array is monotonic if it is either monotone increasing or monotone decreasing.
	 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing 
	 * if for all i <= j, A[i] >= A[j].
	 * Return true if and only if the given array A is monotonic.
	 * 
	 * 1. 1 <= A.length <= 50000
	 * 2. -100000 <= A[i] <= 100000
	 * */
	
	/* !!! pay attention to the case when initial adjacent difference is equal.
	 * Algorithm: one pass and remember property in the process.
	 * To perform this check in one pass, we want to remember if it is monotone increasing or monotone 
	 * decreasing. It's monotone increasing if there aren't some adjacent values A[i], A[i+1] with 
	 * A[i] > A[i+1], and similarly for monotone decreasing.
	 * If it is either monotone increasing or monotone decreasing, then A is monotonic.
	 * 
	 * Complexity Analysis:
	 * T: O(n)(
	 * S: O(1)
	 * */
	public boolean isMonotonic(int[] A) {
		boolean increasing = true;
		boolean decreasing = true;
		for (int i = 0; i < A.length - 1; ++i) {
			if (A[i] > A[i+1]) {
				increasing = false;
			}
			if (A[i] < A[i+1]) {
				decreasing = false;
			}
		}
		return increasing || decreasing;
	}
}
