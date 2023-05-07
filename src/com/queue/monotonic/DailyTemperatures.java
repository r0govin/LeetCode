/**
 * 
    PermutationString 1: 739. Daily Temperatures
    Given an array of integers temperatures that represents the daily temperatures, 
    return an array answer such that answer[i] is the number of days you have to wait 
    after the ithith day to get a warmer temperature. If there is no future day that is warmer, 
    have answer[i] = 0 instead.
 */
package com.queue.monotonic;

import java.util.Stack;

/**
 * @author Ravikiran
 *
 */
public class DailyTemperatures {

	public static void main(String[] args) {
		DailyTemperatures dailyTemperatures = new DailyTemperatures();
		int[] temperatures = { 40, 35, 32, 31, 20 };
		int[] result = dailyTemperatures.dailyTemperatures(temperatures);
		for (Integer val : result) {
			System.out.print(val + " ");
		}
	}

	//temperatures = { 40, 35, 32, 37, 50 };						
	
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
				int j = stack.pop();
				answer[j] = i - j; 
			}
			stack.push(i);
		}
		System.out.println("stack "+ stack.toString());
		return answer;
	}
}
