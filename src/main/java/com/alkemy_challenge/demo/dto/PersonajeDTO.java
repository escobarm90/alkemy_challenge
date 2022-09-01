package com.alkemy_challenge.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonajeDTO {

    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

}
