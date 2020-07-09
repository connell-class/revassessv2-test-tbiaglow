package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		int length = 0;
		for (int num : arr) {
			length += num;
		}
		return length;
	}
}
