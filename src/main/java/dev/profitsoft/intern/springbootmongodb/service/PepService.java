package dev.profitsoft.intern.springbootmongodb.service;

import dev.profitsoft.intern.springbootmongodb.dto.NameCountDto;
import dev.profitsoft.intern.springbootmongodb.dto.PageDto;
import dev.profitsoft.intern.springbootmongodb.dto.PepFullNameQueryDto;
import dev.profitsoft.intern.springbootmongodb.dto.PepInfoDto;

import java.util.List;

public interface PepService {

    PageDto<PepInfoDto> search(PepFullNameQueryDto query);

    List<NameCountDto> findNPopularNames(int count);

}
