package arrays;

public class MaxConsecutiveOnes {
	/*
	 * Q: Given a binary array, find the maximum number of consecutive 1s in this array.
	 * 
	 * 1. The input array will only contain 0 and 1.
	 * 2. The length of input array is a positive integer and will not exceed 10,000
	 * */
	
	/* !!!  special case --> [1] pay attention to the place where we update globalMax.
	 * Algorithm: 
	 *  we set a globalMax to record the final result, and set a count in the traversal process. Each time
	 *  when I encounter a '1', I make count++, If it's '0' for the first time I update globalMax = 
	 *  max(globalMax, count), and set count = 0.
	 *  
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public int findMaxConsecutiveOnes(int[] nums) {
		// corner case
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int globalMax = Integer.MIN_VALUE, count = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 1) {
				count++;
			} else {
				count = 0;
			}
			globalMax = Math.max(globalMax, count);
		}
		return globalMax;
	}
}
