package com.jjang051.replyboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jjang051.replyboard.dto.ReplyBoardDto;

 
@Mapper     // 마이바티스 xml과 매핑시킴 
            // (그 xml 파일에서는 내가 이 dao에 함수를 적을 것이라 경로를 명시해 놓음)
public interface ReplyBoardDao {

    List<ReplyBoardDto> getAllReplyBoard();
    int insertReplyBoard(ReplyBoardDto replyBoardDto);
    int getMaxRegroup();
    int updateHit(int no);
    ReplyBoardDto getOneReplyBoard(int no);
    int deleteReplyBoard(int no);
}