package com.github.xuhaojun.gamefilter.service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xuhaojun.gamefilter.to.e7.E7Buff;
import com.github.xuhaojun.gamefilter.to.e7.E7Element;
import com.github.xuhaojun.gamefilter.to.e7.E7Hero;
import com.github.xuhaojun.gamefilter.to.e7.E7HeroesResponse;
import com.github.xuhaojun.gamefilter.to.e7.E7Rarity;
import com.github.xuhaojun.gamefilter.to.e7.E7Role;
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

  @Value("classpath:game-data/e7/e7-roles.json")
  Resource e7RolesJsonResource;

  @Value("classpath:game-data/e7/e7-elements.json")
  Resource e7ElementsJsonResource;

  @Value("classpath:game-data/e7/e7-rarities.json")
  Resource e7RaritiesJsonResource;

  private static ObjectMapper objectMapper = defaultObjectMapper();
  private static List<E7Hero> heroes;
  private static List<E7Buff> buffs;
  private static List<E7Role> roles;
  private static List<E7Element> elements;
  private static List<E7Rarity> rarities;

  @PostConstruct
  private void init() {
    loadHeroes();
    loadBuffs();
    loadRoles();
    loadElements();
    loadRarities();
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

  private List<E7Role> readRoles() {
    try {
      return Arrays.asList(
          objectMapper.readValue(e7RolesJsonResource.getInputStream(), E7Role[].class));
    } catch (StreamReadException e) {
      e.printStackTrace();
    } catch (DatabindException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void loadRoles() {
    roles = readRoles();
  }

  private List<E7Element> readElements() {
    try {
      return Arrays.asList(
          objectMapper.readValue(e7ElementsJsonResource.getInputStream(), E7Element[].class));
    } catch (StreamReadException e) {
      e.printStackTrace();
    } catch (DatabindException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void loadElements() {
    elements = readElements();
  }

  private List<E7Rarity> readRarities() {
    try {
      return Arrays.asList(
          objectMapper.readValue(e7RaritiesJsonResource.getInputStream(), E7Rarity[].class));
    } catch (StreamReadException e) {
      e.printStackTrace();
    } catch (DatabindException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void loadRarities() {
    rarities = readRarities();
  }

  public E7HeroesResponse getHeroesResponse() {
    return E7HeroesResponse.builder()
        .heroes(heroes)
        .total(heroes.size())
        .buffs(buffs)
        .roles(roles)
        .elements(elements)
        .rarities(rarities)
        .build();
  }
}
