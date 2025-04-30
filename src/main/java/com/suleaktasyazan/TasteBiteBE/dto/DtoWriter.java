package com.suleaktasyazan.TasteBiteBE.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoWriter {

    @NotEmpty(message = "Name cannot be empty")
    private String name;
}
