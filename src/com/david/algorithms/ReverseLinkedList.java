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
    ListNode head = null;
    ListNode node;
    ListNode prev = null;
    for (Integer number : list) {

      node = new ListNode(number);
      if (prev != null) {
        prev.next = node;
      } else {
        head = node;
      }
      prev = node;
    }
    return head;
  }

  public static void print(ListNode list) {
    while (list != null) {
      System.out.print(" -> " + list.val);
      list = list.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode list = add(Arrays.asList(3, 5));
    print(list);
    list = reverseBetween(list, 1, 2);
    print(list);
  }

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    // 1 2 3 4 5
    // m = 2 n = 4
    ListNode left = null;
    ListNode middle = head;
    ListNode right = null;

    ListNode current = head;
    ListNode priv = head;
    int index = 0;
    while (current != null) {
      index++;
      if (index == m && m != 1) {
        left = head;
        middle = current;
        priv.next = null;
      }
      if (index == n) {
        right = current.next;
        current.next = null;
      }
      priv = current;
      current = current.next;
    }

    middle = reverse(middle);
    return add(left, middle, right);
  }

  public static ListNode add(ListNode left, ListNode middle, ListNode right) {
    ListNode current = left;
    ListNode prev = left;
    while (current != null) {
      prev = current;
      current = current.next;
    }

    if (prev != null) {
      prev.next = middle;
    } else {
      left = middle;
    }

    current = middle;
    while (current != null) {
      prev = current;
      current = current.next;
    }
    prev.next = right;
    return left;
  }

  public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
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
