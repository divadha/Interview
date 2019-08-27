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

  public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {

      int sum = A.val + B.val;
      int carry = sum / 10;
      ListNode head = new ListNode(sum % 10);
      ListNode list = head;
      A = A.next;
      B = B.next;

      while (A != null || B != null) {
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

        sum = numberA + numberB + carry;
        // System.out.println("Sum:" + sum);
        carry = sum / 10;
        list.next = new ListNode(sum % 10);
        ;
        list = list.next;
      }
      if (carry != 0) {
        list.next = new ListNode(carry);
      }

      return head;
    }
  }
}
