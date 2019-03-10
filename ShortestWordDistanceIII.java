package arrays;

public class ShortestWordDistanceIII {
	/*
	 * Q: Given a list of words and two words word1 and word2, return the shortest distance between these 
	 * two words in the list.
	 * word1 and word2 may be the same and they represent two individual words in the list.
	 * */
	
	/*
	 * Algorithm: p1 and p2 are the last place where word1 and word2 are seen.
	 *  I set two pointers say p1 and p2 to point to the position of words1 and word2. I will traverse
	 *  the given string array and for each word I encounter, I will check if it equals to word1, if
	 *  so I will update p1 to the current index, at the same time I will check if word1 equals to word2
	 *  if so, I will update last place of p2 to p1 and update the current place to p2. Else I will do second 
	 *  if branch to tell if it equals
	 *  to word2 and p1 != -1 && p1 != p2, under such condition will I update p2 to current position. Of
	 *  course I will use a variable called globalMax to update the intermediate results that I get.
	 *  
	 * Complexity Analysis:
	 * T: O(n) since I only do it in one pass.
	 * S: O(1)
	 * */
	public int shortestWordDistance(String[] words, String word1, String word2) {
		// set the distance variable to long in case of overflow.
		long globalMin = Integer.MAX_VALUE, p1 = globalMin, p2 = -globalMin;
		boolean same = word1.equals(word2);
		for (int i = 0; i < words.length; ++i) {
			if (word1.equals(words[i])) {
				if (same) {
					p1 = p2;
					p2 = i;
				} else {
					p1 = i;
				}
			} else if (word2.equals(words[i])) {
				p2 = i;
			}
			globalMin = Math.min(globalMin, Math.abs(p1 - p2));
		}
		return (int) globalMin;
	}
	
	/*
	 * Algorithm 2: 
	 * 	Only use one index pointer (initial set -1) to represent the index of word1 or word2 
	 * the last time we have ever seen. Traverse the string array, for each word that we see, if it equals 
	 * to word1 or word2: if index != -1 && ((word1 == word2) || (word[index] != word[i])): I update globalMin.
	 * anyway, I will make index to current index i. Return globalMin eventually.
	 * 
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public int shortestWordDistanceII(String[] words, String word1, String word2) {
		int index =  -1;
		int min = words.length;
		for (int i = 0; i < words.length; ++i) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
					min = Math.min(min, i - index);
				}
				index = i;
			}
		}
		return min;
	}
}
