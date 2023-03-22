package com.jjang051.ch04.dao;

import com.jjang051.ch04.dto.BoardDto;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
  ArrayList<BoardDto> getAllBoard();

  public void insertBoard(BoardDto boardDto);

  public BoardDto getOneBoard(int no);

  public void updateBoard(BoardDto boardDto);

  public void deleteBoard(int no);

  public void updateHit(int no);
}
