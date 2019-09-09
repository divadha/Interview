package com.david.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet<>();
    set.add("");
    result.add(new ArrayList<>());
    for (int num : nums) {
      int size = result.size();
      for (int i = 0; i < size; i++) {
        List<Integer> list = result.get(i);
        StringBuilder key = new StringBuilder();
        for (Integer tmpNum : list) {
          key.append(tmpNum);
        }
        key.append(num);
        if (!set.contains(key.toString())) {
          List<Integer> newList = new ArrayList<>(list);
          newList.add(num);
          result.add(newList);
        }
      }
    }
    result = new ArrayList<>(new HashSet<>(result));
    return result;
  }
}
