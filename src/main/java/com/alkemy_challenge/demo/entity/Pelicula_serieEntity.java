package com.alkemy_challenge.demo.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "pelicula")
@SQLDelete(sql="UPDATE pelicula SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Pelicula_serieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    private String titulo;
    private Date fecha_creacion;
    private Integer calificacion;

    private Boolean deleted = Boolean.FALSE;

    //Para traer el genero
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "generoId", insertable = false, updatable = false)
    private GeneroEntity genero;

    //Para guardar o  asociar el genero
    @Column(name = "generoId", nullable = false)
    private Long generoId;

     @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Set<PersonajeEntity> listaPersonajes = new HashSet<>();

     public void agregarPersonajes(PersonajeEntity personajeEntity){
         listaPersonajes.add(personajeEntity);
     }

}
