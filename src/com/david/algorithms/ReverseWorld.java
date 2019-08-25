package com.david.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWorld {
  public static void main(String[] args) {
    String text = "       Hello    how    are    you   ";
    System.out.println(":" + text + ";");
    System.out.println(":" + reverseWords(text) + ";");
    System.out.println(":" + reverseWordsFaster(text) + ";");
    System.out.println(":" + reverseWordsShorter(text) + ";");
  }

  private static String reverseWordsShorter(String text) {
    List<String> list = Arrays.asList(text.trim().split(" +"));
    Collections.reverse(list);
    return String.join(" ", list);
  }

  public static String reverseWords(String a) {
    String[] array = a.trim().split(" +");
    StringBuilder result = new StringBuilder();

    for (int i = array.length - 1; i > 0; i--) {
      result.append(array[i]);
      result.append(" ");
    }
    if (array.length > 0) {
      result.append(array[0]);
    }
    return result.toString();
  }

  public static String reverseWordsFaster(String a) {
    StringBuilder result = new StringBuilder();
    StringBuilder world = new StringBuilder();
    boolean newWorld = false;
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      if (c == ' ') {
        newWorld = true;
      } else {
        if (newWorld) {
          result.insert(0, result.length() > 0 ? " " : "");
          result.insert(0, world);
          world = new StringBuilder();
        }
        world.append(c);
        newWorld = false;
      }
    }
    if (world.length() > 0) {
      result.insert(0, " ");
      result.insert(0, world);
    }
    return result.toString();
  }
}
