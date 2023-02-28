package dev.profitsoft.intern.springbootmongodb.repository;

import dev.profitsoft.intern.springbootmongodb.dto.NameCountDto;
import dev.profitsoft.intern.springbootmongodb.model.Pep;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PepRepository extends MongoRepository<Pep, String>, PepRepositoryCustom {

    @Aggregation(pipeline = {
            "{ '$match': { 'isPep': true } }",
            "{ '$group': { '_id': '$firstNameEn', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ $limit: :#{#count} }",
            "{ '$project': { '_id': 0, 'name': '$_id', 'count': 1 } }"
    })
    List<NameCountDto> findTopNPopularNames(@Param("count") int count);

}
