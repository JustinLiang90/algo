package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: sliding window, count as the sliding window size.
 * Question: https://leetcode.com/problems/minimum-window-substring/
 */
public class Leetcode76 {
    public static String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String result = s;

        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int j = 0, match = 0;
        Map<Character, Integer> sourceMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            if (targetMap.containsKey(rightChar)) {
                sourceMap.put(rightChar, sourceMap.getOrDefault(rightChar, 0) + 1);
                if (sourceMap.get(rightChar).equals(targetMap.get(rightChar))) {
                    match++;
                }
            }

            while(match == targetMap.size()) {
                String subString = s.substring(j, i + 1);
                result = subString.length() < result.length() ? subString : result;
                minLength = Math.min(subString.length(), result.length());
                char leftChar = s.charAt(j);
                if (sourceMap.containsKey(leftChar)) {
                    sourceMap.put(leftChar, sourceMap.getOrDefault(leftChar, 0) - 1);
                    if (sourceMap.get(leftChar) < targetMap.get(leftChar)) {
                        match--;
                    }
                }
                j++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : result;
    }

    public static void main(String[] args) {
        String result = minWindow("a", "aa");
        System.out.println(result);
    }
}
