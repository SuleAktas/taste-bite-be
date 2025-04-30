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
public class DtoRecipe {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Rating cannot be empty")
    private String rating;

    @NotEmpty(message = "Photo cannot be empty")
    private String photoUrl;

    @NotEmpty(message = "Name cannot be empty")
    private String videoUrl;

    @NotEmpty(message = "Ingrediendts cannot be empty")
    private String[] ingredients;

    @NotEmpty(message = "Instructions cannot be empty")
    private String[] instructions;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @NotEmpty(message = "Prep Time cannot be empty")
    private String prepTime;

    @NotEmpty(message = "Servings cannot be empty")
    private int servings;

    private DtoWriter writer;

    private DtoCategory category;
}
