package dev.profitsoft.intern.springbootmongodb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NameCountDto {

    private String name;

    private int count;

}
