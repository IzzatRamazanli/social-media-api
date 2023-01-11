package com.izzat.restapi.versioning;

import com.izzat.restapi.versioning.util.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonV2 implements Person{
    private Name name;
}
