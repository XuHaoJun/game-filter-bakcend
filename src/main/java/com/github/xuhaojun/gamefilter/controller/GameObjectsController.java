package com.github.xuhaojun.gamefilter.controller;

import com.github.xuhaojun.gamefilter.service.E7Service;
import com.github.xuhaojun.gamefilter.to.e7.E7HeroesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/games", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameObjectsController {
  private final E7Service e7service;

  @GetMapping("/e7/heroes")
  public E7HeroesResponse getE7Heroes() {
    return e7service.getHeroesResponse();
  }
}
