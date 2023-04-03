package com.jjang051.gallery.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class GalleryDto {

  int no;
  private String title;
  private String contents;
  private MultipartFile file; // insert.html에 file의 name
  private String original;
  private String renamed;
}
