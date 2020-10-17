package com.justin.twopointers;

/**
 * It maintains last success window, if find larger one, extend the windown size again.
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class Leetcode1004 {
  public static int longestOnes(int[] A, int K) {
    int count = 0, left = 0, right = 0;

    while(right < A.length) {
      if (A[right] == 0) {
        count++;
      }
      if (count > K) {
        if (A[left] == 0) {
          count--;
        }
        left++;
      }
      right++;
    }

    return right - left;
  }

  public static void main(String[] args) {
    int result = longestOnes(new int[] { 1,1,1,0,0,0,1,1,1,1,0 }, 2);
    System.out.println(result);
  }
}
