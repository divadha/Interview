package com.david.algorithms;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {
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

    // 1 2 3 4 5
    // 5 4 3 2 1
    // 4 3 2 1 5 : 1 : 4
    // 1 4 3 2 5 : 2 : 4



    ListNode list = add(Arrays.asList(1, 2, 3, 4, 5));
    print(list);
    list = reverseBetween(list, 2, 4);
    print(list);
  }

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode prev = null;
    ListNode current = head;
    int index = 0;
    while (current != null) {
      index++;
      if (index == m) {
        if (prev != null) {
          prev.next = reverse(current, n - m + 1);
        } else {
          head = reverse(current, n - m + 1);
        }
        break;
      }
      prev = current;
      current = current.next;
    }

    return head;
  }

  public static ListNode reverse(ListNode head, int length) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;
    while (current != null && length > 0) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      length--;
    }
    if (current != null) {
      head.next = current;
    }
    return prev;
  }
}
