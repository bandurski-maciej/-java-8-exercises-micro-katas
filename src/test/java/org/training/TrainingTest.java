package org.training;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.training.streams.Person;

import java.util.*;

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

  @Test
  void getStatistics() {
    Person person1 = new Person("Mark", 10);
    Person person2 = new Person("Nick", 20);
    Person person3 = new Person("Richard", 30);

    List<Person> personList = List.of(person1, person2, person3);

    IntSummaryStatistics intSummaryStatistics= new IntSummaryStatistics();

    intSummaryStatistics.accept(10);
    intSummaryStatistics.accept(20);
    intSummaryStatistics.accept(30);

    assertThat(intSummaryStatistics).isEqualToComparingFieldByField(Training.getStatistics(personList));

  }

  @Test
  void partitioning() {
    Person person1 = new Person("Mark", 10);
    Person person2 = new Person("Nick", 20);
    Person person3 = new Person("Richard", 30);

    List<Person> personList = List.of(person1, person2, person3);

    Map<Boolean, List<Person>> map = new HashMap<>();
    map.put(true, List.of(person2, person3));
    map.put(false, List.of(person1));


    assertThat(Training.partitionAdults(personList)).containsAllEntriesOf(map);
  }

  @Test
  void groupingPerson() {
    Person person1 = new Person("Mark", 10, "Poland");
    Person person2 = new Person("Nick", 20, "Poland");
    Person person3 = new Person("Richard", 30,"Norway");

    List<Person> personList = List.of(person1, person2, person3);

    Map<String, List<Person>> map = new HashMap<>();
    map.put("Poland", List.of(person1, person2));
    map.put("Norway", List.of(person3));

    assertThat(map).containsAllEntriesOf(Training.groupingPerson(personList));
  }

  @Test
  void joiningPerson() {
    Person person1 = new Person("Mark", 10, "Poland");
    Person person2 = new Person("Nick", 20, "Poland");
    Person person3 = new Person("Richard", 30,"Norway");

    List<Person> personList = List.of(person1, person2, person3);
    String names = "Mark, Nick, Richard";

    assertThat(Training.joiningPerson(personList)).containsIgnoringCase(names);
  }

}
