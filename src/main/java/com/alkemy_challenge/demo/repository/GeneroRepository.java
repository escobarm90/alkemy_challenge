package com.alkemy_challenge.demo.repository;

import com.alkemy_challenge.demo.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Long> {
}
//Actualmente tengo predefinida las consultas basicas a la base de datos
