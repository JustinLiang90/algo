package com.justin.twopointers;

/**
 * Type: Fast and slow pointers.
 * https://leetcode.com/problems/linked-list-cycle-ii/submissions/
 */
public class Leetcode142 {
  class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;

    ListNode meetNode = hasCycle(head);
    if (meetNode == null) {
      return null;
    }

    fast = head;
    slow = meetNode;
    while(fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public ListNode hasCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;

    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return slow;
      }
    }
    return null;
  }
}
