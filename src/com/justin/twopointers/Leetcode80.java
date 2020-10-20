package com.justin.twopointers;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Leetcode80 {
  public static int removeDuplicates(int[] nums) {
    int j = 1, count = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1]) {
        count++;
      } else {
        count = 1;
      }

      if (count <= 2) {
        nums[j] = nums[i];
        j++;
      }
    }

    return j;
  }

  public static void main(String[] args) {
    int result = removeDuplicates(new int[] { 1,1,1,2,2,3 });
    System.out.println(result);
  }
}
