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
    replyBoardDto.setReGroup(getMaxReGroup() + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);

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

  @Override
  public int getMaxReGroup() {
    int result = replyBoardDao.getMaxReGroup();
    return result;
  }

  @Override
  public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
    int reGroup = replyBoardDto.getReGroup();
    int reLevel = replyBoardDto.getReLevel();
    int reStep = replyBoardDto.getReStep();

    updateReLevel(replyBoardDto);

    replyBoardDto.setReGroup(reGroup);
    replyBoardDto.setReLevel(reLevel + 1);
    replyBoardDto.setReStep(reStep + 1);

    int result = replyBoardDao.insertReplyBoard(replyBoardDto);

    // db에가서 나보다 레벨이 높은 애들은 전부 1증가

    return result;
  }

  public int updateReLevel(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateReLevel(replyBoardDto);
  }
}
