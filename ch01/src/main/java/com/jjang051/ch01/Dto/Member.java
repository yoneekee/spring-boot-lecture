package com.jjang051.ch01.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // @Getter + @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  private String id;
  private String name;
  private String addr;
}
