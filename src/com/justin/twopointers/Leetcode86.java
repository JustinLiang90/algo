package com.justin.twopointers;

/**
 * Type: Linked list.
 * https://leetcode.com/problems/partition-list/
 */
public class Leetcode86 {
  class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode partition(ListNode head, int x) {
    ListNode after_head = new ListNode(0);
    ListNode after = after_head;

    ListNode before_head = new ListNode(0);
    ListNode before = before_head;

    while(head != null) {
      if (head.val < x) {
        before.next = new ListNode(head.val);
        before = before.next;
      } else {
        after.next = new ListNode(head.val);
        after = after.next;
      }
      head = head.next;
    }

    after.next = null;
    before.next = after_head.next;

    return before_head.next;
  }
}