package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {
  public static void main(String[] args) {

    List<List<Integer>> array = new ArrayList<>();
    array.add(Arrays.asList(1, 2, 3, 4));
    array.add(Arrays.asList(5, 6, 7, 8));
    array.add(Arrays.asList(9, 10, 11, 12));
    array.add(Arrays.asList(13, 14, 15, 16));
    //    array.add(Arrays.asList(1, 2, 3));
    //    array.add(Arrays.asList(4, 5, 6));
    //    array.add(Arrays.asList(7, 8, 9));
    print(array);
    rotate(array);
    System.out.println();
    print(array);
  }

  public static void print(List<List<Integer>> a) {
    for (List<Integer> list : a) {
      System.out.println(list);
    }
  }

  public static void rotate(List<List<Integer>> a) {
    int size = a.size();
    int half = size % 2 == 0 ? size / 2 : size / 2 + 1;

    for (int y = 0; y < size / 2; y++) {
      for (int x = 0; x < half; x++) {
        int l1 = a.get(y).get(x);
        int l2 = a.get(x).get(size - 1 - y);
        int l3 = a.get(size - 1 - y).get(size - 1 - x);
        int l4 = a.get(size - 1 - x).get(y);
        a.get(y).set(x, l4);
        a.get(size - 1 - x).set(y, l3);
        a.get(size - 1 - y).set(size - 1 - x, l2);
        a.get(x).set(size - 1 - y, l1);
      }
    }
  }
}
