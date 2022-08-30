package com.alkemy_challenge.demo.entity;
import dto.Pelicula_serieDTO;
import lombok.Data;
import javax.persistence.*;


@Data //Genera setter y getters, toString, equals,hashcode
@Entity //Indica que esta clase corresponde a la tabla de nuestra base de datos a traves de hibernate
@Table(name = "personaje") //nombre de la tabla
public class PersonajeEntity {

    @Id //indica que este atributo va a ser el id en la tabla de la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) //de que manera lo genera, identity le asigna el mismo valor a cada instancia de la clase
    private Long id;

    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

}
