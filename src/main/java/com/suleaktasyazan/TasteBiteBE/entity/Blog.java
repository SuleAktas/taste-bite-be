package com.suleaktasyazan.TasteBiteBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Blog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name="video_url",nullable = false)
    private String videoUrl;

    @Column(name="photo_url",nullable = false)
    private String photoUrl;

    @Column(name="photo_url2",nullable = false)
    private String photoUrl2;

    @Column(name="photo_url3",nullable = false)
    private String photoUrl3;

    @Column(nullable = false)
    private String text;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @ManyToOne
    private Writer writer;
}
