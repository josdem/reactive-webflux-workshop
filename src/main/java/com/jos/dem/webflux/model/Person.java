package com.jos.dem.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@Document
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class Person {

  @Id
  private Long id;
  private String nickname;
  private String email;

}
