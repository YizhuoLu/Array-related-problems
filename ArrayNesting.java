package arrays;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {
	/*
	 * Q: A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the 
	 * longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
	 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next 
	 * element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before 
	 * a duplicate element occurs in S.
	 * 
	 * 1. N is an integer within the range [1, 20,000].
	 * 2. The elements of A are all distinct.
	 * 3. Each element of A is an integer within the range [0, N-1].
	 * */
	
	/*
	 * Algorithm 1:
	 *  for each item in the array, I will use a set to store all item based on the rule above, I will stop
	 *  storing items until there is duplication. Each time I will update the result with size of current
	 *  set.
	 *  
	 * Complexity Analysis:
	 * T: O(n^2)
	 * S: O(n)
	 * */
	public int arrayNesting(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.clear();
            int cur = nums[i];
            while (!set.contains(cur)) {
                set.add(cur);
                cur = nums[cur];
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
	
	/*
	 * Algorithm 2:
	 *  Through observation I find that Thus, the same elements will be added to the current set 
	 *  irrespective of the first element chosen to be added to the set out of these marked elements.
	 *  So we can use a array to record all visited items, as long as we have seen it in any process.
	 *  
	 * Complexity Analysis:
	 * T: O(n) each item will be processed at most once.
	 * S: O(n)
	 * */
	public int arrayNestingII(int[] nums) {
		boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; ++i){
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
                visited[start] = true;
            } while (start != nums[i]);
            res = Math.max(res, count);
        }
        return res;
	}
	
	/*
	 * Algorithm 3: DFS
	 *  use dfs to find number of different items in the set.
	 *  
	 * Complexity Analysis:
	 * T: O(n^2)
	 * S: O(n)
	 * */
	public int arrayNestingIII(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int res  =  0;
		for (int i = 0; i < nums.length; ++i) {
			res = Math.max(res, dfs(nums, i, set));
		}
		return res;
	}
	
	private int dfs(int[] nums, int i, Set<Integer> set) {
		// base case
		if (set.contains(i)) {
			return 0;
		}
		set.add(i);
		return 1 + dfs(nums, nums[i], set);
	}
}
