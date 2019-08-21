package com.david.algorithms;

public class Square {
  public static void main(String[] args) {
    System.out.println("1 root square = " + floorSqrt(1));
    System.out.println("2 root square = " + floorSqrt(2));
    System.out.println("4 root square = " + floorSqrt(4));
    System.out.println("9 root square = " + floorSqrt(9));
    System.out.println("11 root square = " + floorSqrt(11));
    System.out.println("16 root square = " + floorSqrt(16));
  }

  public static int sqrt(int a) {
    if (a == 0 && a == 1) {
      return a;
    }
    int i = 2;
    int s = i * i;
    while (s <= a) {
      i++;
      s = i * i;
    }
    return i - 1;
  }

  public static int floorSqrt(int a) {
    if (a * a == a) {
      return a;
    }

    int start = 1;
    int end = a;
    int answer = 0;

    while (start <= end) {
      int middle = (start + end) / 2;

      // Perfect square
      if (middle * middle == a) {
        return middle;
      }

      if (middle * middle < a) {
        start = middle + 1;
        answer = middle;
      } else {
        end = middle - 1;
      }
    }
    return answer;
  }
}
