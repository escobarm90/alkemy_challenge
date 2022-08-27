package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula_serieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    private String titulo;
    private Date fecha_creacion;
    private Integer calificacion;

}
