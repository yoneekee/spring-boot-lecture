package com.jjang051.gallery.service;

import com.jjang051.gallery.dao.GalleryDao;
import com.jjang051.gallery.dto.GalleryDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl implements GalleryService {

  @Autowired
  GalleryDao galleryDao;

  @Value("${file.path}")
  private String uploadFoler;

  @Override
  public int insertGallery(GalleryDto galleryDto) {
    UUID uuid = UUID.randomUUID();
    // form에서 전달된 파일이름
    String originalFile = galleryDto.getFile().getOriginalFilename();
    // 중복방지용 이름
    String renamedFile = uuid + "_" + originalFile;

    Path imgFilePath = Paths.get(uploadFoler + renamedFile);

    galleryDto.setOriginal(originalFile);
    galleryDto.setRenamed(renamedFile);

    try {
      Files.write(imgFilePath, galleryDto.getFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    int result = galleryDao.insertGallery(galleryDto);
    return result;
  }

  @Override
  public List<GalleryDto> getAllList() {
    List<GalleryDto> galleryList = galleryDao.getAllList();
    return galleryList;
  }
}
