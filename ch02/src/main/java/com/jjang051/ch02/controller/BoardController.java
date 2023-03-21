package com.jjang051.ch02.controller;

import com.jjang051.ch02.utils.ScriptWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.lang.ProcessBuilder.Redirect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @GetMapping("/write")
  public String write() {
    log.info(null);
    return "/board/write";
  }

  @GetMapping("/writeProcess")
  public void writeProcess(
    String userId,
    String userPw,
    HttpServletResponse response,
    HttpServletRequest request
  ) throws IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    log.info("userId=={}, userPw=={}", userId, userPw);
    if (userId.equals("hong") && userPw.equals("1234")) {
      ScriptWriter.alertAndNext(response, "로그인 하셨습니다.", "/");
    } else {
      ScriptWriter.alertAndBack(response, "서버 예외 발생");
    }
  }

  @GetMapping("/view")
  public String view() {
    log.info(null);
    return "/board/view";
  }
}
