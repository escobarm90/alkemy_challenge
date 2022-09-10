package com.alkemy_challenge.demo.mapper;


import com.alkemy_challenge.demo.dto.GeneroDTO;
import com.alkemy_challenge.demo.dto.Pelicula_serieDTO;
import com.alkemy_challenge.demo.dto.PersonajeDTO;
import com.alkemy_challenge.demo.entity.GeneroEntity;
import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import com.alkemy_challenge.demo.entity.PersonajeEntity;
import com.alkemy_challenge.demo.repository.GeneroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Component
public class PeliculaMapper {

    private ObjectMapper objectMapper; //Objeto de la clase genero mapper
    private GeneroMapper generoMapper;
    private GeneroRepository generoRepository;

    private PersonajeMapper personajeMapper;




    @Autowired
    public PeliculaMapper(ObjectMapper objectMapper, GeneroMapper generoMapper,
                          GeneroRepository generoRepository,
                          PersonajeMapper personajeMapper){ //objeto que nos provee springboot a traves de la inyeccion de dependencia a traves de autowired
        this.objectMapper = objectMapper;
        this.generoMapper = generoMapper;
        this.generoRepository = generoRepository;
        this.personajeMapper = personajeMapper;
    };


    public Pelicula_serieEntity toEntity(Pelicula_serieDTO pelicula_serieDTO){
        Pelicula_serieEntity peliculaEntity = new Pelicula_serieEntity();
        peliculaEntity.setId(pelicula_serieDTO.getId());
        peliculaEntity.setImagen(pelicula_serieDTO.getImagen());
        peliculaEntity.setTitulo(pelicula_serieDTO.getTitulo());
        peliculaEntity.setCalificacion(pelicula_serieDTO.getCalificacion());
        peliculaEntity.setFecha_creacion(pelicula_serieDTO.getFecha_creacion());
        peliculaEntity.setGeneroId(pelicula_serieDTO.getGeneroId());

        Set<PersonajeEntity> listaPersonajesEntity = personajeMapper.personajeDTOsetEntityList(pelicula_serieDTO.getPersonajeDTOList());
        peliculaEntity.setListaPersonajes(listaPersonajesEntity);
        return peliculaEntity;
    }

    public Pelicula_serieDTO toDTO(Pelicula_serieEntity pelicula_serieEntity){
        Pelicula_serieDTO peliculaDTO = new Pelicula_serieDTO();
        peliculaDTO.setId(pelicula_serieEntity.getId());
        peliculaDTO.setImagen(pelicula_serieEntity.getImagen());
        peliculaDTO.setTitulo(pelicula_serieEntity.getTitulo());
        peliculaDTO.setCalificacion(pelicula_serieEntity.getCalificacion());
        peliculaDTO.setFecha_creacion(pelicula_serieEntity.getFecha_creacion());
        peliculaDTO.setGeneroId(pelicula_serieEntity.getGeneroId());
        peliculaDTO.setGeneroDTO(obtenerGenero(buscarGenero(pelicula_serieEntity)));

        List<PersonajeDTO> listaPersonajesDTO= personajeMapper.personajeEntitySetToDTOList(pelicula_serieEntity.getListaPersonajes());
        peliculaDTO.setPersonajeDTOList(listaPersonajesDTO);
        return peliculaDTO;
    }

    public GeneroDTO obtenerGenero(GeneroEntity generoEntity){
        return generoMapper.toDTO(generoEntity);
    }

    public GeneroEntity buscarGenero(Pelicula_serieEntity peliculaEntity){
        Optional<GeneroEntity> generoEncontrado = generoRepository.findById(peliculaEntity.getGeneroId());
        return generoEncontrado.get();
    }

    public List<Pelicula_serieDTO> peliculaDTO(List<Pelicula_serieEntity> peliculaEntity){
        return peliculaEntity.stream()
                .map(this::toDTO)
                .collect(toList());
    }

    public Pelicula_serieEntity actualizarPelicula(Pelicula_serieEntity peliculaEntity, Pelicula_serieDTO peliculaDTO){
        peliculaEntity.setId(peliculaDTO.getId());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setFecha_creacion(peliculaDTO.getFecha_creacion());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        return peliculaEntity;
    }


}
