package com.suleaktasyazan.TasteBiteBE.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoRecipeIU {

    private String name;


    private String rating;


    private String photoUrl;


    private String videoUrl;


    private String[] ingredients;


    private String[] instructions;


    private String description;


    private String prepTime;


    private int servings;
}
