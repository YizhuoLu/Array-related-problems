package arrays;

public class ShortestWordDistance {
	/*
	 * Q: Given a list of words and two words word1 and word2, return the shortest distance between 
	 * these two words in the list.
	 * 
	 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	 * */
	
	/*
	 * Algorithm: 
	 *  In the outer for-loop, I'll try to find word1, for each word1 I find I use a inner for-loop
	 *  to find word2 and calculate the distance. I'll update the globalMin in the process.
	 *  
	 * Complexity Anaalysis:
	 * T: O(n^2)
	 * S: O(1)
	 * */
	public int shortestDistance(String[] words, String word1, String word2) {
		int globalMin = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; ++i) {
			if (word1.equals(words[i])) {
				for (int j = 0; j < words.length; ++j) {
					if (word2.equals(words[j])) {
						globalMin = Math.min(globalMin, Math.abs(i - j));
					}
				}
			}
		}
		return globalMin;
	}
	
	/*
	 * Algorithm 2: improve time complexity from O(n^2) to O(n)
	 *  First of all, I set two pointers to record the index of word1 and word2 and a globalMin. Then in just 
	 *  one pass, for each item I encounter, I'll do 3 checks: 1. if it's word1, I update p1. 2. if it's
	 *  word2, I update p2. 3. if p1 != -1 && p2 != -1, I'll calculate current distance and update globalMin if
	 *  necessary. In this way, I can ensure that all p1 and p2 are most adjacent indices.
	 *  
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public int shortestDistanceII(String[] words, String word1, String word2) {
		int p1 = -1, p2 = -1, globalMin = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; ++i) {
			if (word1.equals(words[i])) {
				p1 = i;
			}
			if (word2.equals(words[i])) {
				p2 = i;
			}
			if (p1 != -1 && p2 != -1) {
				globalMin = Math.min(globalMin, Math.abs(p1 - p2));
			}
		}
		return globalMin;
	}
}
