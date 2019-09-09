package com.david.algorithms;

import java.util.Arrays;
import java.util.List;

/** https://www.interviewbit.com/problems/rearrange-array/ */
public class RearrangeArray {

  public static void main(String[] args) {
    RearrangeArray ra = new RearrangeArray();
    List<Integer> array = Arrays.asList(3, 2, 0, 1);
    System.out.print("Original array: ");
    array.forEach(a -> System.out.print(a + " "));
    System.out.println();
    arrange(array);

    System.out.print("Arrange array:  ");
    array.forEach(a -> System.out.print(a + " "));
  }

  /**
   * The idea is to have 2 numbers in the same pace, using the formula to encode 2 numbers in one
   * palce Then use the formula for decode the new number;
   *
   * <p>The formula for encode is = n + (a[n] % size) * size
   *
   * <p>Example input: 3, 2, 0, 1
   *
   * <p>3 + (a[3]%4) * 4; = 3 + (1%4) * 4; 3 + 4; 7
   *
   * <p>The formula for decode is = n / size
   */
  public static void arrange(List<Integer> a) {
    int size = a.size();
    for (int i = 0; i < size; i++) {
      int num = a.get(i);
      a.set(i, num + ((a.get(num) % size) * size));
    }

    System.out.print("Encoded array:  ");
    a.forEach(item -> System.out.print(item + " "));
    for (int i = 0; i < size; i++) {
      int num = a.get(i);
      a.set(i, a.get(i) / size);
    }
    System.out.println();
  }
}
