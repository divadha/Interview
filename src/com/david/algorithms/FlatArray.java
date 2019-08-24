package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatArray {

  public static void main(String[] args) {
    List<Object> input = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    input.add(1);
    input.add(2);
    input.add(Arrays.asList(3));
    input.add(Arrays.asList(4, Arrays.asList(5,6)));
    print(input);
    flat(input, output);
    System.out.println("new array");
    print(output);
  }

  public static void print(List list) {
    for (Object object : list) {
      System.out.println(object);
    }
  }

  public static void flat(Object object, List<Integer> output) {
    List list = (List) object;
    for(int i = 0; i < list.size(); i++) {
      Object element = list.get(i);
      if(element  instanceof List) {
        flat(element, output);
      } else {
        output.add((Integer)element);
      }
    }
  }
}
