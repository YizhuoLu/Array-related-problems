package arrays;

public class SumOfEvenNumbersAfterQueries {
	/*
	 * Q: We have an array A of integers, and an array queries of queries.
	 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  
	 * Then, the answer to the i-th query is the sum of the even values of A.
	 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently 
	 * modifies the array A.)
	 * Return the answer to all queries.  Your answer array should have answer[i] as
	 *  the answer to the i-th query.
	 *  
	 * 1. 1 <= A.length <= 10000
	 * 2. -10000 <= A[i] <= 10000
	 * 3. 1 <= queries.length <= 10000
	 * 4. -10000 <= queries[i][0] <= 10000
	 * 5. 0 <= queries[i][1] < A.length
	 * */
	
	/*
	 * Algorithm 1: 
	 * First, I add up all even values and get a initial even value sum.
	 * Second, I traverse each row of queries and first I judge if before A[idx] is even:
	 * if so, I store this value and judge if after adding it's still even, if so I subtract original
	 * value and add the after change value, Else I only subtract the previous value. Else: I judge 
	 * if after change value is even, if so I directly add it, Else: do noting and continue.
	 * 
	 * Complexity Analysis:
	 * T: O(m+n) m is the length of A, n is the length of queries.
	 * S: O(1)
	 * */
	public int[] sumEvenAfterQueriesI(int[] A, int[][] queries) {
		int[] ans = new int[A.length];
		int sum = 0;
		for (int num : A) {
			sum += num % 2== 0 ? num :  0;
		}
		for (int i = 0; i < queries.length; ++i) {
			if (A[queries[i][1]] % 2 == 0) {
				int before = A[queries[i][1]];
				A[queries[i][1]] += queries[i][0];
				if (A[queries[i][1]] % 2 == 0) {
					sum = sum - before + A[queries[i][1]];
				} else {
					sum -= before;
				}
			} else {
				A[queries[i][1]] += queries[i][0];
				sum += A[queries[i][1]] % 2 == 0 ? A[queries[i][1]] : 0;
			}
			ans[i] = sum;
		}
		return ans;
	}
}
