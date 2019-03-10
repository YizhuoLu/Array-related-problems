package arrays;

public class MaxChunksToMakeSorted {
	/*
	 * Q: Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into 
	 * some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, 
	 * the result equals the sorted array.
	 * What is the most number of chunks we could have made?
	 * 
	 * 1. arr will have length in range [1, 10].
	 * 2. arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
	 * */
	
	/*
	 * Algorithm:
	 *  Use max to keep track of the maximum value we have seen until the current index, and compare with
	 *  the corresponding value in the sorted array. If equal, I do count++.
	 *  Since it's from 0- arr.length  - 1, just compare with the index is enough.
	 *  
	 * Complexity analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public int maxChunksToSorted(int[] arr) {
        int max= 0, count = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max,  arr[i]);
            if (max == i) count++;
        }
        return count;
    }
}
