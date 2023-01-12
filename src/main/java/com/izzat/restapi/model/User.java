package com.izzat.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "user")
public class User {

    @JsonProperty("user-id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Size(min = 3, message = "User name must consist of at least 3 characters")
    @JsonProperty("user-name")
    @Column(name = "full_name", nullable = false)
    private String name;

    @Past(message = "Birthdate should be in past")
    @JsonProperty("birth-date")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
