package com.david.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PeopleAlive {
  public static void main(String[] args) {
    int[][] matrix = {{1900, 2000}, {1999, 2010}, {1980, 2010}, {2000, 2015}, {1950, 2010}};
    getYear(matrix);
    getYear2(matrix);

    List<Person> people = new ArrayList<>();
    Person p1 = new Person(1900, 2000);
    Person p2 = new Person(1999, 2010);
    Person p3 = new Person(1980, 2010);
    Person p4 = new Person(2000, 2015);
    Person p5 = new Person(1950, 2010);
    Collections.addAll(people, p1, p2, p3, p4, p5);
    System.out.println(findYears(people));
  }

  private static class Person {
    public Person(int birthYear, int deathYear) {
      this.birthYear = birthYear;
      this.deathYear = deathYear;
    }

    int birthYear;
    int deathYear;
  }

  public static int findYears(List<Person> people) {
    Map<Integer, Integer> years = new TreeMap<>();

    for (Person person : people) {
      if (!years.containsKey(person.birthYear)) {
        years.put(person.birthYear, 0);
      }
      years.put(person.birthYear, years.get(person.birthYear) + 1);

      if (!years.containsKey(person.deathYear + 1)) {
        years.put(person.deathYear + 1, 0);
      }
      years.put(person.deathYear + 1, years.get(person.deathYear + 1) - 1);
    }
    // maximum sub array
    int maxYear = 0, max = Integer.MIN_VALUE, current = 0;

    for (Map.Entry<Integer, Integer> entry : years.entrySet()) {
      int year = entry.getKey();
      int delta = entry.getValue();
      current += delta;
      if (current > max) {
        maxYear = year;
        max = current;
      }
    }

    return maxYear;
  }

  public static int getYear2(int[][] matrix) {
    Set<Integer> set = new HashSet<>();
    for (int[] years : matrix) {
      set.add(years[0]);
    }
    int max = 0;
    for (int year : set) {
      int count = 0;
      for (int[] years : matrix) {
        if (year >= years[0] && year < years[1]) {
          count++;
        }
      }
      max = Math.max(max, count);
    }
    System.out.println("max = " + max);
    return max;
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
      if (count > peopleAlive) {
        peopleAlive = count;
        targetYear = year;
      }
    }
    System.out.println("targetYear = " + targetYear);
    System.out.println("peopleAlive = " + peopleAlive);
    return targetYear;
  }
}

// {1900, 2000}, {1999, 2010}, {1980, 2010}, {2000, 2015}, {1950, 2010
// 1900,                 2000
//      1950,                 2010
//           1980,            2010
//                1999,       2010
//                      2000,       2015
