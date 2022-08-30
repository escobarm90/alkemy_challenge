package com.alkemy_challenge.demo.mapper;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    /*   GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(generoEntity.getNombre());
        generoEntity.setNombre(generoDTO.getNombre());
        return generoEntity;
    }*/
}
