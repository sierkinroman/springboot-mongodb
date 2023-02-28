package dev.profitsoft.intern.springbootmongodb.service.impl;

import dev.profitsoft.intern.springbootmongodb.dto.NameCountDto;
import dev.profitsoft.intern.springbootmongodb.dto.PageDto;
import dev.profitsoft.intern.springbootmongodb.dto.PepFullNameQueryDto;
import dev.profitsoft.intern.springbootmongodb.dto.PepInfoDto;
import dev.profitsoft.intern.springbootmongodb.model.Pep;
import dev.profitsoft.intern.springbootmongodb.repository.PepRepository;
import dev.profitsoft.intern.springbootmongodb.service.PepService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PepServiceImpl implements PepService {

    private final PepRepository pepRepository;

    @Override
    public PageDto<PepInfoDto> search(PepFullNameQueryDto query) {
        Page<Pep> page = pepRepository.search(query);
        return PageDto.fromPage(page, this::mapPepToPepInfoDto);
    }

    @Override
    public List<NameCountDto> findNPopularNames(int count) {
        return pepRepository.findTopNPopularNames(count);
    }

    private PepInfoDto mapPepToPepInfoDto(Pep pep) {
        return PepInfoDto.builder()
                .id(pep.getId())
                .fullNameEn(pep.getFullNameEn())
                .isPep(pep.getIsPep())
                .url(pep.getUrl())
                .lastJobTitleEn(pep.getLastJobTitleEn())
                .build();
    }
}
