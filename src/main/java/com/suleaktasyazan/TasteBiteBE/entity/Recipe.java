package com.suleaktasyazan.TasteBiteBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Recipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String rating;

    @Column(name="photo_url",nullable = false)
    private String photoUrl;

    @Column(name="video_url",nullable = false)
    private String videoUrl;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingredients;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String instructions;

    @Column(nullable = false)
    private String description;

    @Column(name="prep_time",nullable = false)
    private String prepTime;

    @Column(nullable = false)
    private int servings;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Writer writer;



}
