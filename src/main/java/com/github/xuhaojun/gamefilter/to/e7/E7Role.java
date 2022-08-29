package com.github.xuhaojun.gamefilter.to.e7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class E7Role {
  private String id;
  private String name;
  private E7Assets assets;
}
