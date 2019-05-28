package com.jos.dem.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.util.AlternativeJdkIdGenerator;

import com.jos.dem.webflux.model.Person;
import com.jos.dem.webflux.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PersonApplication {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  private AlternativeJdkIdGenerator idGenerator = new AlternativeJdkIdGenerator();

  public static void main(String[] args) {
    SpringApplication.run(PersonApplication.class, args);
  }

  @Bean
  CommandLineRunner start(PersonRepository personRepository){
    return args -> {

      Flux.just(
          new Person(idGenerator.generateId(), "josdem", "joseluis.delacruz@gmail.com"),
          new Person(idGenerator.generateId(), "tgrip", "tgrip@email.com"),
          new Person(idGenerator.generateId(), "edzero", "edzero@email.com"),
          new Person(idGenerator.generateId(), "siedrix", "siedrix@email.com"),
          new Person(idGenerator.generateId(), "mkheck", "mkheck@email.com"))
        .flatMap(personRepository::save)
        .subscribe(person -> log.info("person: {}", person));

      personRepository.deleteAll().subscribe();

    };
  }

}
