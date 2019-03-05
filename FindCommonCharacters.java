package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
	/*
	 * Q: Given an array A of strings made only from lowercase letters, return a list of all characters 
	 * that show up in all strings within the list (including duplicates).  For example, if a character 
	 * occurs 3 times in all strings but not 4 times, you need to include that character three times in 
	 * the final answer.
	 * You may return the answer in any order.
	 * 
	 * 1. 1 <= A.length <= 100
	 * 2. 1 <= A[i].length <= 100
	 * 3. A[i][j] is a lowercase letter
	 * */
	
	/*
	 * Algorithm: 
	 *  Since all strings only contain lower-case letter, we can use a int[26] array to record the 
	 *  frequency of all characters in all strings, each time, we use a tmp int[26] to record the
	 *  current string's all letters' frequency and then update the global frequency recorder by
	 *  min(tmp, cnt). Eventually I add all letters to the ans so long as the frequency is not 0.
	 *  
	 * Complexity Analysis:
	 * T: O(mn) m is the length of the A array, n is the longest length of the string in it.
	 * S: O(1) since I only use an int[26] to record the frequency.
	 * */
	
	public List<String> commonChars(String[] A) {
		int[] count = new int[26];
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String str : A) {
			int[] tmp = new int[26];
			for (char ch : str.toCharArray()) {
				// record each letter's frequency.
				++tmp[ch - 'a'];
			}
			// update count
			for (int i = 0; i< 26; ++i) {
				count[i] = Math.min(tmp[i], count[i]);
			}
		}
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < 26; ++i) {
			while (count[i]-- > 0) {
				ans.add("" + (char) (i + 'a'));
			}
		}
		return ans;
	}
}
