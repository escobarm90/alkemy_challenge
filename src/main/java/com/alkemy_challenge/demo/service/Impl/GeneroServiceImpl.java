package com.alkemy_challenge.demo.service.Impl;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.mapper.GeneroMapper;
import com.alkemy_challenge.demo.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements service.GeneroServicio {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired //siempre inyecta dependencias
    private GeneroRepository generoRepository;
    @Override
    public void guardarGenero(GeneroDTO generoDTO) {
       GeneroEntity generoEntity = generoMapper.toEntity(generoDTO);
       generoRepository.save(generoEntity);
    }

    @Override
    public void leerdb() {

    }
}
