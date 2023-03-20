package com.jjang051.ch01.Controller;

import com.jjang051.ch01.Dto.Member;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    // 데이터를 Model 객체에 실어 보낸다 // jsp의 request.setAttribute
    model.addAttribute("name", "홍길동");
    return "/index/index";
  }

  @GetMapping("/mv")
  public ModelAndView home02() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("subject", "제목을 실어서 보냅니다.");
    mav.setViewName("/index/index02");
    return mav;
  }

  @GetMapping("/member/list")
  public String list(Model model) {
    ArrayList<Member> memberList = new ArrayList<>();

    memberList.add(new Member("admin01", "운영자", "서울특별시 은평구"));
    memberList.add(new Member("alba01", "알바생", "서울특별시 중구"));
    memberList.add(new Member("customer01", "고객님", "서울특별시 송파구"));

    model.addAttribute("memberList", memberList);
    return "/member/list";
  }
}
