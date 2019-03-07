package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
	/*
	 * Q: Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and 
	 * others appear once.
	 * Find all the elements that appear twice in this array.
	 * */
	
	/*
	 * Algorithm 1: 
	 *  since 1 ≤ a[i] ≤ n, we can use a helper array with size = n+1, in the process of traversing
	 *  the nums, we make helper[cur_item]++. Afterwards, I traverse the helper to see which index's
	 *  item equals to 2. If so, I add it into the final list.
	 *  
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(n)
	 * */
	public List<Integer> findDuplicates(int[] nums) {
		// corner case
		List<Integer> ans  = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return ans;
		}
		int[] helper = new int[nums.length + 1];
		for (int num : nums) {
			helper[num]++;
		}
		for (int i = 1; i < helper.length; ++i) {
			if (helper[i] == 2) {
				ans.add(i);
			}
		}
		return ans;
	}
	
	/*
	 * Algorithm 2: O(1) space complexity
	 *  Each time when we encounter a num in the given array, I find num at index = num - 1 and 
	 *  make it negative, if it has already been negative, we add it into final list.
	 * 
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public List<Integer> findDuplicatesII(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; ++i) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				ans.add(Math.abs(nums[i]));
			}
			nums[index] = -nums[index];
		}
		return ans;
	}
}
