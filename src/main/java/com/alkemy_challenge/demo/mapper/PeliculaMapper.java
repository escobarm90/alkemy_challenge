package com.alkemy_challenge.demo.mapper;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMapper {

    private ObjectMapper objectMapper; //Objeto de la clase genero mapper




    @Autowired
    public PeliculaMapper(ObjectMapper objectMapper){ //objeto que nos provee springboot a traves de la inyeccion de dependencia a traves de autowired
        this.objectMapper = objectMapper;

    };


    public Pelicula_serieEntity toEntity(Pelicula_serieDTO pelicula_serieDTO){
        return objectMapper.convertValue(pelicula_serieDTO, Pelicula_serieEntity.class);
    }

    public Pelicula_serieDTO toDTO(Pelicula_serieEntity pelicula_serieEntity){
        return objectMapper.convertValue(pelicula_serieEntity, Pelicula_serieDTO.class);
    }
}
