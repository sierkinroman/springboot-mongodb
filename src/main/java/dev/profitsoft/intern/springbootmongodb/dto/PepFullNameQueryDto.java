package dev.profitsoft.intern.springbootmongodb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PepFullNameQueryDto extends QueryDto {

    private String firstNameEn;

    private String lastNameEn;

    private String patronymicEn;

}
