package com.justin.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class LeetCode763 {
  public static List<Integer> partitionLabels(String S) {
    List<Integer> result = new ArrayList<>();

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
      map.put(S.charAt(i), i);
    }

    int bound = 0, j = 0;
    for (int i = 0; i < S.length(); i++) {
      bound = Math.max(bound, map.get(S.charAt(i)));

      if (i == bound) {
        result.add(i - j + 1);
        j = i + 1;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> result = partitionLabels("ababcbacadefegdehijhklij");
    System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(",")));
  }
}
