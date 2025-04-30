package com.suleaktasyazan.TasteBiteBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name="photo_url",nullable = false)
    private String photoUrl;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;
}
