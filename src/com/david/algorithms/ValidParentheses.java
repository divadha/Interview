package com.david.algorithms;

import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    System.out.println("(((((()))))) = " + isValid("(((((())))))"));
    System.out.println("()()()() = " + isValid("()()()()"));
    System.out.println("(((((((() = " + isValid("(((((((()"));
    System.out.println("((()(()))) = " + isValid("((()(())))"));
    System.out.println("([)] = " + isValid("([)]"));
  }

  public static boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      switch (c) {
        case '[':
        case '{':
        case '(':
          stack.push(c);
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') {
            return false;
          }
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return false;
          }
          break;
        default:
          return false;
      }
    }
    return stack.isEmpty();
  }
}
