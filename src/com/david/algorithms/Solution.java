package com.david.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Collections.sort(list);
    findCombinations(list, 0, target, new ArrayList<>(), result);
    return result;
  }

  public static void findCombinations(
      ArrayList<Integer> list,
      int index,
      int target,
      ArrayList<Integer> currentNumbers,
      ArrayList<ArrayList<Integer>> result) {
    // If we found the target, and we add the current to the list
    if (target == 0) {
      result.add(new ArrayList<>(currentNumbers));
      return;
    }

    // If target is negative don't continue
    if (target < 0) {
      return;
    }

    for (int i = index; i < list.size(); i++) {
      // Check for no duplicates
      if (i == index || !list.get(i).equals(list.get(i - 1))) {
        // if there are not duplicate add the current number to the current list
        currentNumbers.add(list.get(i));
        // We make a recursive call
        findCombinations(list, i, target - list.get(i), currentNumbers, result);
        currentNumbers.remove(currentNumbers.size() - 1);
      }
    }
  }
}
