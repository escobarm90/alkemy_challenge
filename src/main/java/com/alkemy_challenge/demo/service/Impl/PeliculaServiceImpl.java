package com.alkemy_challenge.demo.service.Impl;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.alkemy_challenge.demo.mapper.PeliculaMapper;
import com.alkemy_challenge.demo.repository.PeliculaRepository;
import com.alkemy_challenge.demo.service.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaServicio {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired //siempre inyecta dependencias
    private PeliculaRepository peliculaRepository;
    @Override
    public void guardarPelicula(Pelicula_serieDTO pelicula_serieDTO) {
        Pelicula_serieEntity pelicula_serieEntity = peliculaMapper.toEntity(pelicula_serieDTO);
        peliculaRepository.save(pelicula_serieEntity);
    }
}
