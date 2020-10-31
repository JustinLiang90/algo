package com.justin.twopointers;

/**
 * Type: sliding window, count as the window size.
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 */
public class Leetcode487 {
  public static int findMaxConsecutiveOnes(int[] nums) {
    int count = 0, left = 0, result = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        count++;
      }
      while (count > 1) {
        if (nums[left] == 0) {
          count--;
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    int result = findMaxConsecutiveOnes(new int[] { 1,0,1,1,0 });
    System.out.println(result);
  }
}
