package com.david.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubString {
  public static void main(String[] args) {
    String[] array = {"word", "good", "best", "good"};
    System.out.println(findSubstring("wordgoodgoodgoodbestword", array));
  }

  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }

    int size = words[0].length();
    for (int i = 0; i < s.length() - size; i++) {
      int count = 0;
      Map<String, Integer> tmpMap = new HashMap<>(map);
      for (int j = i; j <= s.length() - size; j += size) {
        String sub = s.substring(j, j + size);
        if (tmpMap.containsKey(sub)) {
          int times = tmpMap.get(sub);
          if (times == 1) {
            tmpMap.remove(sub);
          } else {
            tmpMap.put(sub, times - 1);
          }
          count++;
        } else {
          break;
        }
      }

      if (count == words.length) {
        result.add(i);
      }
    }
    return result;
  }
}
