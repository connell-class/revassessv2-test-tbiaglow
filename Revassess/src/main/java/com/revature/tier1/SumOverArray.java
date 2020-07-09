package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		int length = 0;
		for (int i = 0; i < arr.length; i++) {
			length += arr[i];
		}
		return length;
	}
}
