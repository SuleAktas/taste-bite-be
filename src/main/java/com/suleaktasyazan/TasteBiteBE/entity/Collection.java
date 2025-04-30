package com.suleaktasyazan.TasteBiteBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Collection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name="photo_url",nullable = false)
    private String photoUrl;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @ManyToMany
    @JoinTable(name = "recipe_collection",
    joinColumns = @JoinColumn(name = "collection_id"),
    inverseJoinColumns = @JoinColumn(name="recipe_id"))
    private List<Recipe> recipes;
}
