package com.jjang051.replyboard.dao;

import com.jjang051.replyboard.dto.ReplyBoardDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyBoardDao {
  List<ReplyBoardDto> getAllReplyBoard();
  int insertBoard(ReplyBoardDto replyBoardDto);
  int getMaxReGroup();
  ReplyBoardDto getSelectedBoard(int no);
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  int deleteReplyBoard(int no);
  int updateHit(int no);
  int modifyBoard(ReplyBoardDto replyBoardDto);
}
