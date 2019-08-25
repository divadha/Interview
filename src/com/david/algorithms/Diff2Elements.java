package com.david.algorithms;

import java.util.Arrays;
import java.util.List;

public class Diff2Elements {

  public static void main(String[] args) {
    System.out.println(diffPossible(Arrays.asList(1, 2, 2, 3, 4), 7));
    //    diffPossible(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 7);
  }

  public static int diffPossible(List<Integer> A, int B) {
    int size = A.size();
    if (size < 2) {
      return 0;
    }

    int first = 0;
    int second = 1;

    while (first < size && second < size) {
      if (first != second && A.get(second) - A.get(first) == B) {
        // System.out.println(A.get(first) + " " + A.get(second));
        return 1;
      }
      if (A.get(second) - A.get(first) < B) {
        second++;
      } else {
        first++;
      }
    }
    return 0;
  }
}
