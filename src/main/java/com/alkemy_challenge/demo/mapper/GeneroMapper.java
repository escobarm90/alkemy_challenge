package com.alkemy_challenge.demo.mapper;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component //Todas las anotaciones derivan de component
public class GeneroMapper {

    private ObjectMapper objectMapper; //Objeto de la clase genero mapper




    @Autowired
    public GeneroMapper(ObjectMapper objectMapper){ //objeto que nos provee springboot a traves de la inyeccion de dependencia a traves de autowired
        this.objectMapper = objectMapper;

    };


    public GeneroEntity toEntity(GeneroDTO generoDTO){
        return objectMapper.convertValue(generoDTO, GeneroEntity.class);
    }

    public GeneroDTO toDTO(GeneroEntity generoEntity){
        return objectMapper.convertValue(generoEntity, GeneroDTO.class);
    }

    public List<GeneroDTO> listaDTO(List<GeneroEntity> generoEntity){
        /*List<GeneroDTO> listaDTO = new ArrayList<>();
        for(GeneroEntity genero: generoEntity){
            listaDTO.add(toDTO(genero));
        }
        return listaDTO;*/
        return generoEntity.stream()
                //.map(this::toDTO)
                .map(genero -> toDTO(genero))
                .collect(toList());
    }

    public GeneroEntity actualizarGenero(GeneroEntity generoEntity, GeneroDTO generoDTO){
        generoEntity.setId(generoDTO.getId());
        generoEntity.setNombre(generoDTO.getNombre());
        generoEntity.setImagen(generoDTO.getImagen());
        return generoEntity;
    }


    /*   GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(generoEntity.getNombre());
        generoEntity.setNombre(generoDTO.getNombre());
        return generoEntity;
    }*/
}
