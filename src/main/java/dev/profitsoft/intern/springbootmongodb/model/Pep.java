package dev.profitsoft.intern.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@FieldNameConstants
@Document("peps")
public class Pep {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("also_known_as_en")
    private String alsoKnownAsEn;

    @JsonProperty("also_known_as_uk")
    private String alsoKnownAsUk;

    @JsonProperty("city_of_birth")
    private String cityOfBirth;

    @JsonProperty("city_of_birth_uk")
    private String cityOfBirthUk;

    @JsonProperty("city_of_birth_en")
    private String cityOfBirthEn;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("died")
    private Boolean died;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("first_name_en")
    private String firstNameEn;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("full_name_en")
    private String fullNameEn;

    @JsonProperty("is_pep")
    private Boolean isPep;

    @JsonProperty("last_job_title")
    private String lastJobTitle;

    @JsonProperty("last_job_title_en")
    private String lastJobTitleEn;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("last_name_en")
    private String lastNameEn;

    @JsonProperty("last_workplace")
    private String lastWorkplace;

    @JsonProperty("last_workplace_en")
    private String lastWorkplaceEn;

    @JsonProperty("names")
    private String names;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("patronymic_en")
    private String patronymicEn;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("reason_of_termination")
    private String reasonOfTermination;

    @JsonProperty("reason_of_termination_en")
    private String reasonOfTerminationEn;

    @JsonProperty("reputation_assets_en")
    private String reputationAssetsEn;

    @JsonProperty("reputation_assets_uk")
    private String reputationAssetsUk;

    @JsonProperty("reputation_convictions_en")
    private String reputationConvictionsEn;

    @JsonProperty("reputation_convictions_uk")
    private String reputationConvictionsUk;

    @JsonProperty("reputation_crimes_en")
    private String reputationCrimesEn;

    @JsonProperty("reputation_crimes_uk")
    private String reputationCrimesUk;

    @JsonProperty("reputation_manhunt_en")
    private String reputationManhuntEn;

    @JsonProperty("reputation_manhunt_uk")
    private String reputationManhuntUk;

    @JsonProperty("reputation_sanctions_en")
    private String reputationSanctionsEn;

    @JsonProperty("reputation_sanctions_uk")
    private String reputationSanctionsUk;

    @JsonProperty("termination_date_human")
    private String terminationDateHuman;

    @JsonProperty("type_of_official")
    private String typeOfOfficial;

    @JsonProperty("type_of_official_en")
    private String typeOfOfficialEn;

    @JsonProperty("url")
    private String url;

    @JsonProperty("wiki_en")
    private String wikiEn;

    @JsonProperty("wiki_uk")
    private String wikiUk;

    @JsonProperty("declarations")
    private List<Declaration> declarations;

    @JsonProperty("related_companies")
    private List<RelatedCompany> relatedCompanies;

    @JsonProperty("related_countries")
    private List<RelatedCountry> relatedCountries;

    @JsonProperty("related_persons")
    private List<RelatedPerson> relatedPersons;

}
