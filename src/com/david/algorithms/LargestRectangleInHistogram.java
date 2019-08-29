package com.david.algorithms;

import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    System.out.println("Factorial:" + (5));
    int[] array = {90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
    //    int[] array = {2, 1, 5, 6, 2, 3};
    System.out.println(largestRectangleArea(array));
  }

  public static int largestRectangleArea(int[] array) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int top = 0;
    int i = 0;
    while (i < array.length) {
      if (stack.isEmpty() || array[i] >= array[stack.peek()]) {
        stack.push(i);
        i++;
      } else {
        top = stack.pop();
        int area = array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
        maxArea = Math.max(maxArea, area);
      }
    }

    while (!stack.isEmpty()) {
      top = stack.pop();
      int area = array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }
}
