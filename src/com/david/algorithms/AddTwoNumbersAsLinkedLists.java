package com.david.algorithms;

public class AddTwoNumbersAsLinkedLists {

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode addTwoNumbers(ListNode A, ListNode B) {

    int carry = 0;
    ListNode head = new ListNode(0);
    ListNode list = head;

    while (A != null || B != null || carry != 0) {
      int numberA = 0;
      int numberB = 0;

      if (A != null) {
        numberA = A.val;
        A = A.next;
      }
      if (B != null) {
        numberB = B.val;
        B = B.next;
      }

      int sum = numberA + numberB + carry;
      carry = sum / 10;
      list.next = new ListNode(sum % 10);
      ;
      list = list.next;
    }

    return head.next;
  }
}
