package com.bestgo.helloboot.service;

import com.bestgo.helloboot.dao.PersonDao;
import com.bestgo.helloboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

  private final PersonDao personDao;

  @Autowired  // means an implementation of PersonDao interface will be auto injected. so which impl? Use @Qualifier
  public PersonService(@Qualifier("postgres") PersonDao personDao) {
  //public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public int deletePerson(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePerson(UUID id, Person newPerson) {
    return personDao.updatePersonById(id, newPerson);
  }
}
