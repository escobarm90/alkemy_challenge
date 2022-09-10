package com.alkemy_challenge.demo.mapper;
import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.dto.PersonajeDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.alkemy_challenge.demo.entity.PersonajeEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<PersonajeDTO> personajeDTO(List<PersonajeEntity> personajeEntity){
        return personajeEntity.stream()
                .map(this::toDTO)
                .collect(toList());
    }
    public PersonajeEntity actualizarPersonaje(PersonajeEntity personajeEntity, PersonajeDTO personajeDTO){
        personajeEntity.setId(personajeDTO.getId());
        personajeEntity.setNombre(personajeDTO.getNombre());
        personajeEntity.setImagen(personajeDTO.getImagen());
        personajeEntity.setEdad(personajeDTO.getEdad());
        personajeEntity.setPeso(personajeDTO.getPeso());
        personajeEntity.setHistoria(personajeDTO.getHistoria());
        return personajeEntity;
    }

}

