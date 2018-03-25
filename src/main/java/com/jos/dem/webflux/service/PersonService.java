package com.jos.dem.webflux;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.jos.dem.webflux.model.Person;

@Service
public class PersonService {

  public Mono<Person> getById(String id){}

  public Flux<Person> getAll(){}

}
