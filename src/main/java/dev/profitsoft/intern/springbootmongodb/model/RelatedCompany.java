package dev.profitsoft.intern.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RelatedCompany {

    @JsonProperty("date_confirmed")
    private String dateConfirmed;

    @JsonProperty("date_established")
    private String dateEstablished;

    @JsonProperty("date_finished")
    private String dateFinished;

    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;

    @JsonProperty("relationship_type_uk")
    private String relationshipTypeUk;

    @JsonProperty("share")
    private String share;

    @JsonProperty("to_company_edrpou")
    private String toCompanyEdrpou;

    @JsonProperty("to_company_en")
    private String toCompanyEn;

    @JsonProperty("to_company_founded")
    private String toCompanyFounded;

    @JsonProperty("to_company_is_state")
    private String toCompanyIsState;

    @JsonProperty("to_company_short_en")
    private String toCompanyShortEn;

    @JsonProperty("to_company_short_uk")
    private String toCompanyShortUk;

    @JsonProperty("to_company_uk")
    private String toCompanyUk;

}
