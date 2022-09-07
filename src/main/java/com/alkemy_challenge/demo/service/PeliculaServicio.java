package com.alkemy_challenge.demo.service;

import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;

import java.util.List;

public interface PeliculaServicio {

    Pelicula_serieDTO guardarPelicula(Pelicula_serieDTO pelicula_serieDTO);

    List<Pelicula_serieDTO> leerBdDTO();

    Pelicula_serieDTO actualizarPelicula(Long id, Pelicula_serieDTO peliculaDTO);

    void borrarPelicula(Long id);
}
