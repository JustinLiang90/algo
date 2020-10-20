package com.justin.twopointers;

import java.util.Arrays;

/**
 * Type: find min/max/target.
 * https://leetcode.com/problems/3sum-smaller/
 */
public class Leetcode259 {
  public static int threeSumSmaller(int[] nums, int target) {
    int result = 0;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int current = nums[i];
      int newTarget = target - current;

      int low = i + 1, high = nums.length - 1;
      while(low < high) {
        int sum = nums[low] + nums[high];
        if (sum < newTarget) {
          result += high - low;
          low++;
        } else {
          high--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int result = threeSumSmaller(new int[] {-2,0,1,3}, 2);
    System.out.println(result);
  }
}
