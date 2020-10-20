package com.justin.twopointers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Type: sorting.
 * https://leetcode.com/problems/sort-transformed-array/
 */
public class Leetcode360 {
  public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int low = 0, high = nums.length - 1;
    if (a >= 0) {
      Deque<Integer> result = new LinkedList<>();

      while(low <= high) {
        int lowVal = a * nums[low] * nums[low] + b * nums[low] + c;
        int highVal = a * nums[high] * nums[high] + b * nums[high] + c;
  
        if (lowVal < highVal) {
          result.addFirst(highVal);
          high--;
        } else {
          result.addFirst(lowVal);
          low++;
        }
      }
      return result.stream().mapToInt(i -> i).toArray();
    } else {
      List<Integer> result = new ArrayList<>();
      while(low <= high) {
        int lowVal = a * nums[low] * nums[low] + b * nums[low] + c;
        int highVal = a * nums[high] * nums[high] + b * nums[high] + c;

        if (lowVal < highVal) {
          result.add(lowVal);
          low++;
        } else {
          result.add(highVal);
          high--;
        }
      }
      return result.stream().mapToInt(i -> i).toArray();
    }
  }

  public static void main(String[] args) {
    int[] result = sortTransformedArray(new int[] {-4,-2,2,4}, 1,3,5);
    System.out.println(result);
  }
}
