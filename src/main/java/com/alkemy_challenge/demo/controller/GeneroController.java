package com.alkemy_challenge.demo.controller;

import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.service.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired //Solamente nos comunicamos con la interfaz servicio desde el controlador
    private GeneroServicio generoServicio;

     @PostMapping("/crear")
    public ResponseEntity<?> crearGenero(@RequestBody GeneroDTO generoDTO){
         GeneroDTO generodto = generoServicio.guardarGenero(generoDTO);
         return new ResponseEntity<>(generodto, HttpStatus.CREATED);
     }

     @GetMapping   ("/leer")
    public ResponseEntity<?> leerBd(){
         return new ResponseEntity<>(generoServicio.leerBdDTO(),HttpStatus.OK);
     }

     @PutMapping("/{id}")
     public ResponseEntity<?> actualizarBd(@PathVariable Long id,@RequestBody GeneroDTO generoDTO){
         return new ResponseEntity<>(generoServicio.actualizarGenero(id, generoDTO),HttpStatus.CREATED);
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarGenero(@PathVariable Long id){
         generoServicio.borrarGenero(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
