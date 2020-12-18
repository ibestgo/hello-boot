package com.bestgo.helloboot.dao;

import com.bestgo.helloboot.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") // OR @Component. Classes with @Repository or @Component will be scanned and referenced as the given name.
public class FakePersonDataAccessService implements PersonDao {
  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return DB.stream()
        .filter(person -> person.getId().equals(id))
        .findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    Optional<Person> personMaybe = selectPersonById(id);
    if(personMaybe.isEmpty()) {
      return 0;
    }
    DB.remove(personMaybe.get());
    return 1;
  }

  @Override
  public int updatePersonById(UUID id, Person newPerson) {
    return selectPersonById(id)
        .map(person -> {
          int indexOfPersonToUpdate = DB.indexOf((person));
          if(indexOfPersonToUpdate >= 0) {
            DB.set(indexOfPersonToUpdate, new Person(id, newPerson.getName()));
            return 1;
          }
          return 0;
        })
        .orElse(0);
  }
}

/*
A container object which may or may not contain a non-null value. If a value is present,
isPresent() will return true and get() will return the value.

    Optional<String> empty = Optional.empty();
    assertFalse(empty.isPresent()); // to check if there is a value. Use isPresent() and isEmpty() to check


    String name = null;
    Optional.of(name);  // NPE

    String name = null;
    Optional<String> opt = Optional.ofNullable(name);
    assertFalse(opt.isPresent());

    String name = "baeldung";
    Optional<String> opt = Optional.ofNullable(name);
    assertTrue(opt.isPresent());
 */
