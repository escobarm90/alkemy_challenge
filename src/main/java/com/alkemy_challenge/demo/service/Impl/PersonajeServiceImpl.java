package com.alkemy_challenge.demo.service.Impl;


import com.alkemy_challenge.demo.dto.PersonajeDTO;
import com.alkemy_challenge.demo.entity.PersonajeEntity;
import com.alkemy_challenge.demo.mapper.PersonajeMapper;
import com.alkemy_challenge.demo.repository.PersonajeRepository;
import com.alkemy_challenge.demo.service.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonajeServiceImpl implements PersonajeServicio {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired //siempre inyecta dependencias
    private PersonajeRepository personajeRepository;

    @Override
    public void guardarPersonaje(PersonajeDTO personajeDTO) {
        PersonajeEntity personajeEntity = personajeMapper.toEntity(personajeDTO);
        personajeRepository.save(personajeEntity);
    }
}
