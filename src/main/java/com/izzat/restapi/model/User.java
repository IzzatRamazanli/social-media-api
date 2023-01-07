package com.izzat.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;

    @Size(min = 3, message = "User name must consist of at least 3 characters")
    private String name;

    @Past(message = "Birthdate should be in past")
    private LocalDate birthDate;

}
