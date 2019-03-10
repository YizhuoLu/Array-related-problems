package arrays;

public class TeemoAttacking {
	/*
	 * Q: In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in 
	 * poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the 
	 * poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in 
	 * poisoned condition.
	 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe 
	 * be in poisoned condition immediately.
	 * 
	 * 1. You may assume the length of given time series array won't exceed 10000.
	 * 2. You may assume the numbers in the Teemo's attacking time series and his poisoning time duration 
	 * per attacking are non-negative integers, which won't exceed 10,000,000.
	 * */
	
	/*
	 * Algorithm:
	 *  In the process of traversal, for each item that I encounter, if x[i] < x[i-1]+duration: 
	 *  res += x[i] - x[i-1]. else res += duration.
	 *  
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	
	public int findPoisonedDuration(int[] timeSeries, int duration) {
        // corner case
        if (timeSeries.length == 0) {
            return 0;
        }
        int res = duration;
        for (int i = 1; i < timeSeries.length; ++i) {
            int rightBound = timeSeries[i - 1] + duration;
            if (timeSeries[i] < rightBound) {
                res += timeSeries[i] - timeSeries[i - 1];
            } else {
                res += duration;
            }
        }
        return res;
    }
}
