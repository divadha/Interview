package com.david.algorithms;

public class RomanToNumber {

  public static void main(String[] args) {
    System.out.println("XIV = " + romanToInt("XIV"));
    System.out.println("XX = " + romanToInt("XX"));
  }

  public static int romanToInt(String A) {
    int number = 0;
    int index = 0;
    while (index < A.length()) {
      String code1 = String.valueOf(A.charAt(index));
      String code2 = code1 + (index < A.length() - 1 ? String.valueOf(A.charAt(index + 1)) : "");
      int tmpNumber = value(code2);
      if (tmpNumber == 0) {
        tmpNumber = value(code1);
      } else {
        index++;
      }
      number += tmpNumber;
      index++;
    }

    return number;
  }

  public static int value(String roman) {
    switch (roman) {
      case "I":
        return 1;
      case "IV":
        return 4;
      case "V":
        return 5;
      case "IX":
        return 9;
      case "X":
        return 10;
      case "XL":
        return 40;
      case "L":
        return 50;
      case "XC":
        return 90;
      case "C":
        return 100;
      case "CD":
        return 400;
      case "D":
        return 500;
      case "CM":
        return 900;
      case "M":
        return 1000;
    }
    return 0;
  }
}
