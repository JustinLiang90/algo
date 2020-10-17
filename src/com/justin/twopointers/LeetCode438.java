package com.justin.twopointers;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class LeetCode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> targetMap = new HashMap<>();
        for(char c: p.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            if (targetMap.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
                if (map.get(rightChar).equals(targetMap.get(rightChar))) {
                    count++;
                }
            }

            while(count == targetMap.size()) {
                if (i - j + 1 == p.length()) {
                    result.add(j);
                }

                char leftChar = s.charAt(j);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) < targetMap.get(leftChar)) {
                        count--;
                    }
                }
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = findAnagrams("ababababab", "aab");
        System.out.println(Arrays.stream(result.toArray()));
    }
}
