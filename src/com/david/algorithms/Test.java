package com.david.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.remove("3");
    String[] array = new String[]{"Hello" ,"how", "are", "you"};
    System.out.println(String.join(" ", array));
    for (String item : list) {
      System.out.println(item);
    }
  }
}
