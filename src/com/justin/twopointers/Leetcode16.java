package com.justin.twopointers;

import java.util.Arrays;

/**
 * Type: find low/high pointer.
 * https://leetcode.com/problems/3sum-closest/
 */
public class Leetcode16 {
  public static int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE;

    Arrays.sort(nums);
    for (int i = 0; i < nums.length && diff != 0; i++) {
      int low = i + 1;
      int high = nums.length - 1;
      while(low < high) {
        int sum = nums[low] + nums[high] + nums[i];
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }
        if (sum > target) {
          high--;
        } else {
          low++;
        }
      }
    }

    return target - diff;
  }

  public static void main(String[] args) {
    int result = threeSumClosest(new int[] {0,2,1,-3}, 1);
    System.out.println(result);
  }
}
