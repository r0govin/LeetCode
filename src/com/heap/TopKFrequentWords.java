/*
	Top K Frequent Words

	Given an array of strings words and an integer k, return the k most frequent 
	strings.
	Return the answer sorted by the frequency from highest to lowest. 
	Sort the words with the same frequency by their lexicographical order.
	 
	PermutationString 1:
	Input: words = ["i","love","leetcode","i","love","coding"], k = 2
	Output: ["i","love"]
	Explanation: "i" and "love" are the two most frequent words.
	Note that "i" comes before "love" due to a lower alphabetical order.
	
	PermutationString 2:
	Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], 
	k = 4
	Output: ["the","is","sunny","day"]
	Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
	with the number of occurrence being 4, 3, 2 and 1 respectively.
	 

 * */

package com.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> cnt = new HashMap<>();
		for (String word : words) {
			cnt.put(word, cnt.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<String> h = new PriorityQueue<>(
				(w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2));

		for (String word : cnt.keySet()) {
			h.offer(word);
			if (h.size() > k)
				h.poll();
		}

		List<String> res = new ArrayList<>();
		while (!h.isEmpty())
			res.add(h.poll());
		Collections.reverse(res);
		return res;
	}

}
