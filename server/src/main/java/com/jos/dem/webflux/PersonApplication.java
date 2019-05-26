package com.jos.dem.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.stream.Stream;

import com.jos.dem.webflux.model.Person;
import com.jos.dem.webflux.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PersonApplication {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(PersonApplication.class, args);
  }

  @Bean
  CommandLineRunner start(PersonRepository personRepository){
    return args -> {
      personRepository.deleteAll().subscribe();

      Flux.just(
          new Person(UUID.randomUUID(), "josdem", "joseluis.delacruz@gmail.com"),
          new Person(UUID.randomUUID(), "tgrip", "tgrip@email.com"),
          new Person(UUID.randomUUID(), "edzero", "edzero@email.com"))
        .flatMap(person -> personRepository.save(person))
        .subscribe();

      personRepository.findAll().log().subscribe(person -> log.info("person {}", person));
    };
  }

}
