package com.jjang051.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "/layout/layout";
  }

  @GetMapping("/index")
  public String index() {
    return "/index/index";
  }
}
