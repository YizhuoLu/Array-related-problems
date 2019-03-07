package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {
	/*
	 * Q: Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, 
	 * then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips 
	 * (doing them one after another in succession) to sort the array A.
	 * Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer 
	 * that sorts the array within 10 * A.length flips will be judged as correct.
	 * 
	 * 1. 1 <= A.length <= 100
	 * 2. A[i] is a permutation of [1, 2, ..., A.length]
	 * */
	
	/*
	 * Algorithm: 
	 *  Intuitively, I can place the largest item (at i, 1-indexed) by firstly flipping i to put it at
	 *  first position and then flip n to make it sit at the last position. Until We have only one
	 *  item left. Each move will cost 2 flips per item.
	 *  Given the condition that A[i] is a permutation of [1, 2, ..., A.length] so that the largest item
	 *  must be A.length, we can make x (next largest) to decrement until it become 0 which will terminate
	 *  the process, then I'll find the location of x, say i, first I flip i+1,then I flip x to make it
	 *  sit at the correct position.
	 *  
	 * Complexity Analysis:
	 * T: O(n^2)
	 * S: O(2n) result list.
	 * */
	
	public static List<Integer> pancakeSort(int[] A) {
		List<Integer> res = new ArrayList<>();
		int n = A.length;
		for (int x = n, i; x >= 1; --x) {
			// To find the index of next largest item's location
			for (i = 0; A[i] != x; ++i);
			reverse(A, i+1);
			res.add(i+1);
			reverse(A, x);
			res.add(x);
		}
		return res;
	}
	
	private static void reverse(int[] arr, int k) {
		for (int i = 0, j = k - 1; i < j; ++i, --j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
//		int[] A = {3, 1, 9, 5};
//		Integer[] B = new Integer[4];
//		for (int i = 0; i < 4; ++i) {
//			B[i] = i+1;
//		}
//		Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);
//		for (int idx: B) {
//			System.out.println(idx);
//		}
		int[] A = {3, 2, 4, 1};
		List<Integer> ans = pancakeSort(A);
		for (int x : ans) {
			System.out.print(x + " ");
		}
	}
}
