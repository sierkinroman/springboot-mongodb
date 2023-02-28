package dev.profitsoft.intern.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RelatedPerson {

    @JsonProperty("date_confirmed")
    private String dateConfirmed;

    @JsonProperty("date_established")
    private String dateEstablished;

    @JsonProperty("date_finished")
    private String dateFinished;

    @JsonProperty("is_pep")
    private boolean isPep;

    @JsonProperty("person_en")
    private String personEn;

    @JsonProperty("person_uk")
    private String personUk;

    @JsonProperty("relationship_type")
    private String relationshipType;

    @JsonProperty("relationship_type_en")
    private String relationshipTypeEn;

}
