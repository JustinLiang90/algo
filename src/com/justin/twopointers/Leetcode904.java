package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: sliding window, count as window size.
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class Leetcode904 {
  public static int totalFruit(int[] tree) {
    int result = 0, j = 0;
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int i = 0; i < tree.length; i++) {
      int right = tree[i];
      countMap.put(right, countMap.getOrDefault(right, 0) + 1);

      while(countMap.size() > 2) {
        int left = tree[j];
        countMap.put(left, countMap.get(left) - 1);
        if (countMap.get(left) == 0) {
          countMap.remove(left);
        }
        j++;
      }
      result = Math.max(result, i - j + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    int result = totalFruit(new int[] { 0,1,2,2 });
    System.out.println(result);
  }
}
