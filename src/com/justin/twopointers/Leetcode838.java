package com.justin.twopointers;

/**
 * Type: two directions.
 * https://leetcode.com/problems/push-dominoes/
 */
public class Leetcode838 {
  public static String pushDominoes(String dominoes) {
    char[] blocks = dominoes.toCharArray();
    int L = dominoes.length();
    int[] states = new int[L];

    // Go from left to right.
    int state = 0;
    for (int i = 0; i < L; i++) {
      if (blocks[i] == 'R') {
        state = L;
      } else if (blocks[i] == 'L') {
        state = 0;
      } else {
        state = Math.max(state - 1, 0);
      }
      states[i] += state;
    }

    // Go from right to left.
    state = 0;
    for (int i = L - 1; i >= 0; i--) {
      if (blocks[i] == 'L') {
        state = L;
      } else if (blocks[i] == 'R') {
        state = 0;
      } else {
        state = Math.max(state - 1, 0);
      }
      states[i] -= state;
    }

    StringBuilder sb = new StringBuilder();
    for (int s : states) {
      sb.append(s == 0 ? '.' : s > 0 ? 'R' : 'L');
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String result = pushDominoes(".L.R...LR..L..");
    System.out.println(result);
  }
}
