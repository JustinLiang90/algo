package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: prefix sum.
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class Leetcode1248 {
  public static int numberOfSubarrays(int[] nums, int k) {
    int result = 0;
    Map<Integer, Integer> presum = new HashMap<>();

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i] % 2;
      if (presum.containsKey(sum - k)) {
        result += presum.get(sum - k);
      }
      if (sum == k) {
        result += 1;
      }
      presum.put(sum, presum.getOrDefault(sum, 0) + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    int result = numberOfSubarrays(new int[]{2,4,6}, 3);
    System.out.println(result);
  }
}
