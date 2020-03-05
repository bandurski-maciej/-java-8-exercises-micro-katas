package org.training;

import org.training.streams.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Training {

  public static List<String> toUpperCaseStream(List<String> list) {

    return list.stream()
      .map(String::toUpperCase)
      .collect(Collectors.toList());

  }

  public static List<String> filter4Characters1(List<String> list) {

    return list.stream()
      .filter(word -> word.length() >= 4)
      .collect(Collectors.toList());

  }


  public static List<String> flattenMultidimensionalCollection(List<List<String>> listOfLists) {
    return listOfLists.stream()
      .flatMap(Collection::stream)
      .collect(Collectors.toList());
  }

  public static Person findOldestPersonInCollection(List<Person> personList) {
    return personList.stream()
      .max(Comparator.comparing(Person::getAge))
      .get();

  }

  public static int sumAllElements(List<Integer> integerList) {
    return integerList.stream()
      .reduce(0, Integer::sum);
  }

  public static List<String> getNamesOfAllKidsUnderAge(List<Person> personList) {
    return personList.stream()
      .filter(kid -> kid.getAge() < 18)
      .map(Person::getName)
      .collect(Collectors.toList());
  }
}
