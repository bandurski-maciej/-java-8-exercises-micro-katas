package org.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrainingTest {

  @Test
  public void toUpperCaseStream() {

    List<String> list1 = List.of("aaa", "bbb", "ccc");
    List<String> list2 = List.of("AAA", "BBB", "CCC");

    assertThat(list2).hasSameElementsAs(Training.toUpperCaseStream(list1));

  }

  @Test
  void filter4Characters() {

    List<String> list = List.of("aaa", "aaaa", "aaaaaa");
    List<String> list2 = List.of("aaaa", "aaaaaa");

    assertThat(Training.filter4Characters1(list)).hasSameElementsAs(list2);

  }

  @Test
  void flattenMultidimensionalCollection() {

    List<List<String>> listOfLists = new ArrayList<>();
    List<String> list1 = List.of("a", "b");
    List<String> list2 = List.of("c", "d");

    listOfLists.add(list1);
    listOfLists.add(list2);

    assertThat(Training.flattenMultidimensionalCollection(listOfLists)).hasSameElementsAs(List.of("a", "b", "c", "d"));


  }

}
