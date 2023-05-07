package com.arrays.twopointer.string;

public class ReverseString {

	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		
		reverseString.reverseString("RavikiraN".toCharArray());
	}
	
	public void reverseString (char[] s) {
		int left =0 , right = s.length-1;
        while (left < right) {
             char temp = s[left];
             s[left] = s[right];
             s[right] = temp;
            left++;
            right--;
        }
	}

}
