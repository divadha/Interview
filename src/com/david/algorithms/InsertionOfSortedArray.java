package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionOfSortedArray {

  public static void main(String[] args) {
    List<Integer> A =
        Arrays.asList(
            3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40,
            41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67,
            68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100,
            101);
    final List<Integer> B =
        Arrays.asList(
            7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98);
    System.out.println("intersect(A, B) = " + intersect(A, B));
  }

  public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
    ArrayList<Integer> result = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < A.size() && j < B.size()) {
      int number1 = A.get(i);
      int number2 = B.get(j);

      if (number1 == number2) {
        result.add(number1);
        i++;
        j++;
      } else if (number1 < number2) {
        i++;
      } else {
        j++;
      }
    }

    return result;
  }
}
