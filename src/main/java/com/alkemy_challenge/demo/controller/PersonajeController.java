package com.alkemy_challenge.demo.controller;

import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.dto.PersonajeDTO;
import com.alkemy_challenge.demo.service.PeliculaServicio;
import com.alkemy_challenge.demo.service.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired //Solamente nos comunicamos con la interfaz servicio desde el controlador
    private PersonajeServicio personajeServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearPersonaje(@RequestBody PersonajeDTO personajeDTO){
        PersonajeDTO personajedto = personajeServicio.guardarPersonaje(personajeDTO);
        return new ResponseEntity<>(personajedto, HttpStatus.CREATED);
    }
    @GetMapping("/leer")
    public ResponseEntity<?> leerBd(){
        return new ResponseEntity<>(personajeServicio.leerBdDTO(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarBd(@PathVariable Long id,@RequestBody PersonajeDTO personajeDTO){
        return new ResponseEntity<>(personajeServicio.actualizarPersonaje(id, personajeDTO),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPersonaje(@PathVariable Long id){
        personajeServicio.borrarPersonaje(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
