package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOf3Zero {
  public static void main(String[] args) {}

  public int[][] threeSum(int[] A) {
    Set<List<Integer>> set = new HashSet<>();

    Arrays.sort(A);

    for (int i = 0; i < A.length; i++) {
      int left = i + 1;
      int right = A.length - 1;

      while (left < right) {
        int sum = A[i] + A[left] + A[right];
        if (sum == 0) {
          List<Integer> tmpList = new ArrayList<>();
          tmpList.add(A[i]);
          tmpList.add(A[left]);
          tmpList.add(A[right]);
          set.add(tmpList);
          //   break;
        }
        if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    int index = 0;
    int[][] array = new int[set.size()][3];
    for (List<Integer> list : set) {
      array[index][0] = list.get(0);
      array[index][1] = list.get(1);
      array[index][2] = list.get(2);
      index++;
    }
    return array;
  }
}
