package com.david.algorithms;

import java.util.Arrays;

public class AddBinary {

  public static void main(String[] args) {
    String A = "100";
    String B = "11";
    System.out.println(A);
    System.out.println(B);
    System.out.println(addBinary(A, B));
  }

  public static String addBinary(String A, String B) {
    StringBuilder result = new StringBuilder();

    if(A.length() > B.length()) {
      char[] zeros = new char[A.length() - B.length()];
      Arrays.fill(zeros, '0');
      B = new String(zeros) + B;
    } else {
      char[] zeros = new char[B.length() - A.length()];
      Arrays.fill(zeros, '0');
      A = new String(zeros) + A;
    }

    int carry = 0;

    for(int i = A.length() - 1; i >= 0; i--){
      int valueA = A.charAt(i) == '0'? 0 : 1;
      int valueB = B.charAt(i) == '0'? 0 : 1;
      int sum = valueA + valueB + carry;
      // 0 = 0 0
      // 1 = 0 1
      // 2 = 1 0
      // 3 = 1 1
      result.append(sum == 0 || sum == 2 ? 0 : 1);
      carry = sum == 0 || sum == 1 ? 0 : 1;
    }
    if(carry == 1) {
      result.append(1);
    }
    return result.reverse().toString();
  }

}
