package com.jjang051.replyboard.controller;

import com.jjang051.replyboard.dto.ReplyBoardDto;
import com.jjang051.replyboard.service.ReplyBoardService;
import com.jjang051.replyboard.util.ScriptWriter;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(ReplyBoardDto replyBoardDto) {
    int maxRegroup = replyBoardService.getMaxReGroup();
    replyBoardDto.setReGroup(maxRegroup + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);
    log.info(replyBoardDto);
    replyBoardService.insertBoard(replyBoardDto);
    return "redirect:/board/list";
  }

  @PostMapping("/replyProcess")
  public String replyWriteProcess(ReplyBoardDto replyBoardDto) {
    replyBoardService.insertReplyBoard(replyBoardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/list")
  public String list(Model model) {
    List<ReplyBoardDto> boardList = replyBoardService.getAllReplyBoard();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/reply")
  public String reply(int no) {
    return "/board/reply";
  }

  @GetMapping("/view")
  public String view(int no, Model model) {
    ReplyBoardDto boardDto = replyBoardService.getSelectedBoard(no);
    replyBoardService.updateHit(no);
    model.addAttribute("boardDto", boardDto);
    return "/board/view";
  }

  @GetMapping("/delete")
  public void delete(int no, HttpServletResponse response) throws IOException {
    ScriptWriter.alertAndNext(
      response,
      "정말로 삭제하시겠습니까",
      "/board/list"
    );
    replyBoardService.deleteReplyBoard(no);
  }

  @GetMapping("/modify")
  public String modify(int no, Model model) {
    ReplyBoardDto boardDto = replyBoardService.getSelectedBoard(no);
    model.addAttribute("boardDto", boardDto);
    return "/board/modify";
  }

  @PostMapping("/modifyProcess")
  public void modifyProcess(ReplyBoardDto replyBoardDto, HttpServletResponse response) throws IOException {
    replyBoardService.modifyBoard(replyBoardDto);
    ScriptWriter.alertAndNext(
      response,
      "정말로 수정하시겠습니까",
      "/board/view?no="+replyBoardDto.getNo()
    );
  }
}
