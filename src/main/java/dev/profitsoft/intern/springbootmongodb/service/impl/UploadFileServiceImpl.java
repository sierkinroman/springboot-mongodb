package dev.profitsoft.intern.springbootmongodb.service.impl;

import dev.profitsoft.intern.springbootmongodb.service.UploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Override
    public Path uploadFile(MultipartFile file) {
        Path pathToFile = Paths.get(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Files.copy(
                    file.getInputStream(),
                    pathToFile,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("File upload successful");
            return pathToFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
