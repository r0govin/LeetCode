package com.binarysearch;

public class BinarySearch {

	public int Search(int[] elements, int key) {
		if (elements.length == 0 || key == 0) {
			return -1;
		}
		int low = 0, high = elements.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (elements[mid] == key) {
				return key;
			}
			if (key > elements[mid]) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return -1;
	}

	public int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				// do something
				return mid;
			}
			if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		// target is not in arr, but left is at the insertion point
		return left;
	}
	/*
	 * If your input has duplicates, you can modify the binary search template to find either 
	 * the first or the last position of a given element. If target appears multiple times, 
	 * then the following template will find the left-most index:
	 * */
	public int binarySearchDuplicateLeft(int[] arr, int target) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	/*
	 * The following template will find the right-most insertion point (the index of the 
	 * right-most element plus one):
	 * */
	
	public int binarySearchDuplicateRight(int[] arr, int target) {
	    int left = 0;
	    int right = arr.length;
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        if (arr[mid] > target) {
	            right = mid;
	        } else {
	            left = mid + 1;
	        }
	    }

	    return left;
	}
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int elements[] = { 1, 2, 3, 5, 6, 7, 9, 12 };
		int result = binarySearch.Search(elements, 3);
		System.out.println(result);
	}

}
