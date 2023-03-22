package com.jjang051.ch04.controller;

import com.jjang051.ch04.dto.BoardDto;
import com.jjang051.ch04.service.BoardService;
import java.io.IOException;
import java.util.ArrayList;
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
  BoardService boardService;

  @GetMapping("/list")
  public String list(Model model) {
    //BoardService boardService = new BoardService();
    ArrayList<BoardDto> boardList = boardService.getAllBoard();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(BoardDto boardDto) {
    //log.info("boardDto=={}", boardDto);
    boardService.insertBoard(boardDto);
    return "redirect:/";
  }

  @GetMapping("/view")
  public String view(Model model, int no) throws IOException {
    log.info("no : {}", no);
    BoardDto boardDto = boardService.getOneBoard(no);
    boardService.updateHit(no);
    model.addAttribute("boardDto", boardDto);
    return "board/view";
  }

  @GetMapping("/update")
  public String update(Model model, int no) {
    log.info("no : {}", no);
    BoardDto boardDto = boardService.getOneBoard(no);
    model.addAttribute("boardDto", boardDto);
    return "board/update";
  }

  @PostMapping("/updateProcess")
  public String updateProcess(BoardDto boardDto, int no) {
    log.info("updateProcess no : {}", no);
    boardService.updateBoard(boardDto);
    return "redirect:/board/view?no=" + no;
  }

  @GetMapping("/delete")
  public String delete(Model model, int no) {
    log.info("no : {}", no);
    boardService.deleteBoard(no);
    return "redirect:/board/list";
  }
}
