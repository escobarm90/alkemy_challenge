package com.alkemy_challenge.demo.service;

import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeServicio {

    PersonajeDTO guardarPersonaje(PersonajeDTO personajeDTO);

    List<PersonajeDTO> leerBdDTO();

    PersonajeDTO actualizarPersonaje(Long id, PersonajeDTO personajeDTO);

    void borrarPersonaje(Long id);
}
