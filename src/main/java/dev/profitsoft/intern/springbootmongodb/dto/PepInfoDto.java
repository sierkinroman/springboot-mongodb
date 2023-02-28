package dev.profitsoft.intern.springbootmongodb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class PepInfoDto {

    private String id;

    private String fullNameEn;

    private Boolean isPep;

    private String url;

    private String lastJobTitleEn;

}
