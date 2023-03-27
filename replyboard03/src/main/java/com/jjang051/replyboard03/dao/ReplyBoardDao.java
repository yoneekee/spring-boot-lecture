package com.jjang051.replyboard03.dao;

import com.jjang051.replyboard03.dto.ReplyBoardDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyBoardDao {
  int insertBoard(ReplyBoardDto replyBoardDto);
  List<ReplyBoardDto> getAllBoardList();
  ReplyBoardDto getSelectOne(int no);
  int updateHit(int no);
  int getMaxReGroup();
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  int updateReLevel(ReplyBoardDto replyBoardDto);
}
