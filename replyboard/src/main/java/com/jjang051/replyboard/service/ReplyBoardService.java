package com.jjang051.replyboard.service;

import com.jjang051.replyboard.dto.ReplyBoardDto;
import java.util.List;

public interface ReplyBoardService {
  public List<ReplyBoardDto> getAllReplyBoard();

  public int insertBoard(ReplyBoardDto replyBoardDto);

  public int insertReplyBoard(ReplyBoardDto replyBoardDto);

  //public int insertReply2Board(ReplyBoardDto replyBoardDto);

  public int getMaxReGroup();

  public ReplyBoardDto getSelectedBoard(int no);

  public int deleteReplyBoard(int no);

  public int updateHit(int no);

  public int modifyBoard(ReplyBoardDto replyBoardDto);

  public int updateRelevel(ReplyBoardDto replyBoardDto);

  public ReplyBoardDto modifyPwdCheck(ReplyBoardDto replyBoardDto);
}
