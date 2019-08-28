package com.david.algorithms;

import java.util.Stack;

public class EvaluateExpressionStack {

  public static void main(String[] args) {
    String[] array = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    //    String[] array = {"2", "1", "+", "3", "*"};
    //    String[] array = {"4", "13", "5", "/", "+"};
    //    String[] array = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(evalRPN(array));
  }

  public static int evalRPN(String[] A) {
    Stack<Integer> stack = new Stack<>();
    int nRight = 0;
    int nLeft = 0;
    for (String element : A) {
      switch (element) {
        case "/":
          nRight = stack.pop();
          nLeft = stack.pop();
          stack.push(nLeft / nRight);
          break;
        case "*":
          nRight = stack.pop();
          nLeft = stack.pop();
          stack.push(nLeft * nRight);
          break;
        case "-":
          nRight = stack.pop();
          nLeft = stack.pop();
          stack.push(nLeft - nRight);
          break;
        case "+":
          nRight = stack.pop();
          nLeft = stack.pop();
          stack.push(nLeft + nRight);
          break;
        default:
          stack.push(Integer.valueOf(element));
      }
    }
    return stack.pop();
  }
}
