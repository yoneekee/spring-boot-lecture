package com.jjang051.replyboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjang051.replyboard.dto.ReplyBoardDto;
import com.jjang051.replyboard.service.ReplyBoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  @GetMapping("/view")
  public String view(int no, Model model) {
    ReplyBoardDto replyBoardDto = replyBoardService.getOneReplyBoard(no);
    replyBoardService.updateHit(no);
    model.addAttribute("replyBoardDto", replyBoardDto);
    return "board/view";
  }
  @GetMapping("/list")
  public String list(Model model) {
    List<ReplyBoardDto> replyBoardList = replyBoardService.getAllReplyBoard();
    model.addAttribute("replyBoardList", replyBoardList);
    return "board/list";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(ReplyBoardDto replyBoardDto) {
    int maxRegroup = replyBoardService.getMaxRegroup();
    replyBoardDto.setReGroup(maxRegroup);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setAvailable(1);
    int insertReply = replyBoardService.insertReplyBoard(replyBoardDto);
    log.info("" + insertReply);
    return "redirect:/board/list";
  }

  @GetMapping("/delete")
  public String delete(int no) {
    replyBoardService.deleteReplyBoard(no);
    return "/board/list";
  }

  @GetMapping("/update")
  public String update(int no, Model model) {
    ReplyBoardDto replyBoardDto = replyBoardService.getOneReplyBoard(no);
    model.addAttribute("replyBoardDto", replyBoardDto);
    return("/board/update");
  }
}
