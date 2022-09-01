package com.alkemy_challenge.demo.mapper;
import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.PersonajeDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.entity.PersonajeEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonajeMapper {
    private ObjectMapper objectMapper; //Objeto de la clase genero mapper

    @Autowired
    public PersonajeMapper(ObjectMapper objectMapper){ //objeto que nos provee springboot a traves de la inyeccion de dependencia a traves de autowired
        this.objectMapper = objectMapper;

    };


    public PersonajeEntity toEntity(PersonajeDTO personajeDTO){
        return objectMapper.convertValue(personajeDTO, PersonajeEntity.class);
    }

    public PersonajeDTO toDTO(PersonajeEntity personajeEntity){
        return objectMapper.convertValue(personajeEntity, PersonajeDTO.class);
    }
}

