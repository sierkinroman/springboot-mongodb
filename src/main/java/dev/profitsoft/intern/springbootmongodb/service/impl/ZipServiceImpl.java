package dev.profitsoft.intern.springbootmongodb.service.impl;

import dev.profitsoft.intern.springbootmongodb.service.ZipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
public class ZipServiceImpl implements ZipService {

    @Override
    public Path unzip(Path pathToFile) {
        byte[] buffer = new byte[1024 * 8];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(pathToFile.toFile()))) {
            ZipEntry zipEntry = zis.getNextEntry();

            File file = new File(zipEntry.getName());
            try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file))) {
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
            }
            zis.closeEntry();

            System.out.println("File unzipped successful");
            return file.toPath();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
