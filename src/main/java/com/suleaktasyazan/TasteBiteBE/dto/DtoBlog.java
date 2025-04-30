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
public class DtoBlog {

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @NotEmpty(message = "Video cannot be empty")
    private String videoUrl;

    @NotEmpty(message = "Photo cannot be empty")
    private String photoUrl;

    @NotEmpty(message = "Photo2 cannot be empty")
    private String photoUrl2;

    @NotEmpty(message = "Photo3 cannot be empty")
    private String photoUrl3;

    @NotEmpty(message = "Text cannot be empty")
    private String text;

    private DtoWriter writer;

}
