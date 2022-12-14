package com.alkemy_challenge.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Pelicula_serieDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private Date fecha_creacion;
    private Integer calificacion;

    private Long generoId;
    private GeneroDTO generoDTO;
    private List<PersonajeDTO> personajeDTOList;
}
