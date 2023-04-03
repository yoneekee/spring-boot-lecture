package com.jjang051.gallery.service;

import com.jjang051.gallery.dto.GalleryDto;
import com.jjang051.gallery.dto.ReplyDto;
import java.util.List;

public interface GalleryService {
  int insertGallery(GalleryDto galleryDto);
  List<GalleryDto> getAllList();
  GalleryDto viewGallery(int no);
  int insertReply(ReplyDto replyDto);
  int deleteReply(ReplyDto replyDto);
  List<ReplyDto> getAllReply(int galleryId);
}
