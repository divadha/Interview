package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    System.out.println(maxArea(new ArrayList<>(Arrays.asList(1, 5, 4, 3))));
  }

  public static int maxArea(ArrayList<Integer> A) {
    int left = 0;
    int right = A.size() - 1;
    int result = 0;

    while (left < right) {
      int area = Math.abs(right - left) * Math.min(A.get(left), A.get(right));
      result = Math.max(area, result);
      if (A.get(left) < A.get(right)) {
        left++;
      } else {
        right--;
      }
    }
    return result;
  }
}
