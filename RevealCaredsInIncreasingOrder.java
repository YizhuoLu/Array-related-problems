package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCaredsInIncreasingOrder {
	/*
	 * Q: In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
	 * Initially, all the cards start face down (unrevealed) in one deck.
	 * Now, you do the following steps repeatedly, until all cards are revealed:
	 * Take the top card of the deck, reveal it, and take it out of the deck.
	 * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
	 * If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
	 * Return an ordering of the deck that would reveal the cards in increasing order.
	 * The first entry in the answer is considered to be the top of the deck.
	 * 
	 * 1. 1 <= A.length <= 1000
	 * 2. 1 <= A[i] <= 10^6
	 * 3. A[i] != A[j] for all i != j
	 * */
	
	/*
	 * Data structure: Queue
	 * Algorithm: 
	 *   simulate the reversed process using a queue, each time, we firstly sort the array to get the
	 *   resultant array. if queue's size is not 0, we put the last item to the head position. Then we
	 *   put the new item at the queue head. Finally we put the items from queue to res array from
	 *   back to front.
	 *   
	 * Complexity Analysis:
	 * T: O(nlogn)
	 * S: O(n)
	 * */
	
	public int[] deckRevealedIncreasing(int[] deck) {
		// corner case
		if(deck.length <= 1) {
			return deck;
		}
		Queue<Integer> queue = new LinkedList<>();
		Arrays.sort(deck);
		for (int i = deck.length - 1; i >= 0; --i) {
			if (!queue.isEmpty()) {
				// put the tail item to the head.
				queue.offer(queue.poll());
			}
			queue.offer(deck[i]);
		}
		int[] res = new int[deck.length];
		for (int i = res.length - 1;i >= 0; --i) {
			res[i] = queue.poll();
		}
		return res;
	}
}
