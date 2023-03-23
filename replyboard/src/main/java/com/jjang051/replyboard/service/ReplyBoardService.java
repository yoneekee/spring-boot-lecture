package com.jjang051.replyboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjang051.replyboard.dao.ReplyBoardDao;
import com.jjang051.replyboard.dto.ReplyBoardDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReplyBoardService {
    
    @Autowired
    ReplyBoardDao replyBoardDao;

    public ReplyBoardService() {
        log.info("= === = === = REPLY BOARD SERVICE = === = === =");
    }

    public List<ReplyBoardDto> getAllReplyBoard() {
        return replyBoardDao.getAllReplyBoard();
    };

    public ReplyBoardDto getOneReplyBoard(int no) {
        return replyBoardDao.getOneReplyBoard(no);
    }
    
    public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
        return replyBoardDao.insertReplyBoard(replyBoardDto);
    };

    public int getMaxRegroup() {
        return replyBoardDao.getMaxRegroup();
    }
    
    public int updateHit(int no) {
        return replyBoardDao.updateHit(no);
    }

    public int deleteReplyBoard(int no) {
        return replyBoardDao.deleteReplyBoard(no);
    }
   
}
