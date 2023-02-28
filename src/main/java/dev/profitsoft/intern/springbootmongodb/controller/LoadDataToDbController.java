package dev.profitsoft.intern.springbootmongodb.controller;

import dev.profitsoft.intern.springbootmongodb.service.LoadJsonToMongoDbService;
import dev.profitsoft.intern.springbootmongodb.service.UploadFileService;
import dev.profitsoft.intern.springbootmongodb.service.ZipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class LoadDataToDbController {

    private final UploadFileService uploadFileService;

    private final ZipService zipService;

    private final LoadJsonToMongoDbService loadJsonToMongoDbService;

    @PostMapping
    public ResponseEntity<String> loadDataToMongoDb(@RequestParam("file") MultipartFile file) {
        Path uploadedZipPath = uploadFileService.uploadFile(file);
        Path unzippedPath = zipService.unzip(uploadedZipPath);
        long savedObjects = loadJsonToMongoDbService.parseAndSave(unzippedPath);

        return ResponseEntity.ok("Saved " + savedObjects + " object(s).");
    }

}
