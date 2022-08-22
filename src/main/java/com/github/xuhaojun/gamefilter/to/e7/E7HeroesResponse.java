package com.github.xuhaojun.gamefilter.to.e7;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class E7HeroesResponse {
  private Integer total;
  private List<E7Hero> heroes;
  private List<E7Buff> buffs;
}
