package com.alkemy_challenge.demo.mapper;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<Pelicula_serieDTO> peliculaDTO(List<Pelicula_serieEntity> peliculaEntity){
        return peliculaEntity.stream()
                .map(this::toDTO)
                .collect(toList());
    }

    public Pelicula_serieEntity actualizarPelicula(Pelicula_serieEntity peliculaEntity, Pelicula_serieDTO peliculaDTO){
        peliculaEntity.setId(peliculaDTO.getId());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setFecha_creacion(peliculaDTO.getFecha_creacion());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        return peliculaEntity;
    }


}
