package com.jos.dem.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.jos.dem.webflux.model.Person;

@SpringBootApplication
public class PersonApplication {

  public static void main(String[] args) {
    SpringApplication.run(PersonApplication.class, args);
  }

  @Bean
  WebClient webClient() {
    return WebClient.create("http://localhost:8080/persons");
  }

  @Bean
  CommandLineRunner run(WebClient client){
    return args -> {
      client.get().uri("").retrieve()
        .bodyToFlux(Person.class)
        .subscribe(System.out::println);
    };
  }

}
