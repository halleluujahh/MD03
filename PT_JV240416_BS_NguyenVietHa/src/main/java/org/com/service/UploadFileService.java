package org.com.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    // Lay du lieu file trong DTO -> save vao thu muc upload tomcat
    String uploadFileToLocal(MultipartFile multipartFile);
    // Lay file tu upload local -> storage cua firebase
    String uploadFileToFireBase(String localFilePath);
}
