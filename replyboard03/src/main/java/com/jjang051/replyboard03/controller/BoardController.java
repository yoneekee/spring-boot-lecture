package com.jjang051.replyboard03.controller;

import com.jjang051.replyboard03.dto.ReplyBoardDto;
import com.jjang051.replyboard03.service.ReplyBoardService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  //board/write
  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @GetMapping("/reply")
  public String reply() {
    return "/board/reply";
  }

  @GetMapping("/list")
  public String list(Model model) {
    List<ReplyBoardDto> boardList = replyBoardService.getAllBoardList();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/view")
  public String view(Model model, int no) {
    replyBoardService.updateHit(no);
    ReplyBoardDto replyBoardDto = replyBoardService.getSelectOne(no);

    log.info("replyBoardDto==={}", replyBoardDto);

    model.addAttribute("replyBoardDto", replyBoardDto);

    return "/board/view";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    replyBoardService.insertBoard(replyBoardDto);
    //redirectAttributes.addAttribute("msg", "글이 등록되었습니다.");
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/list";
  }

  @PostMapping("/replyProcess")
  public String replyProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    replyBoardService.insertReplyBoard(replyBoardDto);
    //redirectAttributes.addAttribute("msg", "글이 등록되었습니다.");
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/list";
  }
}
