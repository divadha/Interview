package com.david.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  public static void main(String[] args) {
    List<String> result = new ArrayList<>();
    generate(3, 3, "", result);
    System.out.println(result);
  }

  public static void generate(int numLeft, int numRight, String current, List<String> result) {
    if (numLeft == 0 && numRight == 0) {
      result.add(current);
      return;
    }

    if (numLeft > 0) {
      generate(numLeft - 1, numRight, current + "(", result);
    }

    if (numLeft < numRight) {
      generate(numLeft, numRight - 1, current + ")", result);
    }
  }
}
