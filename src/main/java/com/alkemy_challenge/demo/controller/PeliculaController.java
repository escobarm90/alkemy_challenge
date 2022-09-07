package com.alkemy_challenge.demo.controller;

import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.service.GeneroServicio;
import com.alkemy_challenge.demo.service.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired //Solamente nos comunicamos con la interfaz servicio desde el controlador
    private PeliculaServicio peliculaServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearPelicula(@RequestBody Pelicula_serieDTO peliculaDTO){
        Pelicula_serieDTO peliculadto = peliculaServicio.guardarPelicula(peliculaDTO);
        return new ResponseEntity<>(peliculadto, HttpStatus.CREATED);
    }
}
