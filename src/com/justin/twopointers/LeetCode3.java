package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.get(rightChar) > 1) {
                char leftChar = s.charAt(j);
                map.put(leftChar, map.get(leftChar) - 1);
                j++;
            }
            result = Math.max(result, i - j + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }
}
