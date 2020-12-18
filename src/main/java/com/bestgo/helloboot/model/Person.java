package com.bestgo.helloboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

// This is basically a POJO model that represents a POST body for this person resource.
public class Person {
  private final UUID id;

  @NotBlank
  private final String name;

  // When a POST request comes in with a json body that has "id" and "name" attributes, it has to be converted to this POJO.
  // @JsonProperty tells the spring to use the same attributes when it construct this pojo class.
  public Person(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
