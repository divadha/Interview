package com.david.algorithms;

import java.util.ArrayList;

public class RearrangeArray {

  public static void main(String[] args) {
    RearrangeArray ra = new RearrangeArray();
    ArrayList<Integer> array = new ArrayList<>();
    array.add(3);
    array.add(2);
    array.add(0);
    array.add(1);
    print(array);

    ra.arrange(array);
    print(array);
  }

  public static void print(ArrayList<Integer> array) {
    System.out.print("\n[");
    for (Integer number : array) {
      System.out.print(number + " ");
    }
    System.out.print("]");
  }

  public void arrange(ArrayList<Integer> a) {
    int size = a.size();
    for (int i = 0; i < size; i++) {
      a.set(i, a.get(i) + ((a.get(a.get(i)) % size) * size));
    }
    for (int i = 0; i < size; i++) {
      a.set(i, a.get(i) / size);
    }
  }
}
