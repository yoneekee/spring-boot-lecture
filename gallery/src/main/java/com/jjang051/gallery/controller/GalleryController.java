package com.jjang051.gallery.controller;

import com.jjang051.gallery.dto.GalleryDto;
import com.jjang051.gallery.dto.ReplyDto;
import com.jjang051.gallery.service.GalleryService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class GalleryController {

  @Autowired
  GalleryService galleryService;

  @GetMapping({ "/", "/list" })
  public String list(Model model) {
    List<GalleryDto> galleryList = galleryService.getAllList();
    log.info(galleryList);
    model.addAttribute("galleryList", galleryList);
    return "/gallery/list";
  }

  @GetMapping("/insert")
  public String insert() {
    return "/gallery/insert";
  }

  @PostMapping("/insert")
  public String insertProcess(GalleryDto galleryDto) {
    galleryService.insertGallery(galleryDto);
    return "redirect:/";
  }

  @GetMapping("/view/{no}")
  public String view(@PathVariable("no") int no, Model model) {
    GalleryDto galleryDto = galleryService.viewGallery(no);
    model.addAttribute("galleryDto", galleryDto);
    return "/gallery/view";
  }

  @PostMapping("/getReply/{no}")
  @ResponseBody
  public List<ReplyDto> getReply(@PathVariable("no") int no) {
    List<ReplyDto> replyList = galleryService.getAllReply(no);
    return replyList;
  }

  @PostMapping("/insertReply")
  @ResponseBody
  public List<ReplyDto> insertReply(ReplyDto replyDto) {
    int result = galleryService.insertReply(replyDto);
    List<ReplyDto> replyList = galleryService.getAllReply(
      replyDto.getGalleryId()
    );
    if (result > 0) {
      return replyList;
    } else {
      return replyList;
    }
  }

  @PostMapping("/deleteReply")
  @ResponseBody
  public List<ReplyDto> deleteReply(ReplyDto replyDto) {
    int result = galleryService.deleteReply(replyDto);
    List<ReplyDto> replyList = galleryService.getAllReply(
      replyDto.getGalleryId()
    );
    if (result > 0) {
      return replyList;
    } else {
      return replyList;
    }
  }
}
