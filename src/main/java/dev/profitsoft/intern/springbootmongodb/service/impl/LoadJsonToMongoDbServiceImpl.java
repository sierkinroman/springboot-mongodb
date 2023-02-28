package dev.profitsoft.intern.springbootmongodb.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.profitsoft.intern.springbootmongodb.model.Pep;
import dev.profitsoft.intern.springbootmongodb.repository.PepRepository;
import dev.profitsoft.intern.springbootmongodb.service.LoadJsonToMongoDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadJsonToMongoDbServiceImpl implements LoadJsonToMongoDbService {

    private final PepRepository pepRepository;

    @Override
    public long parseAndSave(Path pathToFile) {
        pepRepository.deleteAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        long savedObjects = 0;

        try (JsonParser jsonParser = objectMapper.getFactory().createParser(pathToFile.toFile())) {
            checkStartFile(jsonParser);

            List<Pep> peps = new ArrayList<>();
            int batchSize = 5000;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                if (peps.size() > batchSize) {
                    savedObjects = saveBatch(peps, savedObjects);
                    peps.clear();
                }
                Pep pep = objectMapper.readValue(jsonParser, Pep.class);
                peps.add(pep);
            }
            if (!peps.isEmpty()) {
                savedObjects = saveBatch(peps, savedObjects);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return savedObjects;
    }

    private void checkStartFile(JsonParser jsonParser) throws IOException {
        if (jsonParser.nextToken() != JsonToken.START_ARRAY) {
            throw new IllegalStateException("File should start from start array symbol '['");
        }
    }

    private long saveBatch(List<Pep> peps, long savedObjects) {
        pepRepository.saveAll(peps);
        savedObjects += peps.size();
        System.out.println("Saved " + savedObjects + " pep(s).");

        return savedObjects;
    }

}
