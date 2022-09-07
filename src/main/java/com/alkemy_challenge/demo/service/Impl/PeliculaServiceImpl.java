package com.alkemy_challenge.demo.service.Impl;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.alkemy_challenge.demo.mapper.PeliculaMapper;
import com.alkemy_challenge.demo.repository.PeliculaRepository;
import com.alkemy_challenge.demo.service.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaServicio {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired //siempre inyecta dependencias
    private PeliculaRepository peliculaRepository;
    @Override
    public Pelicula_serieDTO guardarPelicula(Pelicula_serieDTO pelicula_serieDTO) {
        Pelicula_serieEntity pelicula_serieEntity = peliculaMapper.toEntity(pelicula_serieDTO);
        pelicula_serieEntity = peliculaRepository.save(pelicula_serieEntity);
        return peliculaMapper.toDTO(pelicula_serieEntity);
    }

    @Override
    public List<Pelicula_serieDTO> leerBdDTO() {
        List<Pelicula_serieEntity> generoEntities = peliculaRepository.findAll();
        return peliculaMapper.peliculaDTO(generoEntities);
    }

    @Override
    public Pelicula_serieDTO actualizarPelicula(Long id, Pelicula_serieDTO peliculaDTO) {
        return null;
    }

    @Override
    public void borrarPelicula(Long id) {

    }

}
