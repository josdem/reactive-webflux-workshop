package com.jos.dem.webflux.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import com.jos.dem.webflux.model.Person;
import com.jos.dem.webflux.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class WebConfig {

  @Autowired
  private PersonRepository personRepository;

  @Bean
  public RouterFunction<ServerResponse> routes(){
    return RouterFunctions
      .route(GET("/persons"),
      request -> ServerResponse.ok().body(personRepository.findAll(), Person.class))
      .andRoute(GET("/persons/{id}"), 
      request -> ServerResponse.ok().body(personRepository.findById(request.pathVariable("id")), Person.class));
  }

}