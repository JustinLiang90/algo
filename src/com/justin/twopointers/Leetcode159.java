package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: sliding window, count as the sliding window size.
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class Leetcode159 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int distinct = 0, j = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char left = s.charAt(i);
            if (!map.containsKey(left)) {
                map.put(left, 1);
                distinct++;
            } else {
                map.put(left, map.get(left) + 1);
            }

            if (distinct <= 2) {
                result = Math.max(result, i - j + 1);
            }
            while(distinct > 2) {
                char right = s.charAt(j);
                map.put(right, map.get(right) - 1);
                j++;

                if (map.get(right) == 0) {
                    map.remove(right);
                    distinct--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstringTwoDistinct("abcabcabc");
        System.out.println(result);
    }
}
