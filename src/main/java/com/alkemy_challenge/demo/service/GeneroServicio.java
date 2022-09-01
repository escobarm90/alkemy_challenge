
package com.alkemy_challenge.demo.service;

import com.alkemy_challenge.demo.dto.GeneroDTO;

import java.util.List;


public interface GeneroServicio {

    GeneroDTO guardarGenero(GeneroDTO generoDTO);

    List<GeneroDTO> leerBdDTO();

    GeneroDTO actualizarGenero(Long id, GeneroDTO generoDTO);

    void borrarGenero(Long id);
}
