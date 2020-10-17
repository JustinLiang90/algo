package com.justin.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class LeetCode986 {
  public static int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> result = new ArrayList<>();
    
    int i = 0, j = 0;

    while(i < A.length && j < B.length) {
      int left = Math.max(A[i][0], B[j][0]);
      int right = Math.min(A[i][1], B[j][1]);

      if (left <= right) {
        result.add(new int[] { left, right });
      }

      if (A[i][1] < B[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
    int[][] A = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
    int[][] B = new int[][] { { 1, 2 }, { 5, 5 }, { 8, 10 }, { 24, 24 }, { 25, 25 } };
    intervalIntersection(A, B);
  }
}
