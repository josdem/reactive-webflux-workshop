package com.jos.dem.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @Id
  private String uuid;
  private String nickname;
  private String email;

}
