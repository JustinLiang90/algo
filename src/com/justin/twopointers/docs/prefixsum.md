# Prefix sum

## Scenario

If the question is about to find **number** of substring/subarray, presum could be one of the solution.

## Idea

Prefix sum is a good solution of find the sum between index i and j in an array in one loop.

For example, given an array: `[1,2,3,4,5,6]`, we need to find the sum between index 1 and 2, and also the sum between index 3 and 5.

We can archieve the goal by for loop twice, however, the more eariser solution is to use prefix sum.

Here is the prefix sum array: `[1,3,6,10,15,21]`, so we can easily to get the sum between index 1 and 2 is `6-1=5` and the sum between index 3 and 5 is `21-6=15` without keep looping.

## How it can help

We can use [Leetcode930](../Leetcode930.java) as an example.

### Step1: Brute force

Find all subarrays, sum up and compare with with S.

However, the tricky part is **how to find the sum of a subarray fast?**, according to the last example, we can build a prefix sum.

### Step2: Brute force with prefix sum

So immediately, we can think of using prefix sum to find the subarrays which sum is equal to S.

```java
int subarraySum(int[] A, int S) {
  int length = A.length;
  int[] prefixSum = new int[n+1];
  prefixSum[0] = 0;
  for (int i = 0; i < prefixSum; i++) {
    prefixSum[i + 1] = prefixSum[i] + A[i];
  }

  int result = 0;
  for (int i = 1; i <= length; i++) {
    for (int j = 0; j < i; j++) {
      if (sum[i] - sum[j] == S) {
        result++;
      }
    }
  }
  return result;
}
```

### Step3: Optimized solution

Let's look into the nested loop:

```java
for (int j = 0; j < i; j++) {
  if (sum[i] - sum[j] == S) {
    result++;
  }
}
```

it's counting how many `j`, which can make the different between `sum[i]` and `sum[j]` is equals to `S`, if find the pair, `result++`.

We can also transform the equation into: `sum[j] == sum[i] - S`. The idea is count how many `sum[j]` equal to `sum[i] - S`. Then we can use hash map to record the prefix sum and it's frequency.

```java
int subarraySum(int[] A, int S) {
  Map<Integer, Integer> presum = new HashMap<>();
  presum.put(0, 1);

  int sum = 0, result = 0;
  for (int i = 0; i < A.length; i++) {
    sum += A[i];

    int presumTarget = sum - S;
    if (presum.containsKey(presumTarget)) {
      result++;
    }
    presum.put(presumTarget, presum.getOrDefault(presumTarget, 0));
  }

  return result;
}
```
