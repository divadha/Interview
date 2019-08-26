package com.david.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Closest3Sum {

  public static void main(String[] args) {
    System.out.println(
        threeSumClosest(
            Arrays.asList(
                -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6,
                -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9,
                -2, 7, 0, -4, -3, 1, 6, -3),
            -1));
  }

  public static int threeSumClosest(List<Integer> A, int B) {
    int result = A.get(0) + A.get(1) + A.get(2);
    Collections.sort(A);

    // 1 2 3 4 5 6 7 8 9 10
    for (int i = 0; i < A.size() - 2; i++) {
      int left = i + 1;
      int right = A.size() - 1;
      while (left < right) {
        int sum = A.get(i) + A.get(left) + A.get(right);
        if (sum == B) {
          return sum;
        }

        if (sum > B) {
          right--;
        } else {
          left++;
        }

        if (Math.abs(sum - B) < Math.abs(result - B)) {
          result = sum;
        }
      }
    }
    return result;
  }
}
