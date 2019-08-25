package com.david.algorithms;

public class PeopleAlive {
  public static void main(String[] args) {
    int[][] matrix = {{1900, 2000}, {1999, 2010}, {1980, 2010}, {2000, 2015}, {1950, 2010}};
    getYear(matrix);
  }

  public static int getYear(int[][] matrix) {
    int min = matrix[0][0];
    int max = matrix[0][1];
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] < min) {
        min = matrix[i][0];
      }
      if (matrix[i][1] > max) {
        max = matrix[i][1];
      }
    }
    int targetYear = min;
    int peopleAlive = 0;
    for (int year = min; year <= max; year++) {
      int count = 0;
      for (int index = 0; index < matrix.length; index++) {
        int born = matrix[index][0];
        int death = matrix[index][1];
        if (year >= born && year < death) {
          count++;
        }
      }
      if (count >= peopleAlive) {
        peopleAlive = count;
        targetYear = year;
      }
    }
    System.out.println("targetYear = " + targetYear);
    System.out.println("peopleAlive = " + peopleAlive);
    return targetYear;
  }
}
