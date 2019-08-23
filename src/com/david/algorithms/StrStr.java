package com.david.algorithms;

public class StrStr {

  public static void main(String[] args) {
    System.out.println("hello : " + strStr("hello", "ll"));
    System.out.println("Something : " + strStr("Something", "om"));
    System.out.println("bbbbbbbbab : " + strStr("bbbbbbbbab", "baba"));
    "".indexOf("");
  }

  public static int strStr(final String A, final String B) {
    if (A.length() < B.length()) {
      return -1;
    }
    for (int i = 0; i < A.length(); i++) {
      if (A.length() - i < B.length()) {
        return -1;
      }
      if (A.charAt(i) == B.charAt(0)) {
        int countDown = B.length() - 1;
        for (int j = 1; j < B.length(); j++) {
          if (A.charAt(i + j) == B.charAt(j)) {
            countDown--;
          } else {
            break;
          }
        }
        if (countDown == 0) {
          return i;
        }
      }
    }
    return -1;
  }
}
