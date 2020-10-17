package com.justin.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Leetcode11 {
  public static int maxArea(int[] height) {
    int low = 0, high = height.length -1, result = 0;

    while(low <= high) {
      int left = height[low];
      int right = height[high];
      result = Math.max(result, Math.min(left, right) * (high - low));

      if (left <= right) {
        low++;
      } else {
        high--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int result = maxArea(new int[] { 4,3,2,1,4 });
    System.out.println(result);
  }
}
