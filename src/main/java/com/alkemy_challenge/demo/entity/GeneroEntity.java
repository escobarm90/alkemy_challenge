package com.alkemy_challenge.demo.entity;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "genero")
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;


}
