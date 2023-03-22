package com.jjang051.ch04.service;

import com.jjang051.ch04.dao.BoardDao;
import com.jjang051.ch04.dto.BoardDto;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {

  @Autowired
  BoardDao boardDao;

  public BoardService() {
    log.info("=========boardService===========");
  }

  public ArrayList<BoardDto> getAllBoard() {
    ArrayList<BoardDto> boardList = boardDao.getAllBoard();
    //log.info("boardList=={}", boardList);
    return boardList;
  }

  public void insertBoard(BoardDto boardDto) {
    boardDao.insertBoard(boardDto);
  }

  public BoardDto getOneBoard(int no) {
    BoardDto boardDto = boardDao.getOneBoard(no);
    return boardDto;
  }

  public void updateBoard(BoardDto boardDto) {
    boardDao.updateBoard(boardDto);
  }

  public void deleteBoard(int no) {
    boardDao.deleteBoard(no);
  }

  public void updateHit(int no) {
    boardDao.updateHit(no);
  }
}
