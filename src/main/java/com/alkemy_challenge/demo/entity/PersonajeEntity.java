package com.alkemy_challenge.demo.entity;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data //Genera setter y getters, toString, equals,hashcode
@Entity //Indica que esta clase corresponde a la tabla de nuestra base de datos a traves de hibernate
@Table(name = "personaje") //nombre de la tabla
@SQLDelete(sql="UPDATE personaje SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class PersonajeEntity {

    @Id //indica que este atributo va a ser el id en la tabla de la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) //de que manera lo genera, identity le asigna el mismo valor a cada instancia de la clase

    private Long id;

    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

    private Boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "listaPersonajes", cascade = CascadeType.PERSIST)
    private List<Pelicula_serieEntity> listaPeliculas = new ArrayList<>();

}
