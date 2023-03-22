package com.jjang051.ch04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

  private int no;
  private String userName;
  private String subject;
  private String contents;
  private String regDate;
  private int hit;
}
