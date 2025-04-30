package com.suleaktasyazan.TasteBiteBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Writer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Writer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name="created_date",nullable=false)
    private Date createdDate;


}
