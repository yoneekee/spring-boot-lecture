package com.jjang051.gallery.dao;

import com.jjang051.gallery.dto.GalleryDto;
import com.jjang051.gallery.dto.ReplyDto;
import java.util.List;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

//import org.apache.ibatis.annotations.Select;

@Mapper
public interface GalleryDao {
  int insertGallery(GalleryDto galleryDto);

  //@Select("SELECT * FROM GALLERY ORDER BY GALLERY")
  List<GalleryDto> getAllList();

  GalleryDto viewGallery(int no);

  int insertReply(ReplyDto replyDto);

  int deleteReply(ReplyDto replyDto);

  List<ReplyDto> getAllReply(int galleryId);
}
