package com.alkemy_challenge.demo.repository;


import com.alkemy_challenge.demo.entity.Pelicula_serieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula_serieEntity, Long> {
}

