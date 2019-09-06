package com.david.algorithms;

public class RegularExpression {
  public static void main(String[] args) {
    System.out.println(isMatch("aab", ""));
  }

  public static boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }
    char tChar = text.charAt(0);
    char pChar = pattern.charAt(0);
    boolean firstMatch = (!text.isEmpty() && (pChar == tChar || pChar == '.'));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (isMatch(text, pattern.substring(2))
          || (firstMatch && isMatch(text.substring(1), pattern)));
    } else {
      return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
  }
}
