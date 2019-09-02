package com.david.algorithms;

import java.util.Arrays;
import java.util.List;

public class LinkedList2 {

  static class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }

    @Override
    public String toString() {
      return "val=" + val;
    }
  }

  public static ListNode add(List<Integer> list) {
    ListNode head = new ListNode(-1);
    ListNode prev = head;
    for (Integer number : list) {
      ListNode current = new ListNode(number);
      prev.next = current;
      prev = current;
    }
    return head.next;
  }

  public static void print(ListNode list) {
    while (list != null) {
      System.out.print(" -> " + list.val);
      list = list.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode list = add(Arrays.asList(1, 2, 3, 4, 5));
    print(list);
    list = reverse(list);
    print(list);
  }

  public static ListNode reverse(ListNode list) {
    ListNode prev = null;
    ListNode current = list;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }
}
