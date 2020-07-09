package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		int sum = 0;
	      //Advanced for loop
	      for( int num : arr) {
	          sum = sum + num;
	      }
		return sum;
	}
}
