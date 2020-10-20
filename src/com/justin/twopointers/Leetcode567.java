package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: sliding window.
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Leetcode567 {
  public static boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> targetMap = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      targetMap.put(s1.charAt(i), targetMap.getOrDefault(s1.charAt(i), 0) + 1);
    }

    int j = 0;
    Map<Character, Integer> runningMap = new HashMap<>();
    for (int i = 0; i < s2.length(); i++) {
      char right = s2.charAt(i);
      runningMap.put(right, runningMap.getOrDefault(right, 0) + 1);

      int windowSize = i - j + 1;
      // Check if match condition.
      if (windowSize == s1.length()) {
        if (matches(targetMap, runningMap)) {
          return true;
        }

        char left = s2.charAt(j);
        runningMap.put(left, runningMap.get(left) - 1);
        if (runningMap.get(left) == 0) {
          runningMap.remove(left);
        }
        j++;
      }
    }

    return matches(targetMap, runningMap);
  }

  public static boolean matches(Map<Character, Integer> targetMap, Map<Character, Integer> runningMap) {
    if (targetMap.size() != runningMap.size()) {
      return false;
    }

    for (Map.Entry<Character, Integer> entry: runningMap.entrySet()) {
      if (!targetMap.containsKey(entry.getKey())) {
        return false;
      }
      if (entry.getValue() != targetMap.get(entry.getKey())) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    boolean result = checkInclusion("abcdefghijk", "eidboauaifduaiudfiuadsbfjbxcnvbbiwoeryiouqyerioqyeihasjdkfhoooabjaksjdfkcdefghijk");
    System.out.println(result);
  }
}
