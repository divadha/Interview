package com.david.algorithms;

public class EvaluateExpression {

  public static void main(String[] args) {
    String[] array = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    //    String[] array = {"2", "1", "+", "3", "*"};
    //    String[] array = {"4", "13", "5", "/", "+"};
    //    String[] array = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(evalRPN(array));
  }

  public static int evalRPN(String[] tokens) {
    int index = 0;
    while (index < tokens.length) {
      String current = tokens[index];
      if (current.equals("/")
          || current.equals("*")
          || current.equals("+")
          || current.equals("-")) {
        int number2 = getNumber(tokens, index - 1);
        int number1 = getNumber(tokens, index - 2);
        int result = evaluate(number1, number2, current);
        //        System.out.print("=" + result);
        tokens[index] = String.valueOf(result);
      }
      index++;
    }
    return Integer.valueOf(tokens[index - 1]);
  }

  public static int getNumber(String[] tokens, int index) {
    String number = "";
    while (number.isEmpty()) {
      number = tokens[index];
      index--;
    }
    tokens[index + 1] = "";
    return Integer.parseInt(number);
  }

  public static int evaluate(int number1, int number2, String op) {
    //    System.out.println();
    //    System.out.print(number1 + op + number2);
    if (op.equals("+")) {
      return number1 + number2;
    }
    if (op.equals("-")) {
      return number1 - number2;
    }
    if (op.equals("/")) {
      return number1 / number2;
    }
    if (op.equals("*")) {
      return number1 * number2;
    }
    return 0;
  }
}
