package com.david.algorithms;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class PrettyJson {

  public static void main(String... args) {
    //    String input = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
    //    System.out.println(input);
    //    print(prettyJSON(input));
    //    String input2 = "[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]";
    //    System.out.println(input2);
    //    print(prettyJSON(input2));
    //    String input = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
    //    System.out.println(input);
    //    print(prettyJSON(input));
    String input = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}, Z:\"z\"}}";
    System.out.println(input);
    print(prettyJSON(input));

    //        String input =
    // "{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}";
    //        System.out.println(input);
    //        print(prettyJSON(input));
  }

  public static void print(ArrayList<String> list) {

    for (String line : list) {
      System.out.println(line);
    }
  }

  public static ArrayList<String> prettyJSON(String A) {
    ArrayList<String> out = new ArrayList<>();
    boolean newLine = false;
    int tab = 0;
    StringBuilder line = new StringBuilder();

    for (int i = 0; i < A.length(); i++) {
      char c = A.charAt(i);

      if (c == ',') {
        line.append(c);
        newLine = true;
        continue;
      }

      if (newLine) {
        out.add(line.toString());
        line = addTab(tab);
      }

      if (c == '[' || c == '{') {
        if (!line.toString().trim().isEmpty()) {
          out.add(line.toString());
        }
        line = addTab(tab);
        line.append(c);
        newLine = true;
        tab++;
        continue;
      }

      if (c == ']' || c == '}') {
        if (!line.toString().trim().isEmpty()) {
          out.add(line.toString());
        }
        tab--;
        line = addTab(tab);
        line.append(c);
        newLine = true;
        continue;
      }

      line.append(c);
      newLine = false;
    }
    out.add(line.toString());
    return out;
  }

  public static StringBuilder addTab(int number) {
    StringBuilder tabs = new StringBuilder();
    for (int i = 0; i < number; i++) {
      tabs.append("\t");
    }
    return tabs;
  }
}
