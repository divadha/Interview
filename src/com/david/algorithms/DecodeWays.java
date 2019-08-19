package com.david.algorithms;

public class DecodeWays {

  public static void main(String[] args) {
    DecodeWays dw = new DecodeWays();

    System.out.println("226: 3=" + dw.numDecodings("226"));
    System.out.println("110: 1=" + dw.numDecodings("110"));
    System.out.println("1010: 1=" + dw.numDecodings("1010"));
    System.out.println("12: 2=" + dw.numDecodings("12"));
  }
  public int numDecodings(String A) {
    int size = A.length();
    if(A.charAt(0) == '0'){
      return 0;
    }
    int[] count = new int[size + 1];
    count[0] = 1;
    count[1] = 1;

    for(int i = 2; i<= size; i++) {
      count[i] = 0;

      if(A.charAt(i-1) != '0') {
        count[i] = count[i-1];
      }

      int number = (count[i-2] - '0') * 10 + (count[i-1] - '0');
      if(number > 9 && number < 27) {
        count[i] += count[i-2];
      }
    }
    return count[size];
  }

  public int numDecodings2(String A) {
    int size = A.length();

    // validate that the first digit is not 0
    if (A.charAt(0) == '0') {
      return 0;
    }
    // Creating an array to store the number of ways
    int[] count = new int[size + 1];
    count[0] = 1;
    count[1] = 1;

    for (int i = 2; i <= size; i++) {
      // Setting 0 to the current index
      count[i] = 0;

      // If the previews number is different that 0 add the previews count to the current
      if (A.charAt(i - 1) != '0') {
        count[i] = count[i - 1];
      }
      int number = (A.charAt(i - 2) - '0') * 10 + (A.charAt(i - 1) - '0');
      // If the number (2 digits) is between 10 and 26, add the first count
      if (number > 9 && number < 27) {
        count[i] += count[i - 2];
      }
    }

    return count[size];
  }
}
