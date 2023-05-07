
/*
 * 
 * Given an integer array nums sorted in non-decreasing order, 
 * return an array of the squares of each number sorted in non-decreasing order.
 
	Input: nums = [-4,-1,0,3,10]
	Output: [0,1,9,16,100]
	Explanation: After squaring, the array becomes [16,1,0,9,100].
	After sorting, it becomes [0,1,9,16,100].
*/

package com.arrays.twopointer.array;
import java.util.Arrays;

public class SortedSquare {
	public static void main(String[] args) {
		SortedSquare sortedSquare = new SortedSquare();
		int[] square = {-4,-1,0,3,10};
		int [] sortedSquares = sortedSquare.sortedSquares(square);
		for (int a =0 ; a < sortedSquares.length ; a++) {
			System.out.print(sortedSquares[a]+ " ");
		}
	}
	
	public int[] sortedSquares(int[] nums) {
        int[] sortedSquare = new int[nums.length];
        int n = nums.length;
        int left = 0; 
        int right = n-1;
        for (int i = n-1;i >=0 ; i-- ) {
        	int square = 0;
        	if (Math.abs(nums[left]) < Math.abs(nums[right])) {
        		square = nums[right];
        		right--;	
        	}
        	else {
        		square = nums[left];
        		left++;
        	}
        	sortedSquare[i] = square * square;
        }
        return sortedSquare;
    }
	
	public int[] sortedSquares1(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];
        Arrays.sort(ans);
        return ans;
    }
}
