package com.jos.dem.webflux.controller;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.webflux.model.Person;
import com.jos.dem.webflux.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PersonController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private PersonRepository personRepository;

  @GetMapping("/persons")
  public Flux<Person> findAll(){
    log.info("Calling find persons");
    return personRepository.findAll();
  }

  @GetMapping("/persons/{id}")
  public Mono<Person> findById(@PathVariable String id){
    log.info("Calling find person by id: " + id);
    return personRepository.findById(id);
  }

}
