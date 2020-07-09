package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		int length = 0;
		for (int i : arr) {
			length = length + i;
		}
		return length;
	}
}
