package com.alkemy_challenge.demo.service.Impl;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.mapper.GeneroMapper;
import com.alkemy_challenge.demo.repository.GeneroRepository;
import com.alkemy_challenge.demo.service.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroServicio {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired //siempre inyecta dependencias
    private GeneroRepository generoRepository;
    @Override
    public GeneroDTO guardarGenero(GeneroDTO generoDTO) {
       GeneroEntity generoEntity = generoMapper.toEntity(generoDTO);
       generoEntity = generoRepository.save(generoEntity);
       return generoMapper.toDTO(generoEntity);
    }

    @Override
    public List<GeneroDTO> leerBdDTO() {
        List<GeneroEntity> generoEntities = generoRepository.findAll();
        return generoMapper.listaDTO(generoEntities);
    }

    @Override
    public GeneroDTO actualizarGenero(Long id, GeneroDTO generoDTO){
        GeneroEntity generoEntity = generoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not found id:" + id)
        );
        GeneroEntity generoEntityActualizado = generoMapper.actualizarGenero(generoEntity, generoDTO);
        GeneroEntity generoEntityguardado = generoRepository.save(generoEntityActualizado);
        return generoMapper.toDTO(generoEntityguardado);
    }

    @Override
    public void borrarGenero(Long id) {
        generoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Id" +id)
                );
        generoRepository.deleteById(id);
    }


}
