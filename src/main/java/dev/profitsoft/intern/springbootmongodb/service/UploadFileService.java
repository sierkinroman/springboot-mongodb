package dev.profitsoft.intern.springbootmongodb.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface UploadFileService {

    Path uploadFile(MultipartFile file);

}
