package com.jjang051.replyboard.controller;

import com.jjang051.replyboard.dto.ReplyBoardDto;
import com.jjang051.replyboard.service.ReplyBoardService;
import com.jjang051.replyboard.util.ScriptWriter;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
  public void delete(int no, HttpServletResponse response) throws IOException {
    ScriptWriter.alertAndNext(
      response,
      "정말로 삭제하시겠습니까",
      "/board/list"
    );
    replyBoardService.deleteReplyBoard(no);
  }

  @GetMapping("/update")
  public String update(int no, Model model) {
    ReplyBoardDto replyBoardDto = replyBoardService.getOneReplyBoard(no);
    model.addAttribute("replyBoardDto", replyBoardDto);
    return "/board/update";
  }

  @PostMapping("/updateProcess")
  public void updateProcess(
    ReplyBoardDto replyBoardDto,
    int no,
    Model model,
    HttpServletResponse response
  ) throws IOException {
    model.addAttribute("no", no);
    ScriptWriter.alertAndNext(
      response,
      "정말로 수정하시겠습니까",
      "/board/view?no=" + no
    );
  }

  @PostMapping("/replyWriteProcess")
  public String replyProcess(ReplyBoardDto replyBoardDto, int no) {
    int maxRegroup = replyBoardService.getMaxRegroup();
    replyBoardDto.setReGroup(maxRegroup);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setAvailable(1);
    int insertReply = replyBoardService.insertReplyBoard(replyBoardDto);
    log.info("" + insertReply);
    return "redirect:/board/list";
  }

  @GetMapping("/reply")
  public String reply(int no, Model model) {
    ReplyBoardDto replyBoardDto = replyBoardService.getOneReplyBoard(no);
    model.addAttribute("replyBoardDto", replyBoardDto);
    return "/board/reply";
  }
}
