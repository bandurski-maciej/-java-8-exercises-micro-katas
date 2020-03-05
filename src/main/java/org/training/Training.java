package org.training;

import java.util.Collection;
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

}
