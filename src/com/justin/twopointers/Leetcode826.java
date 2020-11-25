package com.justin.twopointers;

import java.util.Arrays;

/**
 * Type: sort
 * https://leetcode.com/problems/most-profit-assigning-work/
 */

public class Leetcode826 {
  static class Job {
    int difficulty;
    int profit;

    Job(int difficulty, int profit) {
      this.difficulty = difficulty;
      this.profit = profit;
    }
  }

  public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int result = 0;

    Job[] jobs = new Job[difficulty.length];
    for (int i = 0; i < difficulty.length; i++) {
      jobs[i] = new Job(difficulty[i], profit[i]);
    }

    Arrays.sort(worker);
    Arrays.sort(jobs, (a, b) -> a.difficulty - b.difficulty);

    int best = 0;
    for (int i = 0; i < worker.length; i++) {
      int currentWorker = worker[i];
      int j = 0;
      while(j < worker.length && currentWorker >= jobs[j].difficulty) {
        best = Math.max(best, jobs[j].profit);
        j++;
      }
      result += best;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] difficulty = new int[] { 2,4,6,8,10 };
    int[] profit = new int[] { 10, 20, 30, 40, 50 };
    int[] worker = new int[] { 4, 5, 6, 7 };

    int result = maxProfitAssignment(difficulty, profit, worker);
    System.out.println(result);
  }
}
