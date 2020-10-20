package com.justin.twopointers;

/**
 * Type: sliding window.
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class Leetcode1248 {
  public static int numberOfSubarrays(int[] nums, int k) {
    int count = 0, left = 0, right = 0, presum = 0, result = 0;

    while(right < nums.length) {
      if (nums[right] % 2 == 1) {
        count++;

        if (count >= k) {
          presum = 1;
          while(nums[left++] % 2 == 0) {
            presum += 1;
          }
          result += presum;
        }
      } else if (count >= k) {
        result += presum;
      }
      right++;
    }

    return result;
  }

  public static void main(String[] args) {
    int result = numberOfSubarrays(new int[]{1,2,2,1,2,1,2,2,2,2,2,1,1,1}, 4);
    System.out.println(result);
  }
}
