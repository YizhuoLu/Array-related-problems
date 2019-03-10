package arrays;

public class BeautifulArrangementII {
	/*
	 * Q: Given two integers n and k, you need to construct a list which contains n different positive 
	 * integers ranging from 1 to n and obeys the following requirement: 
	 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , 
	 * |an-1 - an|] has exactly k distinct integers.
	 * If there are multiple answers, print any of them.
	 * 
	 * The n and k are in the range 1 <= k < n <= 104.
	 * */
	
	/*
	 * Algorithm:
	 *  if you have n number, the maximum k can be n - 1; 
	 *  if n is 9, max k is 8.
	 *  This can be done by picking numbers interleavingly from head and tail,
	 *  // start from i = 1, j = n;
	 *  // i++, j--, i++, j--, i++, j--
	 *  When k is less than that, simply lay out the rest (i, j) in incremental order(all diff is 1).
	 *  
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public int[] constructArray(int n, int k) {
		int[] res = new int[n];
		for (int i = 0, l = 0, r = n; l < r; ++i) {
			res[i] = k > 1 ? (k-- %  2 != 0 ? l++ : r--) : l++;
		}
		return res;
	}
	
	/*
	 * Edition 2: 
	 * */
	public int[] constructArrayII(int n, int k) {
		// first arrange small numbers, large numbers after that.
        int[] res = new int[n];
		int i = 0, large = n, small = 1;
        while (i < k) {
            res[i++] = small++;
            if (i < k) res[i++] = large--;
        }
        if (k % 2 == 0) {
            // say k =2 -> 1, 6, 5,4, 3, 2, 1
            while (i < n) res[i++] = large--;
        } else {
            // say n = 3 -> 1, 6, 2, 3, 4, 5
            while (i < n) res[i++] = small++;
        }
		return res;
    }
}
