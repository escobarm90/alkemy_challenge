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

import java.util.*;

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
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setId(personajeEntity.getId());
        personajeDTO.setImagen(personajeEntity.getImagen());
        personajeDTO.setNombre(personajeEntity.getNombre());
        personajeDTO.setEdad(personajeEntity.getEdad());
        personajeDTO.setPeso(personajeEntity.getPeso());
        personajeDTO.setHistoria(personajeEntity.getHistoria());
        return personajeDTO;
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

    public Set<PersonajeEntity> personajeDTOsetEntityList(List<PersonajeDTO> listaPersonaje) {
        Set<PersonajeEntity> listaPersonajesMapper = new HashSet<>();
        PersonajeEntity personajeEntity = new PersonajeEntity();
        for(PersonajeDTO personajeDTO: listaPersonaje){
            personajeEntity.setImagen(personajeDTO.getImagen());
            personajeEntity.setNombre(personajeDTO.getNombre());
            personajeEntity.setEdad(personajeDTO.getEdad());
            personajeEntity.setPeso(personajeDTO.getPeso());
            personajeEntity.setHistoria(personajeDTO.getHistoria());
            listaPersonajesMapper.add(personajeEntity);
        }
        return listaPersonajesMapper;
    }

    public List<PersonajeDTO> personajeEntitySetToDTOList(Collection<PersonajeEntity> entityList){
        List<PersonajeDTO> listaPersonaje = new ArrayList<>();
        for(PersonajeEntity entity: entityList){
         listaPersonaje.add(toDTO(entity));
        }
        return listaPersonaje;
    }
}

