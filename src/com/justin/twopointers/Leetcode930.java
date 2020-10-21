package com.justin.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: prefix sum.
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
public class Leetcode930 {
  public static int numSubarraysWithSum(int[] A, int S) {
    Map<Integer, Integer> presum = new HashMap<>();
    int sum = 0;
    int total = 0;

    for (int i = 0; i < A.length; i++){
        sum += A[i];
        if (presum.get(sum - S) != null){
            total += presum.get(sum - S);
        }
        if (sum == S) total++;
        presum.put(sum, presum.getOrDefault(sum, 0) + 1);
    }
    
    return total;
  }

  public static void main(String[] args) {
    int result = numSubarraysWithSum(new int[] { 1,0,1,0,1 }, 2);
    System.out.println(result);
  }
}
