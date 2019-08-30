package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllUniquePermutations {
  public static void main(String[] args) {
    int[] array = {1, 2, 3};
    permute(array);
  }

  public static void permute(int[] a) {
    List<int[]> list = new ArrayList<>();
    findPermutations(a, 0, a.length, list);
    int[][] matrix = new int[list.size()][a.length];
    int i = 0;
    for (int[] array : list) {
      // matrix[i++] = array;
      System.out.println(Arrays.toString(array));
    }
  }

  /**
   * Returns true if str[current] does not matches with any of the characters after str[index]
   *
   * @param array
   * @param index
   * @param current
   * @return
   */
  public static boolean shouldSwap(int[] array, int index, int current) {
    for (int i = index; i < current; i++) {
      if (array[current] == array[i]) {
        return false;
      }
    }
    return true;
  }

  public static void findPermutations(int array[], int index, int size, List<int[]> list) {
    // Here is where we add the array to the output
    if (index >= size) {
      list.add(array.clone());
      return;
    }
    for (int i = index; i < size; i++) {
      if (shouldSwap(array, index, i)) {
        swap(array, index, i);
        findPermutations(array, index + 1, size, list);
        swap(array, index, i);
      }
    }
  }

  public static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
