package com.jjang051.gallery.service;

import com.jjang051.gallery.dto.GalleryDto;
import java.util.List;

public interface GalleryService {
  int insertGallery(GalleryDto galleryDto);
  List<GalleryDto> getAllList();
}
