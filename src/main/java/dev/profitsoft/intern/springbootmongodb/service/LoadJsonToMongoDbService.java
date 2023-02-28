package dev.profitsoft.intern.springbootmongodb.service;

import java.nio.file.Path;

public interface LoadJsonToMongoDbService {

    long parseAndSave(Path pathToFile);

}
