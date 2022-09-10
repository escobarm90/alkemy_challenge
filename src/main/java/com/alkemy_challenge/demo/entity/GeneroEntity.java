package com.alkemy_challenge.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genero")
@SQLDelete(sql="UPDATE genero SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;


    private Boolean deleted = Boolean.FALSE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genero", cascade = CascadeType.MERGE)
    private List<Pelicula_serieEntity> peliculasAsociadas;


}
