package com.justin.twopointers;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 */
public class LoggerRateLimit {
  private static HashMap<String, Integer> cache = new HashMap<>();

  public static boolean shouldPrintMessage(int timestamp, String message) {
    if (!cache.containsKey(message)) {
      cache.put(message, timestamp);
      return true;
    }
    Integer currentTimeStamp = cache.get(message);
    if (currentTimeStamp + 10 <= timestamp) {
      cache.put(message, currentTimeStamp);
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(shouldPrintMessage(100, "bug"));
    System.out.println(shouldPrintMessage(111, "bug"));
  }
}
