package com.jjang051.ch02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class HomeController {

  @GetMapping("/")
  public String home(
    Model model
    // @RequestParam(name = "userName") String userName,
    // @RequestParam(name = "age") int age
  ) {
    // model.addAttribute("msg", "Sending Message ~ ~");
    //log.info("userName : " + userName); //System.out.println("userName = " + userName);
    //log.info("age : " + age);
    //log.info("{}, {}", userName, age);
    log.info(null);
    return "index/index";
  }
}
