# Sliding Window

## Scenario

If the question is to find substring/subarray given a target, sliding window technic could be one of the solution.

## Idea

1. Initialize two pointers: left and right.
2. Right pointer keeps moving to make the window size bigger, till all the items in the window meet the requirement.
3. Stop moving right pointer, and start moving left pointer instead, till all the items in the window break the requirements.
4. Repeat step2, 3 untill right pointer reach the end of the string/array.

`Step2` is to find potential solutions, and `Step3` is to optimze/find min, max of the solution.

### Framework

```java
int left = 0;
String result = "";

for (int right = 0; right < s.length(); right++) {
  window.add(s[right]);

  while(window meets the requirment) {
    result = min/max(result, window);
    window.remove(s[left]);
    left++;
  }
}

return result;
```

### How to figure out if window meets the requirment

1. Use simple integer for counting.
    - [Leetcode80](../Leetcode80.java)
    - [Leetcode487](../Leetcode487.java)
    - [Leetcode1004](../Leetcode1004.java)
    - [Leetcode209](../Leetcode209.java)
2. Use hashmap as a notebook to count the appearance of each item in the window.
    - [Leetcode76](../Leetcode76.java)
    - [Leetcode159](../Leetcode159.java)
    - [Leetcode904](../Leetcode904.java)
    - [Leetcode3](../Leetcode3.java)
    - [Leetcode576](../Leetcode576.java)
    - [Leetcode438](../Leetcode438.java)

### More detail framework

```java
int left = 0;
String result = "";
Map<Character, Integer> map = new HashMap<>();

for (int right = 0; right < s.length(); right++) {
  char rightValue = s.charAt(right);
  map.put(rightValue, map.getOrDefault(rightValue, 0) + 1);

  while (target == map.size()) {
    result = min/max(result, window);
    char leftValue = s.charAt(left);

    map.put(leftValue, map.get(leftValue) - 1);
    // always make the window match the requirement.
    if (map.get(leftValue) == 0) {
      map.remove(leftValue);
    }
    left++;
  }
}
return result;
```

## Variations

1. May use a target value as a window size. (Presum technique may help in the case)
2. Use mutilple map as notebooks. [Leetcode76](../Leetcode76.java)
