package com.justin.twopointers;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class Leetcode287 {
  public static int findDuplicate(int[] nums) {
    int low = 0, high = nums.length - 1;

    while(low <= high) {
      int mid = low + (high - low) / 2;

      int count = 0;
      for (int num : nums) {
        if (num <= mid) {
          count++;
        }
      }
      if (count <= mid) {
        low = mid + 1;
      } else {
        high = mid -1;
      }
    }

    return low;
  }

  public static void main(String[] args) {
    int result = findDuplicate(new int[] { 1,3,4,2,2 });
    System.out.println(result);
  }
}

