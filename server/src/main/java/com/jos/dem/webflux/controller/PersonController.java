package com.jos.dem.webflux.controller;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.webflux.model.Person;
import com.jos.dem.webflux.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public Flux<Person> findAll() {
        log.info("Calling find persons");
        return personRepository.findAll();
    }

    @GetMapping("/persons/{nickname}")
    public Mono<Person> findById(@PathVariable String nickname) {
        log.info("Calling find person by id: {}", nickname);
        return personRepository.findById(nickname);
    }

}
