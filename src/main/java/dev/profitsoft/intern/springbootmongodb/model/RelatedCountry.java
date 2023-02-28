package dev.profitsoft.intern.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RelatedCountry {

    @JsonProperty("date_confirmed")
    private String dateConfirmed;

    @JsonProperty("date_established")
    private String dateEstablished;

    @JsonProperty("date_finished")
    private String dateFinished;

    @JsonProperty("relationship_type")
    private String relationshipType;

    @JsonProperty("to_country_en")
    private String toCountryEn;

    @JsonProperty("to_country_uk")
    private String toCountryUk;

}
