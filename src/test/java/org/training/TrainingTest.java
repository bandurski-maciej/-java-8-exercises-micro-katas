package org.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.training.streams.Person;

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

  @Test
  void findOldestPersonInCollection() {

    Person person1 = new Person("Mark", 24);
    Person person2 = new Person("Nick", 66);
    Person person3 = new Person("Richard", 99);

    assertThat(Training.findOldestPersonInCollection(List.of(person1, person2, person3))).isSameAs(person3);

  }

  @Test
  void sumAllElements() {

    assertThat(Training.sumAllElements(List.of(1,2,3,4,5))).isEqualTo(15);

  }

  @Test
  void getNamesOfAllKidsUnderAge(){

    Person person1 = new Person("Mark", 14);
    Person person2 = new Person("Nick", 18);
    Person person3 = new Person("Richard", 25);

    assertThat(Training.getNamesOfAllKidsUnderAge(List.of(person1, person2, person3))).hasSameElementsAs(List.of(person1.getName()));

  }


}
