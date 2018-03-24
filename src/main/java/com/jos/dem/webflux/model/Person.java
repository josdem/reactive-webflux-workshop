package com.jos.dem.webflux;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstuctor;
import lombok.ToString;
import lombok.Data;

@Document
@AllArgsContructor
@ToString
@NoArgsConstuctor
@Data
public class Person {

  @Id
  private Long id;
  private String nickname;
  private String email;

}
