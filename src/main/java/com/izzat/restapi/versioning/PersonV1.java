package com.izzat.restapi.versioning;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonV1 implements Person {
    @NotBlank
    @Size(min = 3)
    private String fullName;
}
