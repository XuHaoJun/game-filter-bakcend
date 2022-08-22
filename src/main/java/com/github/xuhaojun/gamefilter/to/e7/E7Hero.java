package com.github.xuhaojun.gamefilter.to.e7;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class E7Hero {
  public String _id;
  public String id;
  public String name;
  public boolean moonlight;
  public int rarity;
  public String attribute;
  public String role;
  public String zodiac;
  public E7SelfDevotion self_devotion;
  public E7Devotion devotion;
  public E7Assets assets;
  public List<String> buffs;
  public List<String> debuffs;
  public List<String> common;
}
