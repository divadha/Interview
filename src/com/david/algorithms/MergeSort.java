package com.david.algorithms;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] array = new int[] {9, 4, 3, 8, 6, 0, 2, 7, 1, 5};
    System.out.println(Arrays.toString(array));
    mergeSort(array, 0, array.length -1);
    System.out.println(Arrays.toString(array));

    "".indexOf("");
  }

  public static void mergeSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = (left + right) / 2;
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
    }

  public static void merge(int[] array, int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i) L[i] = array[l + i];
    for (int j = 0; j < n2; ++j) R[j] = array[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      array[k] = R[j];
      j++;
      k++;
    }
  }
}
