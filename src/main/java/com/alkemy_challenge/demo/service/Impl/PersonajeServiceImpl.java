package com.alkemy_challenge.demo.service.Impl;


import com.alkemy_challenge.demo.dto.PersonajeDTO;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.alkemy_challenge.demo.entity.PersonajeEntity;
import com.alkemy_challenge.demo.mapper.PersonajeMapper;
import com.alkemy_challenge.demo.repository.PersonajeRepository;
import com.alkemy_challenge.demo.service.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonajeServiceImpl implements PersonajeServicio {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired //siempre inyecta dependencias
    private PersonajeRepository personajeRepository;

    @Override
    public PersonajeDTO guardarPersonaje(PersonajeDTO personajeDTO) {
        PersonajeEntity personajeEntity = personajeMapper.toEntity(personajeDTO);
        personajeEntity = personajeRepository.save(personajeEntity);
        return personajeMapper.toDTO(personajeEntity);
    }

    @Override
    public List<PersonajeDTO> leerBdDTO() {
        List<PersonajeEntity> personajeEntities = personajeRepository.findAll();
        return personajeMapper.personajeDTO(personajeEntities);
    }

    @Override
    public PersonajeDTO actualizarPersonaje(Long id, PersonajeDTO personajeDTO) {
        PersonajeEntity personajeEntity = personajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not found id:" + id)
        );
        PersonajeEntity personajeEntityActualizado = personajeMapper.actualizarPersonaje(personajeEntity, personajeDTO);
        PersonajeEntity personajeEntityguardado = personajeRepository.save(personajeEntityActualizado);
        return personajeMapper.toDTO(personajeEntityguardado);
    }

    @Override
    public void borrarPersonaje(Long id) {
        personajeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Id" +id)
        );
        personajeRepository.deleteById(id);
    }
}
