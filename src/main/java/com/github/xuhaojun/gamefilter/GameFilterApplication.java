package com.github.xuhaojun.gamefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class GameFilterApplication {

  public static void main(String[] args) {
    SpringApplication.run(GameFilterApplication.class, args);
  }

  @GetMapping("/games/e7/heroes")
  public String getHeroes(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s! 8", name);
  }

  @GetMapping("/games/e7/buffs")
  public String getBuffs(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s! 9", name);
  }
}
