package com.projetreactjs.demo.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
@Data

@NoArgsConstructor




@Builder(builderClassName = "StudentBuilder")
@JsonDeserialize(builder = Student.StudentBuilder.class)
@AllArgsConstructor
public class Student {
    @JsonProperty("id")

    private UUID id;

    @JsonProperty("nom")
    @NotBlank
    private String nom;

    @JsonProperty("prenom")
    @NotBlank(message = "Le nom n'est pas null")
    private String prenom;
    @JsonProperty("dateNaiss")
    @NotBlank
    private String dateNaiss;
    @JsonProperty("filiere")
    @NotBlank
    private  String filiere;
    @JsonProperty("niveau")
    @NotBlank
    private String niveau;
    @JsonProperty("email")
    @NotBlank
    @Email
    private String email;
    @JsonProperty("sexe")
    @NotNull
    private Gender sexe;
    public enum Gender {
        Male , Female, MALE , FEMALE
    }
    //private LocalDate dateNaissance;


}
