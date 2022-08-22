package com.github.xuhaojun.gamefilter.to.e7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class E7Buff {
  public String _id;
  public String id;
  public String type;
  public String name;
  public String effect;
  public E7BuffAssets assets;
}
