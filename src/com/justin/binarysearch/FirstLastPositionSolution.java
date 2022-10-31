package com.justin.binarysearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastPositionSolution {
  public static int[] searchRange(int[] nums, int target) {
    int leftResult = findLeftMost(nums, target);
    if (leftResult == -1) {
      return new int[]{-1, -1};
    }
    int rightResult = findRightMost(nums, target);
    return new int[]{leftResult, rightResult};
  }

  public static int findLeftMost(int[] nums, int target) {
    int left = 0;
    int right = nums.length;

    while(left < right) {
      int mid = left + (right-left) / 2;
      if (nums[mid] == target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      }
    }
    if (left == nums.length) {
      return -1;
    }
    return nums[left] == target ? left : -1;
  }

  public static int findRightMost(int[] nums, int target) {
    int left = 0;
    int right = nums.length;

    while (left < right) {
      int mid = left + (right-left) / 2;
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid;
      }
    }
    if (left - 1 < 0) {
      return -1;
    }
    return nums[left-1] == target ? left - 1: -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5,7,7,8,8,10};
    int[] result = searchRange(nums, 8);
    System.out.print(result);
  }
}