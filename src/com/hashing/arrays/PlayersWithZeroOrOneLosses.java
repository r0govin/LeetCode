/*
 * 
 * You are given an integer array matches where matches[i] = [winneri, loseri] 
 * indicates that the player winneri defeated player loseri in a match.

	Return a list answer of size 2 where:
    answer[0] is a list of all players that have not lost any matches.
    answer[1] is a list of all players that have lost exactly one match.

	The values in the two lists should be returned in increasing order.
	
	Eg:
	Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
	Output: [[1,2,10],[4,5,7,8]]
	Explanation:
	Players 1, 2, and 10 have not lost any matches.
	Players 4, 5, 7, and 8 each have lost one match.
	Players 3, 6, and 9 each have lost two matches.
	Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
	
	
 * */

package com.hashing.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersWithZeroOrOneLosses {

	public static void main(String[] args) {

	}

	public List<List<Integer>> findWinners(int[][] matches) {
		Map<Integer, Integer> lossesCount = new HashMap<>();
		for (int[] match : matches) {
			int winner = match[0], loser = match[1];
			lossesCount.put(winner, lossesCount.getOrDefault(winner, 0));
			lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
		}

		List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>());
		for (Integer player : lossesCount.keySet())
			if (lossesCount.get(player) == 0) {
				answer.get(0).add(player);
			} else if (lossesCount.get(player) == 1) {
				answer.get(1).add(player);
			}

		Collections.sort(answer.get(0));
		Collections.sort(answer.get(1));

		return answer;
	}

}
