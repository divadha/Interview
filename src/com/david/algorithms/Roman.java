package com.david.algorithms;

public class Roman {

  public static void main(String[] args) {
    System.out.println("10 = " + intToRoman(10));
    System.out.println("9 = " + intToRoman(9));
    System.out.println("91 = " + intToRoman(91));
    System.out.println("90 = " + intToRoman(90));
    System.out.println("99 = " + intToRoman(99));
    System.out.println("8 = " + intToRoman(8));
  }

  public static String intToRoman(int A) {
    String roman = value(A);
    if (!roman.isEmpty()) {
      return roman;
    }

    int array[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 4000};
    int index = 1;

    while (A > 0) {
      if (A < array[index]) {
        roman += value(array[index - 1]);
        A -= array[index - 1];
        index = 0;
      }
      index++;
    }

    return roman;
  }

  public static String value(Integer number) {
    switch (number) {
      case 1:
        return "I";
      case 4:
        return "IV";
      case 5:
        return "V";
      case 9:
        return "IX";
      case 10:
        return "X";
      case 40:
        return "XL";
      case 50:
        return "L";
      case 90:
        return "XC";
      case 100:
        return "C";
      case 400:
        return "CD";
      case 500:
        return "D";
      case 900:
        return "CM";
      case 1000:
        return "M";
    }
    return "";
  }
}
