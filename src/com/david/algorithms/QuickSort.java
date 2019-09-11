package com.david.algorithms;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    //    int[] array = new int[] {3, 2, 1, 4, 5, 7, 8, 9, 0, 6};
    int[] array = new int[] {6, 4, 5, 7, 8, 3, 2, 1, 9, 0};
    System.out.println(Arrays.toString(array));
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  public static void quickSort(int[] array, int start, int end) {
    if (start < end) { // Stop when we have one or non elements
      int pivot = partition(array, start, end);
      quickSort(array, start, pivot - 1); // Left part of the pivot without pivot
      quickSort(array, pivot + 1, end); // Right part of the pivot without pivot
    }
  }

  private static int partition(int[] array, int start, int end) {
    int pivot = array[end];
    int index = start;

    for (int i = start; i < end; i++) {
      if (array[i] <= pivot) {
        swap(array, i, index);
        index++;
      }
    }
    swap(array, index, end);

    return index;
  }

  public static void swap(int[] array, int index1, int index2) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }
}
