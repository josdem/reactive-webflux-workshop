package com.jos.dem.webflux;

import com.jos.dem.webflux.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@SpringBootApplication
public class PersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }

    @Bean
    WebClient webClient() {
        return WebClient.create("http://localhost:8080");
    }

    @Bean
    CommandLineRunner run(WebClient client) {
        return args -> {
            client.get().uri("/persons").retrieve()
                    .bodyToFlux(Person.class)
                    .subscribe(person -> log.info("person: {}", person));
        };
    }

}
