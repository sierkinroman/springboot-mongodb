package dev.profitsoft.intern.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Declaration {

    @JsonProperty("family_income")
    private double familyIncome;

    @JsonProperty("income")
    private double income;

    @JsonProperty("office_en")
    private String officeEn;

    @JsonProperty("office_uk")
    private String officeUk;

    @JsonProperty("position_en")
    private String positionEn;

    @JsonProperty("position_uk")
    private String positionUk;

    @JsonProperty("region_en")
    private String regionEn;

    @JsonProperty("region_uk")
    private String regionUk;

    @JsonProperty("url")
    private String url;

    @JsonProperty("year")
    private String year;

}
