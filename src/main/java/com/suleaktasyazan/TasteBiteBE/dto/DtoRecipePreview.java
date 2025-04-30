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
public class DtoRecipePreview {

    private Long id;

    private String name;

    private String rating;

    private String description;

    private String photoUrl;

    private String videoUrl;

}
