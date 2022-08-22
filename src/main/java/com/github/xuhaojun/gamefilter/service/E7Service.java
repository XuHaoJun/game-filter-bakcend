package com.github.xuhaojun.gamefilter.service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xuhaojun.gamefilter.to.e7.E7Buff;
import com.github.xuhaojun.gamefilter.to.e7.E7Hero;
import com.github.xuhaojun.gamefilter.to.e7.E7HeroesResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class E7Service {

  @Value("classpath:game-data/e7/e7-heroes-tw.json")
  Resource e7HeroesJsonResource;

  @Value("classpath:game-data/e7/e7-buffs-tw.json")
  Resource e7BuffsJsonResource;

  private static ObjectMapper objectMapper = defaultObjectMapper();
  private static List<E7Hero> heroes;
  private static List<E7Buff> buffs;

  @PostConstruct
  private void init() {
    loadHeroes();
    loadBuffs();
  }

  private static ObjectMapper defaultObjectMapper() {
    ObjectMapper defaultObjectMapper = new ObjectMapper();
    return defaultObjectMapper;
  }

  private List<E7Hero> readHeroes() {
    try {
      return Arrays.asList(
          objectMapper.readValue(e7HeroesJsonResource.getInputStream(), E7Hero[].class));
    } catch (StreamReadException e) {
      e.printStackTrace();
    } catch (DatabindException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void loadHeroes() {
    heroes = readHeroes();
  }

  private List<E7Buff> readBuffs() {
    try {
      return Arrays.asList(
          objectMapper.readValue(e7BuffsJsonResource.getInputStream(), E7Buff[].class));
    } catch (StreamReadException e) {
      e.printStackTrace();
    } catch (DatabindException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void loadBuffs() {
    buffs = readBuffs();
  }

  public E7HeroesResponse getHeroesResponse() {
    return E7HeroesResponse.builder().heroes(heroes).total(heroes.size()).buffs(buffs).build();
  }
}
