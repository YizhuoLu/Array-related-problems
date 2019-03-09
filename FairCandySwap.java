package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
	/*
	 * Q: Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy 
	 * that Alice has, and B[j] is the size of the j-th bar of candy that Bob has. Since they are 
	 * friends, they would like to exchange one candy bar each so that after the exchange, they both 
	 * have the same total amount of candy.  (The total amount of candy a person has is the sum of the 
	 * sizes of candy bars they have.)
	 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, 
	 * and ans[1] is the size of the candy bar that Bob must exchange.
	 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
	 * 
	 * 1. 1 <= A.length <= 10000
	 * 2. 1 <= B.length <= 10000
	 * 3. 1 <= A[i] <= 100000
	 * 4. 1 <= B[i] <= 100000
	 * 5. It is guaranteed that Alice and Bob have different total amounts of candy.
	 * 6. It is guaranteed there exists an answer.
	 * */
	
	/*
	 * Algorithm: 
	 *  I sort two arrays and I compare the sum of two arrays I'll set two pointers one and two. I'll 
	 *  put one at the first item of array that is of smaller sum, two sitting at the first index of the
	 *  array that is of larger sum. if sum_s + B[two] - A[one] == sum_l - B[two] + A[one], we put relative
	 *  answers in the result. Else if sum_s + B[two] - A[one] < sum_l - B[two] + A[one], we move two, Else:
	 *  we move one.
	 * 
	 * Complexity Analysis:
	 * T: O(n*logn+m*logm)
	 * S: O(1)
	 * */
	public int[] fairCandySwap(int[] A, int[] B) {
		// A: in the first index of result
		int sum_a = 0, sum_b = 0;
		for (int num : A) {
			sum_a += num;
		}
		for (int num: B) {
			sum_b += num;
		}
		Arrays.sort(A);
        Arrays.sort(B);
		int one = 0, two = 0;
		while (one < A.length && two < B.length) {
			int com1 = sum_a + B[two] - A[one];
			int com2 = sum_b - B[two] + A[one];
			if (com1 == com2) {
				return new int[] {A[one], B[two]};
			} else if (com1 < com2) {
				two++;
			} else {
				one++;
			}
		}
		return new int[] {-1, -1};
	}
	
	/*
	 * Algorithm 2: use formula that y = x + (Sb - Sa) / 2;
	 * For each x in Alice's bars, if we can find y in Bob's bars that satisfy this relationship, we can
	 * return the result.
	 * 
	 * Data Structure: Set -- to make search in O(1)
	 * Complexity Analysis:
	 * T: O(n + m) m is Alice's array, n is Bob's array's length
	 * S: O(n) 
	 * */
	public int[] fairCandySwapII(int[] A, int[] B) {
		int sumA =0, sumB = 0;
		for (int num : A) {
			sumA += num;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : B) {
			sumB += num;
			set.add(num);
		}
		int delta = (sumB - sumA) / 2;
		for (int num : A) {
			int y = num + delta;
			if (set.contains(y)) {
				return new int[] {num, y};
			}
		}
		throw null;
	}
}
