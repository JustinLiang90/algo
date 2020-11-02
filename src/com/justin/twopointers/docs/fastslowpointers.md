# Fast/slow pointer

## Scenario

It's often been used to resolve some linked list problems.

For example:

- Check if there is cycle in the linked list.
- Already know there is cycle in the linked list, find out the start pointer of the cycle.
- Find the mid point of the linked list.
- Find the last K item in the linked ist.

### Check if there is cycle in the linked list

#### Idea

Use slow and fast pointer, if faster pointer run to the end, then no cycle, else it will meet slow pointer.

```java
boolean hasCycle(ListNode head) {
  ListNode fast, slow;
  fast = slow = head;

  while(fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;

    if (fast == slow) {
      return true;
    }
  }
  return false;
}
```

### Find out the start pointer of the cycle

Use slow and fast pointer, note their first meeting place, then any pointer back to header, now slow and fast pointer move forward in the same pace, the second meeting place is the start pointer of the cycle.

More explanation: in the first meeting place, fast pointer has walked `2k` and slow pointer walked `k`. And assume the distance between the meeting point and the start pointer of the cycle is `m`, then slow pointer will walk another `k-m` to reach the start pointer of the cycle. The fast pointer can also do that by start from the head, so it can also reach the start pointer of the cycle in `k-m`.

```java
ListNode getCycleStartingPoint(ListNode head) {
  ListNode fast, slow;
  fast = slow = head;

  while(fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;

    if (fast == slow) {
      break;
    }
  }

  slow = head;
  while(slow != head) {
    slow = slow.next;
    fast = fast.next;
  }
  return slow;
}
```

### Find the mid point of the linked list

Make the faster pointer move two items once, and slow pointer move one item once, then when fast pointer reach the end, slow pointer is the mid point.

If total amount of items in the linkedlist is odd, then the poistion of the slow pointer is in the mid, otherwise the right bit of the mid.

```java
ListNode fast, slow;

while(fast != null && fast.next != null) {
  fast = fast.next.next;
  slow = slow.next;
}
return slow;
```

### Find the last K item of the linked list

Similar idea of the last one, let fast pointer move K steps first, and then slow and faster pointer can move together till the end.

```java
ListNode fast, slow;

while(fast != null && fast.next != null && k >= 0) {
  k--;
  fast = fast.next;
}

while(fast != null) {
  fast = fast.next;
  slow = slow.next;
}
return slow;
```
