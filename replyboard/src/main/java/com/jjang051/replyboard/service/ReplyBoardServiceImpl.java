package com.jjang051.replyboard.service;

import com.jjang051.replyboard.dao.ReplyBoardDao;
import com.jjang051.replyboard.dto.ReplyBoardDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReplyBoardServiceImpl implements ReplyBoardService {

  @Autowired
  ReplyBoardDao replyBoardDao;

  public ReplyBoardServiceImpl() {
    log.info("===============ReplyBoardService===========");
  }

  public List<ReplyBoardDto> getAllReplyBoard() {
    return replyBoardDao.getAllReplyBoard();
  }

  public int insertBoard(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.insertBoard(replyBoardDto);
  }

  public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.insertReplyBoard(replyBoardDto);
  }

  public int getMaxReGroup() {
    return replyBoardDao.getMaxReGroup();
  }

  public ReplyBoardDto getSelectedBoard(int no) {
    return replyBoardDao.getSelectedBoard(no);
  }

  public int deleteReplyBoard(int no) {
    return replyBoardDao.deleteReplyBoard(no);
  }

  public int updateHit(int no) {
    return replyBoardDao.updateHit(no);
  }

  public int modifyBoard(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.modifyBoard(replyBoardDto);
  }

  public int updateRelevel(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateRelevel(replyBoardDto);
  }

  public ReplyBoardDto modifyPwdCheck(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.modifyPwdCheck(replyBoardDto);
  }
}
