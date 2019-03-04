package arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
	/*
	 * Q: Given an array of integers A sorted in non-decreasing order, return an 
	 * array of the squares of each number, also in sorted non-decreasing order.
	 * 
	 * 1. 1 <= A.length <= 10000
	 * 2. -10000 <= A[i] <= 10000
	 * 3. A is sorted in non-decreasing order.
	 * */
	
	/*
	 * Algorithm 1:
	 *  calculate all items' square and then sort them.
	 *  
	 * Complexity Analysis:
	 * T: O(nlogn + n) nlogn will dominate
	 * S: O(1) since do the operation in place.
	 * */
	
	public int[] sortedSquares(int[] A) {
		// corner case
		if (A== null || A.length == 0) {
			return A;
		}
		for (int i = 0; i < A.length; ++i) {
			A[i] = A[i] * A[i];
		}
		Arrays.sort(A);
		return A;
	}
	
	/*
	 * Algorithm 2: two pointers
	 * Since the original array is sorted in increasing order, the biggest number after square can only
	 * come from the both side, the smallest number after square can only come from the middle. So, we
	 * use  left and right pointers standing at the first and last index at first. We use a new empty array
	 * with size N as the result, set current result pointer standing at the last index.
	 * if (left^2>right^2): res[cur--]=left^2, left++. Else:  res[cur--]=right^2, right--. Terminate after
	 * left go over right pointer.  Return res eventually.
	 * 
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(n)
	 * */
	public int[] sortedSquaresII(int[] A) {
		int left = 0, right = A.length - 1;
		int[] res = new int[A.length];
		int cur = A.length - 1;
		while (left <= right) {
			if (A[left] * A[left] > A[right] * A[right]) {
				res[cur--] = A[left]  *  A[left];
				left++;
			} else {
				res[cur--] = A[right] * A[right];
				right--;
			}
		}
		return res;
	}
}
