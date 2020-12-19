package com.bestgo.helloboot.controllers.api;

import com.bestgo.helloboot.model.Person;
import com.bestgo.helloboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

  private final PersonService personService;

  @Autowired  // as PersonService is not an interface and there is only one, @Qualifier is not needed
  public PersonController(PersonService personService) {
    this.personService = personService;
  }


  // tells it is a POST handler. @RequestBody tells to instantiate a pojo from the body then pass it to this method
  @PostMapping
  public void addPerson(@Valid @NonNull @RequestBody Person person) {
    personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }

  @GetMapping(path = "{id}")
  public Person PersonById(@PathVariable("id") UUID id) {
    return personService.getPersonById(id)
        .orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public void deletePersonById(@PathVariable("id") UUID id) {
    personService.deletePerson(id);
  }

  @PutMapping(path = "{id}")
  public void updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
    personService.updatePerson(id, personToUpdate);
  }
}
