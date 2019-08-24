package com.david.algorithms;

public class CountAndSay {
  public static void main(String[] args) {
    System.out.println("1 = " + countAndSay(1));
    System.out.println("2 = " + countAndSay(2));
    System.out.println("3 = " + countAndSay(3));
    System.out.println("4 = " + countAndSay(4));
    System.out.println("5 = " + countAndSay(5));
    System.out.println("6 = " + countAndSay(6));
    System.out.println("7 = " + countAndSay(7));
    System.out.println("8 = " + countAndSay(8));
    System.out.println("9 = " + countAndSay(9));
  }

  public static String countAndSay(int A) {
    String answer = "1";

    for (int i = 1; i < A; i++) {
      answer = generateCode(answer);
    }
    return answer;
  }

  public static String generateCode(String code) {
    StringBuilder out = new StringBuilder();
    char lastC = code.charAt(0);
    int count = 1;
    for (int i = 1; i < code.length(); i++) {
      char c = code.charAt(i);
      if (lastC == c) {
        count++;
      } else {
        out.append(count);
        out.append(lastC);
        lastC = c;
        count = 1;
      }
    }

    out.append(count);
    out.append(lastC);
    return out.toString();
  }
}
