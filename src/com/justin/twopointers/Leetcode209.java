package com.justin.twopointers;

/**
 * Type: presum/sliding window.
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class Leetcode209 {
  public static int minSubArrayLen(int s, int[] nums) {
    int j = 0, result = Integer.MAX_VALUE, sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while(sum >= s) {
        result = Math.min(result, i - j + 1);
        sum -= nums[j];
        j++;
      }
    }

    return result == Integer.MAX_VALUE ? 0 : result;
  }

  public static void main(String[] args) {
    int result = minSubArrayLen(7, new int[] { 2,3,1,2,4,3 });
    System.out.println(result);
  }
}
