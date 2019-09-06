package com.david.algorithms;

public class Sqrt {

  public static void main(String[] args) {
    System.out.println(mySqrt(8));
  }

  public static int mySqrt(int x) {
    long result = 0;
    long start = 0;
    long end = x;

    while (start <= end) {
      long mid = (start + end) / 2;
      long sqrt = mid * mid;
      if (sqrt == x) {
        return (int) mid;
      }

      if (sqrt > x) {
        end = mid - 1;
      } else {
        start = mid + 1;
        result = mid;
      }
    }
    return (int) result;
  }
}
