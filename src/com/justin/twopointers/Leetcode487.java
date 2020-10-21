package com.justin.twopointers;

/**
 * Type: sliding window, count as the window size.
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 */
public class Leetcode487 {
  public static int findMaxConsecutiveOnes(int[] nums) {
    int count = 0, j = 0, result = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        count++;

        if (count == 1) {
          result = Math.max(result, i - j + 1);
        }
        while(count > 1) {
          int left = nums[j];
          if (left == 0) {
            count--;
          }
          j++;
        }
      } else {
        result = Math.max(result, i - j + 1);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int result = findMaxConsecutiveOnes(new int[] { 1 });
    System.out.println(result);
  }
}
