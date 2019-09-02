package com.david.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> findSubstring(String A, final List<String> B) {
    ArrayList<Integer> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String word : B) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }

    int size = B.get(0).length();

    for (int i = 0; i <= A.length() - size; i++) {
      Map<String, Integer> tmpMap = new HashMap<>(map);
      int count = 0;
      for (int j = i; j <= A.length() - size; j += size) {
        String subS = A.substring(j, j + size);
        if (tmpMap.containsKey(subS)) {
          int times = tmpMap.get(subS);
          if (times == 1) {
            tmpMap.remove(subS);
          } else {
            tmpMap.put(subS, times - 1);
          }
          count++;
        } else {
          break;
        }

        if (count == B.size()) {
          result.add(i);
          break;
        }
      }
    }

    return result;
  }
}
