package com.david.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {

  public static void main(String[] args) {
    Map<Character, String> map;
    System.out.println(letterCombinations("23"));
  }

  static Map<Character, String> map = new HashMap<>();

  static {
    map.put('0', "0");
    map.put('1', "1");
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
  }

  public static ArrayList<String> letterCombinations(String A) {
    ArrayList<String> result = new ArrayList<>();
    if (A.isEmpty()) {
      return result;
    }
    char[] word = new char[A.length()];
    generate(A.toCharArray(), 0, word, result);
    return result;
  }

  public static void generate(char[] digits, int index, char[] word, ArrayList<String> result) {
    if (index == digits.length) {
      result.add(new String(word));
      return;
    }

    String letters = map.get(digits[index]);
    for (int i = 0; i < letters.length(); i++) {
      word[index] = letters.charAt(i);
      generate(digits, index + 1, word, result);
    }
  }
}
