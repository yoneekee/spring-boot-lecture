package com.jjang051.replyboard03.service;

import com.jjang051.replyboard03.dao.ReplyBoardDao;
import com.jjang051.replyboard03.dto.ReplyBoardDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReplyBoardServiceImpl implements ReplyBoardService {

  @Autowired
  ReplyBoardDao replyBoardDao;

  public ReplyBoardServiceImpl() {
    log.info("===========ReplyBoardService=========");
  }

  public int insertBoard(ReplyBoardDto replyBoardDto) {
    int result = replyBoardDao.insertBoard(replyBoardDto);
    return result;
  }

  public List<ReplyBoardDto> getAllBoardList() {
    List<ReplyBoardDto> boardList = replyBoardDao.getAllBoardList();
    return boardList;
  }

  @Override
  public ReplyBoardDto getSelectOne(int no) {
    ReplyBoardDto replyBoardDto = replyBoardDao.getSelectOne(no);
    return replyBoardDto;
  }

  @Override
  public int updateHit(int no) {
    int result = replyBoardDao.updateHit(no);
    return result;
  }
}
