package com.jjang051.replyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyBoardDto {

  private int no;
  private int realNo;
  private String subject;
  private String name;
  private String password;
  private String regDate;
  private String contents;
  private int available;
  private int reGroup;
  private int reLevel;
  private int reStep;
  private int hit;
}
