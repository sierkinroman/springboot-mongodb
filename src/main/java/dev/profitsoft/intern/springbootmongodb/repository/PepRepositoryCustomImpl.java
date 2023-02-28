package dev.profitsoft.intern.springbootmongodb.repository;

import dev.profitsoft.intern.springbootmongodb.dto.PepFullNameQueryDto;
import dev.profitsoft.intern.springbootmongodb.model.Pep;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class PepRepositoryCustomImpl implements PepRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public Page<Pep> search(PepFullNameQueryDto query) {
        PageRequest pageRequest = PageRequest.of(
                query.getPage(),
                query.getSize(),
                Sort.by(Sort.Direction.ASC, Pep.Fields.id)
        );

        Query mongoQuery = new Query().with(pageRequest);
        if (StringUtils.isNoneBlank(query.getFirstNameEn())) {
            mongoQuery.addCriteria(where(Pep.Fields.firstNameEn).is(query.getFirstNameEn()));
        }
        if (StringUtils.isNotBlank(query.getLastNameEn())) {
            mongoQuery.addCriteria(where(Pep.Fields.lastNameEn).is(query.getLastNameEn()));
        }
        if (StringUtils.isNotBlank(query.getPatronymicEn())) {
            mongoQuery.addCriteria(where(Pep.Fields.patronymicEn).is(query.getPatronymicEn()));
        }

        final List<Pep> peps = mongoTemplate.find(mongoQuery, Pep.class);

        return PageableExecutionUtils.getPage(
                peps,
                pageRequest,
                () -> mongoTemplate.count((Query.of(mongoQuery).limit(-1).skip(-1)), Pep.class)
        );
    }

}
