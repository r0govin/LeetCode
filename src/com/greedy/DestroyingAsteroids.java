/*
 * 

    PermutationString 1: 2126. Destroying Asteroids

    You are given an integer array asteroids and an integer mass representing 
    the mass of a planet. The planet will collide with the asteroids one by 
    one - you can choose the order. If the mass of the planet is less than 
    the mass of an asteroid, the planet is destroyed. Otherwise, 
    the planet gains the mass of the asteroid. Can you destroy all the asteroids?

 * */

package com.greedy;

import java.util.Arrays;

public class DestroyingAsteroids {

	public static void main(String[] args) {

	}

	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
		Arrays.sort(asteroids);
		long currMass = mass;
		for (int asteroid : asteroids) {
			if (asteroid > currMass) {
				return false;
			}
			currMass += asteroid;
		}

		return true;
	}

}
