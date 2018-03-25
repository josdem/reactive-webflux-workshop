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

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

  @Bean
  CommandLineRunner start(PersonRepository personRepository){
    return args -> {
      Stream.of("josdem", "tgrip", "edzero", "skuarch", "siedrix")
      .map(nickname -> new Person(UUID.randomUUID().toString(), nickname, nickname + "@email.com"))
      .map(personRepository::save);

      Flux<Person> persons = personRepository.findAll();
      persons.collectList().block().forEach(System.out::println);
    };
  }

}
