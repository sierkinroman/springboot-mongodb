package dev.profitsoft.intern.springbootmongodb.repository;

import dev.profitsoft.intern.springbootmongodb.dto.PepFullNameQueryDto;
import dev.profitsoft.intern.springbootmongodb.model.Pep;
import org.springframework.data.domain.Page;

public interface PepRepositoryCustom {

    Page<Pep> search(PepFullNameQueryDto query);

}
