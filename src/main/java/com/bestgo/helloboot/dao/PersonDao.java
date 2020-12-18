package com.bestgo.helloboot.dao;

import com.bestgo.helloboot.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

  int insertPerson(UUID id, Person person);

  // The default methods have introduced as a mechanism to extend interfaces in a backward-compatible way.
  // It can be added without affecting implementing classes as it includes an implementation.
  default int insertPerson(Person person) {
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }

  List<Person> selectAllPeople();

  Optional<Person> selectPersonById(UUID id);

  int deletePersonById(UUID id);

  int updatePersonById(UUID id, Person person);


}
/*
    1) A class implementation of a method takes precedence over a default method. So, if the class already has the same method as an Interface, then the default method from the implemented Interface does not take effect.
    2) However, if two interfaces implement the same default method, then there is a conflict.
    3) In cases where one interface inherits another interface and both of them implement a default method, an implementing class would use the default method of the child interface.
    4) Also, an explicit call to an interface default method can be made from inside an implementing class using super. For example Interface.super.defaultMethod().

    Also, Java 8 introduces static methods in Interfaces.
 */
