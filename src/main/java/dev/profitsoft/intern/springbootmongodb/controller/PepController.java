package dev.profitsoft.intern.springbootmongodb.controller;

import dev.profitsoft.intern.springbootmongodb.dto.NameCountDto;
import dev.profitsoft.intern.springbootmongodb.dto.PageDto;
import dev.profitsoft.intern.springbootmongodb.dto.PepFullNameQueryDto;
import dev.profitsoft.intern.springbootmongodb.dto.PepInfoDto;
import dev.profitsoft.intern.springbootmongodb.service.PepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/peps")
@RequiredArgsConstructor
public class PepController {

    private final PepService pepService;

    @PostMapping
    public PageDto<PepInfoDto> search(@RequestBody PepFullNameQueryDto query) {
        return pepService.search(query);
    }

    @GetMapping
    public List<NameCountDto> getNPopularNames(@RequestParam("count") int count) {
        return pepService.findNPopularNames(count);
    }

}
